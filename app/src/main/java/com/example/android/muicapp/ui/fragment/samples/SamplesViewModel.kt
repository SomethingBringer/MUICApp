package com.example.android.muicapp.ui.fragment.samples

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.muicapp.models.ActionID
import com.example.android.muicapp.models.CategoryID
import com.example.android.muicapp.models.SampleCategory
import com.example.android.muicapp.models.SampleSubcategory
import javax.inject.Inject

class SamplesViewModel @Inject constructor() : ViewModel() {

    val samplesList = MutableLiveData<List<SampleCategory>>()

    fun fetchSamples() {
        val buttonsSublist = mutableListOf<SampleSubcategory>()
        buttonsSublist.add(SampleSubcategory("Basic", ActionID.BUTTONS_BASIC))
        buttonsSublist.add(SampleSubcategory("Custom", ActionID.BUTTONS_CUSTOM))
        buttonsSublist.add(SampleSubcategory("Fab More Actions", ActionID.BUTTONS_FAB))
        val slidersSubList = mutableListOf<SampleSubcategory>()
        slidersSubList.add(SampleSubcategory("Light", ActionID.SLIDERS_LIGHT))
        slidersSubList.add(SampleSubcategory("Dark", ActionID.SLIDERS_DARK))
        slidersSubList.add(SampleSubcategory("Switches", ActionID.SLIDERS_SWITCH))
        val notificationSubList = mutableListOf<SampleSubcategory>()
        notificationSubList.add(SampleSubcategory("Basic", ActionID.NOTIFICATION_BASIC))
        notificationSubList.add(SampleSubcategory("Toasts Custom", ActionID.NOTIFICATION_TOASTS))
        notificationSubList.add(SampleSubcategory("Snackbars Custom", ActionID.NOTIFICATION_SNACKS))
        val list = mutableListOf<SampleCategory>()
        list.add(
            SampleCategory("Buttons", CategoryID.BUTTONS, buttonsSublist)
        )
        list.add(
            SampleCategory("Sliders", CategoryID.SLIDERS, slidersSubList)
        )
        list.add(
            SampleCategory("Snackbars & Toasts", CategoryID.NOTIFICATION, notificationSubList)
        )
        samplesList.postValue(list.toList())
    }

}