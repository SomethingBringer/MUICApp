package com.example.android.muicapp.ui.fragment.samples

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.muicapp.models.ActionID
import com.example.android.muicapp.models.CategoryID
import com.example.android.muicapp.models.SampleCategory
import com.example.android.muicapp.models.SampleSubcategory
import javax.inject.Inject

class SamplesViewModel @Inject constructor(): ViewModel() {

    val samplesList = MutableLiveData<List<SampleCategory>>()

    fun fetchSamples(){
        val buttonsSublist = mutableListOf<SampleSubcategory>()
        buttonsSublist.add(SampleSubcategory("Basic", ActionID.BUTTONS_BASIC))
        buttonsSublist.add(SampleSubcategory("Custom", ActionID.BUTTONS_CUSTOM))
        val list = mutableListOf<SampleCategory>()
        list.add(
            SampleCategory("Buttons",CategoryID.BUTTONS,buttonsSublist)
        )
        samplesList.postValue(list.toList())
    }

}