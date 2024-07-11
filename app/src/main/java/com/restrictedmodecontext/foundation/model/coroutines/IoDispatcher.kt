package com.restrictedmodecontext.foundation.model.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class IoDispatcher(
    val value: CoroutineDispatcher = Dispatchers.IO
)