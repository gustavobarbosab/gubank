package com.github.gustavobarbosab.androidcourse.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterFlowViewModel : ViewModel() {

    private var _myTextState = MutableStateFlow("")
    val myTextState
        get() = _myTextState.asStateFlow()

    private var _userName = MutableStateFlow("")
    val userName
        get() = _userName.asStateFlow()

    private var _userDocument = MutableStateFlow("")
    val userDocument
        get() = _userDocument.asStateFlow()

    private var _userBirthday = MutableStateFlow("")
    val userBirthday
        get() = _userBirthday.asStateFlow()

    private var _userAddress = MutableStateFlow("")
    val userAddress
        get() = _userAddress.asStateFlow()

    fun updateShared(sharedString: String) {
        _myTextState.update { "$it $sharedString" }
    }

    fun saveUserName(userName: String) {
        _userName.update { userName }
    }

    fun saveDocument(document: String) {
        _userDocument.update { document }
    }

    fun saveBirthday(birthday: String) {
        _userBirthday.update { birthday }
    }

    fun saveAddress(
        cep: String,
        street: String?,
        district: String?,
        city: String?,
        number: String?
    ) {
        _userAddress.update {
            val stringBuilder = StringBuilder()
                .append(street)
                .append(number)
            "$street, $number - $district. $city"
        }
    }
}