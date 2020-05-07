package com.softaai.synerzipassignment.network

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class ApiResponseTest {

    @Test
    fun exception() {
        val exception = Exception("exception")
        val apiResponse = ApiResponse.error<String>(exception)
        assertThat(apiResponse.message, `is`("exception"))
    }

    @Test
    fun success() {
        val apiResponse = ApiResponse.of { Response.success("success") }
        if (apiResponse is ApiResponse.Success) {
            assertThat(apiResponse.data, `is`("success"))
        }
    }
}