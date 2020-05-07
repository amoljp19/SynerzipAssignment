package com.softaai.synerzipassignment.utils

import com.softaai.synerzipassignment.model.*

object MockTestUtil {

    fun mockEntry() = Entry(
        category = Category(
            attributes = Attributes(
                imId = "6023",
                label = "Food & Drink",
                scheme = "https://apps.apple.com/us/genre/ios-food-drink/id6023?uo=2",
                term = "Food & Drink"
            )
        ),
        id = Id(
            attributes = AttributesX(
                imBundleId = "com.t2s.melbournegrill808333",
                imId = "1510016422"
            ), label = "https://apps.apple.com/us/app/melbourne-grill/id1510016422?uo=2"
        ),
        imArtist = ImArtist(
            attributes = AttributesXX(href = "https://apps.apple.com/us/developer/raja-daniyal/id1471757093?uo=2"),
            label = "Raja Daniyal"
        ),
        imContentType = ImContentType(
            attributes = AttributesXXX(
                label = "Application",
                term = "Application"
            )
        ),
        imImage = listOf(
            ImImage(
                attributes = AttributesXXXX(height = "53"),
                label = "https://is1-ssl.mzstatic.com/image/thumb/Purple113/v4/d2/60/2c/d2602c66-3067-fbad-8e1d-f635fa19e512/AppIcon-Customerapp-0-0-1x_U007emarketing-0-0-0-7-0-0-85-220.png/53x53bb.png"
            ),
            ImImage(
                attributes = AttributesXXXX(height = "75"),
                label = "https://is2-ssl.mzstatic.com/image/thumb/Purple113/v4/d2/60/2c/d2602c66-3067-fbad-8e1d-f635fa19e512/AppIcon-Customerapp-0-0-1x_U007emarketing-0-0-0-7-0-0-85-220.png/75x75bb.png"
            ),
            ImImage(
                attributes = AttributesXXXX(height = "100"),
                label = "https://is5-ssl.mzstatic.com/image/thumb/Purple113/v4/d2/60/2c/d2602c66-3067-fbad-8e1d-f635fa19e512/AppIcon-Customerapp-0-0-1x_U007emarketing-0-0-0-7-0-0-85-220.png/100x100bb.png"
            )
        ),
        imName = ImName(label = "Melbourne Grill"),
        imPrice = ImPrice(
            attributes = AttributesXXXXX(amount = "0.00000", currency = "USD"),
            label = "Get"
        ),
        imReleaseDate = ImReleaseDate(
            attributes = AttributesXXXXXX(label = "May 6, 2020"),
            label = "2020-05-06T11:57:57-07:00"
        ),
        link = Link(
            attributes = AttributesXXXXXXX(
                href = "https://apps.apple.com/us/app/melbourne-grill/id1510016422?uo=2",
                rel = "alternate",
                type = "text/html"
            )
        ),
        rights = Rights(label = "© Ads 2020"),
        title = Title(label = "Melbourne Grill - Raja Daniyal")
    )

    fun mockEntryList() = listOf(mockEntry())

    fun mockApiFeedResponse() = ApiFeedResponse(
        feed = Feed(
            author = Author(
                name = Name(label = "iTunes Store"),
                uri = Uri(label = "http://www.apple.com/itunes/")
            ),
            entry = mockEntryList(),
            icon = Icon(label = "http://itunes.apple.com/favicon.ico"),
            id = IdX(label = "https://itunes.apple.com/us/rss/newfreeapplications/limit=2/json"),
            link = listOf(
                LinkX(
                    attributes = AttributesXXXXXXXX(
                        href = "https://itunes.apple.com/WebObjects/MZStore.woa/wa/storeFront?cc=us",
                        rel = "alternate"
                    )
                )
            ),
            rights = RightsX(label = "Copyright 2008 Apple Inc."),
            title = TitleX(label = "iTunes Store: New Free Applications"),
            updated = Updated(label = "2020-05-07T02:46:20-07:00")

        )
    )
}