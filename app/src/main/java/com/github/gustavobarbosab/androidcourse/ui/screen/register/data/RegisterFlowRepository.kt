package com.github.gustavobarbosab.androidcourse.ui.screen.register.data

import java.util.Calendar

interface RegisterFlowRepository {
    var name: String
    var birthday: Calendar
    var document: String
    var street: String
    var district: String
    var number: String
    var city: String
    var cep: String
}