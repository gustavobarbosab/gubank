package com.github.gustavobarbosab.androidcourse.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.birthdate.RegisterBirthdateViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.document.RegisterDocumentViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.RegisterNameViewModel
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.resume.RegisterResumeViewModel

object RegisterFlowViewModelFactory {

    @Suppress("UNCHECKED_CAST")
    fun provideFactory(
        repository: RegisterFlowRepository
    ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T = when {
            modelClass.isAssignableFrom(RegisterFlowViewModel::class.java) -> RegisterFlowViewModel(
                repository
            )
            modelClass.isAssignableFrom(RegisterNameViewModel::class.java) -> RegisterNameViewModel(
                repository
            )
            modelClass.isAssignableFrom(RegisterBirthdateViewModel::class.java) -> RegisterBirthdateViewModel(
                repository
            )
            modelClass.isAssignableFrom(RegisterDocumentViewModel::class.java) -> RegisterDocumentViewModel(
                repository
            )
            modelClass.isAssignableFrom(RegisterResumeViewModel::class.java) -> RegisterResumeViewModel(
                repository
            )
            else -> throw UnsupportedOperationException()
        } as T

    }
}