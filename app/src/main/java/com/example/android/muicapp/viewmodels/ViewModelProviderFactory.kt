package com.example.android.muicapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Suppress("UNCHECKED_CAST")
class ViewModelProviderFactory @Inject constructor(
    val creators: Map<Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>
) :
    ViewModelProvider.Factory {

    companion object {
        private val TAG = "VewModelProviderFactory"
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator = creators.get(modelClass)
        if (creator == null) {
            for ((key, value) in creators.entries) {

                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class" + modelClass.toString())
        }
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}