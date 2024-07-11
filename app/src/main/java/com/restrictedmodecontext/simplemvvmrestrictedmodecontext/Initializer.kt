package com.restrictedmodecontext.simplemvvmrestrictedmodecontext

import android.content.Context
import com.restrictedmodecontext.foundation.SingletonScopeDependencies
import com.restrictedmodecontext.foundation.model.coroutines.IoDispatcher
import com.restrictedmodecontext.foundation.model.coroutines.WorkerDispatcher
import com.restrictedmodecontext.simplemvvmrestrictedmodecontext.model.colors.InMemoryColorsRepository

object Initializer {

    fun initDependencies() {
        SingletonScopeDependencies.init {applicationContext ->
            val ioDispatcher = IoDispatcher()
            val workerDispatcher = WorkerDispatcher()

            return@init listOf(
                ioDispatcher,
                workerDispatcher,

                InMemoryColorsRepository(ioDispatcher)
            )
        }

    }
}