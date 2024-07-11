package com.restrictedmodecontext.foundation.sideeffects.navigator.plugin

import com.restrictedmodecontext.foundation.sideeffects.SideEffectMediator
import com.restrictedmodecontext.foundation.sideeffects.navigator.Navigator
import com.restrictedmodecontext.foundation.views.BaseScreen

class NavigatorSideEffectMediator : SideEffectMediator<Navigator>(), Navigator {

    override fun launch(screen: BaseScreen) = target {
        it.launch(screen)
    }

    override fun goBack(result: Any?) = target {
        it.goBack(result)
    }

}