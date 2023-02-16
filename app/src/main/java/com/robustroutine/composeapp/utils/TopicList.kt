package com.robustroutine.composeapp.utils

object TopicList {

    fun getList() : ArrayList<String> {
        val list = ArrayList<String>()

        list.add("Authentication")
        list.add("Compose Basics")

        return list
    }
}