package com.restrictedmodecontext.simplemvvmrestrictedmodecontext

import android.os.Bundle
import com.example.restrictedmodecontext.R
import com.restrictedmodecontext.foundation.sideeffects.SideEffectPluginsManager
import com.restrictedmodecontext.foundation.sideeffects.dialogs.plugin.DialogsPlugin
import com.restrictedmodecontext.foundation.sideeffects.intents.plugin.IntentsPlugin
import com.restrictedmodecontext.foundation.sideeffects.navigator.plugin.NavigatorPlugin
import com.restrictedmodecontext.foundation.sideeffects.navigator.plugin.StackFragmentNavigator
import com.restrictedmodecontext.foundation.sideeffects.permissions.plugin.PermissionsPlugin
import com.restrictedmodecontext.foundation.sideeffects.resources.plugin.ResourcesPlugin
import com.restrictedmodecontext.foundation.sideeffects.toasts.plugin.ToastsPlugin
import com.restrictedmodecontext.foundation.views.activity.BaseActivity
import com.restrictedmodecontext.simplemvvmrestrictedmodecontext.views.currentcolor.CurrentColorFragment

/**
 * This application is a single-activity app. MainActivity is a container
 * for all screens.
 */
class MainActivity : BaseActivity() {

    override fun registerPlugins(manager: SideEffectPluginsManager) = with (manager) {
        val navigator = createNavigator()
        register(ToastsPlugin())
        register(ResourcesPlugin())
        register(NavigatorPlugin(navigator))
        register(PermissionsPlugin())
        register(DialogsPlugin())
        register(IntentsPlugin())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Initializer.initDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun createNavigator() = StackFragmentNavigator(
        containerId = R.id.fragmentContainer,
        defaultTitle = getString(R.string.app_name),
        animations = StackFragmentNavigator.Animations(
            enterAnim = R.anim.enter,
            exitAnim = R.anim.exit,
            popEnterAnim = R.anim.pop_enter,
            popExitAnim = R.anim.pop_exit
        ),
        initialScreenCreator = { CurrentColorFragment.Screen() }
    )

}