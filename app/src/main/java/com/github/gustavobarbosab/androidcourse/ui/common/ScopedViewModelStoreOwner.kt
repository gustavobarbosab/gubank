package com.github.gustavobarbosab.androidcourse.ui.common

import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

class ScopedViewModelStoreOwner : ViewModelStoreOwner {
    override val viewModelStore = ViewModelStore()
}