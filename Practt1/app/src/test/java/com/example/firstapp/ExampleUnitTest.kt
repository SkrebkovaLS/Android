package com.example.firstapp

import android.util.Log
import okhttp3.HttpUrl
import okhttp3.OkHttp
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.json.JSONObject
import org.junit.After
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    lateinit var mockWebServer: MockWebServer
    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.enqueue(MockResponse()
            .addHeader("Content-Type", "application/json; charset=utf-8")
            .addHeader("Cache-Control", "no-cache")
            .setBody(""" {"gg" : "gg"} """))
        mockWebServer.start()
    }
    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
    @Test
    fun isNotNul_category(){
        val tested = gg()
        val url = mockWebServer.url("/").toString()
        var myResponse = tested.fts(url)
        assertEquals(JSONObject(myResponse.body!!.string()).get("gg"),null)

    }
}