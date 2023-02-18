
package com.google.android.flexbox.test

import android.content.Context

internal fun Context.dpToPixel(dp: Int): Int {
    val displayMetrics = this.resources.displayMetrics
    return if (dp < 0) dp else Math.round(dp * displayMetrics.density)
}
