package com.example.android.muicapp.models

data class SampleCategory(
    val name: String,
    val categoryID: CategoryID,
    val subList: List<SampleSubcategory>
)
