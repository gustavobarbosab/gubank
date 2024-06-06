package com.github.gustavobarbosab.androidcourse.ui.screen.register.data

import java.util.Calendar

class RegisterFlowRepositoryImpl : RegisterFlowRepository {
    override var name = ""
    override var birthdate: Calendar = Calendar.getInstance()
    override var document = ""
    override var street = ""
    override var district = ""
    override var number = ""
    override var city = ""
    override var cep = ""
}