package com.brevitz.navigationcomponenttest.core

import android.content.Context

object CoreInjectHelper {
    fun provideCoreComponent(applicationContext: Context): CoreComponent =
        (applicationContext as? CoreComponentProvider)?.provideCoreComponent()
            ?: throw IllegalStateException("The application context you have passed does not implement CoreComponentProvider")
}
