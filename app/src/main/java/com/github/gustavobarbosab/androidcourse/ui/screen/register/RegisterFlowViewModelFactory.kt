package com.github.gustavobarbosab.androidcourse.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthday.RegisterBirthdayViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.RegisterNameViewModel

object RegisterFlowViewModelFactory {

    @Suppress("UNCHECKED_CAST")
    fun provideFactory(
        repository: RegisterFlowRepository
    ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T = when {
            modelClass.isAssignableFrom(RegisterNameViewModel::class.java) -> RegisterNameViewModel(
                repository
            )
            modelClass.isAssignableFrom(RegisterBirthdayViewModel::class.java) -> RegisterBirthdayViewModel(
                repository
            )
            else -> throw UnsupportedOperationException()
        } as T

    }
}