package com.restrictedmodecontext.simplemvvmrestrictedmodecontext

import android.app.Application
import com.restrictedmodecontext.foundation.BaseApplication
import com.restrictedmodecontext.foundation.model.coroutines.IoDispatcher
import com.restrictedmodecontext.foundation.model.coroutines.WorkerDispatcher
import com.restrictedmodecontext.simplemvvmrestrictedmodecontext.model.colors.InMemoryColorsRepository
import kotlinx.coroutines.Dispatchers

/**
 * Here we store instances of model layer classes.
 */
class App : Application(), BaseApplication {

    private var ioDispatcher = IoDispatcher(Dispatchers.IO)
    private var workerDispatcher = WorkerDispatcher(Dispatchers.Default)

    /**
     * Place your singleton scope dependencies here
     */
    override val singletonScopeDependencies: List<Any> = listOf(
        ioDispatcher,
        workerDispatcher,
        InMemoryColorsRepository(ioDispatcher)
    )

}