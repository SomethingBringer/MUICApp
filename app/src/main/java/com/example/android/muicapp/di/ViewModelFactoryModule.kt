package com.example.android.muicapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.muicapp.ui.fragment.about.AboutViewModel
import com.example.android.muicapp.ui.fragment.buttons.basic.ButtonsBasicViewModel
import com.example.android.muicapp.ui.fragment.buttons.custom.ButtonsCustomViewModel
import com.example.android.muicapp.ui.fragment.buttons.fab.FabMoreActionsViewModel
import com.example.android.muicapp.ui.fragment.samples.SamplesViewModel
import com.example.android.muicapp.viewmodels.ViewModelKey
import com.example.android.muicapp.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule() {

    @Binds
    internal abstract fun bind(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SamplesViewModel::class)
    abstract fun bindSamplesViewModel(viewModel: SamplesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutViewModel::class)
    abstract fun bindAboutViewModel(viewModel: AboutViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ButtonsBasicViewModel::class)
    abstract fun bindButtonsBasicViewModel(viewModel: ButtonsBasicViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ButtonsCustomViewModel::class)
    abstract fun bindButtonsCustomViewModel(viewModel: ButtonsCustomViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FabMoreActionsViewModel::class)
    abstract fun bindFabMoreActionsViewModel(viewModel: FabMoreActionsViewModel): ViewModel
}