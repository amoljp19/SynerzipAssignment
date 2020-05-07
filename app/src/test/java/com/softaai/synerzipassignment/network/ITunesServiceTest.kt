package com.softaai.synerzipassignment.network

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.softaai.synerzipassignment.model.ApiFeedResponse
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import java.io.IOException

class ITunesServiceTest : ApiAbstract<ITunesService>() {

    private lateinit var service: ITunesService
    private val client: ITunesClient = mock()

    @Before
    fun initService() {
        service = createService(ITunesService::class.java)
    }

    @Throws(IOException::class)
    @Test
    fun fetchFeedEntryListTest() {
        enqueueResponse("/ApiFeedResponse.json")

        val responseBody = requireNotNull(service.fetchApiFeedResponse().execute().body())
        mockWebServer.takeRequest()

        assertThat(responseBody.feed.entry[0].imName.label, `is`("TSA Bozeman"))
        assertThat(responseBody.feed.entry[0].category.attributes.label, `is`("Lifestyle"))
        assertThat(responseBody.feed.entry[0].imPrice.attributes.amount, `is`("0.00000"))

        val onResult: (response: ApiResponse<ApiFeedResponse>) -> Unit = {
            assertThat(it, instanceOf(ApiResponse.Success::class.java))
            val response: ApiFeedResponse = requireNotNull((it as ApiResponse.Success).data)
            assertThat(response.feed.entry[0].imName.label, `is`("TSA Bozeman"))
            assertThat(response.feed.entry[0].category.attributes.label, `is`("Lifestyle"))
            assertThat(response.feed.entry[0].imPrice.attributes.amount, `is`("0.00000"))

        }

        whenever(client.fetchApiFeedResponse(onResult)).thenAnswer {
            val response: (response: ApiResponse<ApiFeedResponse>) -> Unit = it.getArgument(0)
            response(ApiResponse.Success(Response.success(responseBody)))
        }

        client.fetchApiFeedResponse(onResult)
    }
}