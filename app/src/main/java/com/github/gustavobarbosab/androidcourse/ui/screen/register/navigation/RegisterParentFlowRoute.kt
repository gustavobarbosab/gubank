package com.github.gustavobarbosab.androidcourse.ui.screen.register.navigation

import com.github.gustavobarbosab.androidcourse.ui.navigation.route.NavigationRoute

data object RegisterParentFlowRoute : NavigationRoute {

    override val name: String = "REGISTER"

    object NestedRoutes {
        val registerNameRoute = object : NavigationRoute {
            override val name: String = "REGISTER_NAME"
        }

        val registerBirthdayRoute = object : NavigationRoute {
            override val name: String = "REGISTER_BIRTHDAY"
        }

        val registerDocumentRoute = object : NavigationRoute {
            override val name: String = "REGISTER_DOCUMENT"
        }

        val registerAddressRoute = object : NavigationRoute {
            override val name: String = "REGISTER_ADDRESS"
        }
    }
}