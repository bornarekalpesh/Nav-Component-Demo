package com.example.navcomponentdemo.model

data class TestingData(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)