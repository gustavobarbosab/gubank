package com.github.gustavobarbosab.androidcourse.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.github.gustavobarbosab.androidcourse.ui.common.components.InputValidationState
import com.github.gustavobarbosab.androidcourse.ui.screen.register.common.model.RegisterInputState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Calendar

class RegisterFlowViewModel : ViewModel() {

    private var _myTextState = MutableStateFlow("")
    val myTextState
        get() = _myTextState.asStateFlow()

    var username = ""
    var birthday: Calendar = Calendar.getInstance()
    var document = ""
    var street = ""
    var district = ""
    var number = ""
    var city = ""
    var cep = ""

    fun updateShared(sharedString: String) {
        _myTextState.update { "$it $sharedString" }
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
}