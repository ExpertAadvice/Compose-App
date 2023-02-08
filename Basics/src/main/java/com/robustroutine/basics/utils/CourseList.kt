package com.robustroutine.basics.utils

object CourseList {

    fun getList() : ArrayList<String> {
        val list = ArrayList<String>()

        list.add("Tab Layout")
        list.add("Navigation Drawer")
        list.add("Permission Handling")

        return list
    }
}