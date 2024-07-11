package com.restrictedmodecontext.foundation.views

import com.restrictedmodecontext.foundation.ActivityScopeViewModel

interface FragmentsHolder {

    fun notifyScreenUpdates()

    fun getActivityScopeViewModel(): ActivityScopeViewModel
}