package com.komputation.models.Parser

import java.net.HttpURLConnection
import java.net.URL

class DifferentationStrategy : Strategy {
    override fun execute(input: String): String {
        val appid = "" // Replace with your appid
        var response =""
        var actual_response ="" // DELETE LATER
        var adjusted_input = input.replace("+", "%2B")
        adjusted_input = adjusted_input.replace(" ", "+")
        val url = URL("http://api.wolframalpha.com/v2/query?input=($adjusted_input)'&appid=$appid")  //TODO Whitespace replacement

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"  // optional default is GET

            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

            inputStream.bufferedReader().use {
                it.lines().forEach { line ->
                    run {
                        response += line
                        if(line.contains("d/dx") && line.contains("plaintext")) actual_response = line // КОСТЫЛЬ
                    }
                }

            }
        }
        actual_response = actual_response.substring(actual_response.indexOf('=')+1, actual_response.length-12)
        println(actual_response)
        return actual_response
    }
}