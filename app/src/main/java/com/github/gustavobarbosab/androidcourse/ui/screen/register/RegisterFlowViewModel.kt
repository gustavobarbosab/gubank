package com.github.gustavobarbosab.androidcourse.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.CreationExtras
import com.github.gustavobarbosab.androidcourse.ui.common.components.InputValidationState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterInputState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.data.RegisterFlowRepository
import com.github.gustavobarbosab.androidcourse.ui.screen.register.screens.name.RegisterNameViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Calendar

class RegisterFlowViewModel(
    private val repository: RegisterFlowRepository
) : ViewModel() {

    private var _myTextState = MutableStateFlow("")
    val myTextState
        get() = _myTextState.asStateFlow()


    fun updateShared(sharedString: String) {
        _myTextState.update { "$it $sharedString ${repository.name}" }
    }


//
//    fun saveAddress(
//        cep: String,
//        street: String?,
//        district: String?,
//        city: String?,
//        number: String?
//    ) {
//        val valueToShow = StringBuilder()
//            .append(street)
//            .append(", ")
//            .append(number)
//            .append(" - ")
//            .append(district)
//            .append(". ")
//            .append(city)
//            .toString()
//
//        _userAddress.update {
//            RegisterInputState(
//                valueToShow,
//                InputValidationState.ValidField
//            )
//
//        }
//    }

    companion object {
        fun provideFactory(
            repository: RegisterFlowRepository
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return RegisterFlowViewModel(repository) as T
            }
        }
    }
}