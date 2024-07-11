package com.restrictedmodecontext.foundation.model.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class WorkerDispatcher(
    val value: CoroutineDispatcher = Dispatchers.Default
)