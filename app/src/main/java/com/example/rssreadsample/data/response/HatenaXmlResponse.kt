package com.example.rssreadsample.data.response

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(strict = false)
class HatenaXmlResponse(
        @field: Element(name = "channel")
        var channel: Channel? = null,

        @field: ElementList(name = "item", inline = true)
        var itemList: List<Item>? = null
) {
    @Root(strict = false)
    class Channel(
            @field: Element(name = "title")
            var title: String? = null,

            @field: Element(name = "link")
            var link: String? = null,

            @field: Element(name = "description")
            var description: String? = null
    )

    @Root(strict = false)
    class Item(
            @field: Element(name = "title", required = false)
            var title: String? = null,

            @Element(name = "link")
            @field: Element(name = "link", required = false)
            var link: String? = null,

            @field: Element(name = "description", required = false)
            var description: String? = null,

            @field: Element(name = "date", required = false)
            var date: String? = null,

            @field: Element(name = "bookmarkcount", required = false)
            var bookmarkCount: Int? = null
    )
}
