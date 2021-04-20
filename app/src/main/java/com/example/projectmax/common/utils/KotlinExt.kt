package com.example.projectmax.common.utils

/* Default mode is SYNCHRONIZED , which we don't need in android since, we have only UI thread. */
fun <T> lazyAndroid(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)
