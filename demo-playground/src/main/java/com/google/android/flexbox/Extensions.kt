
package com.google.android.flexbox

import android.content.Context

/**
 * Convert pixel to dp. Preserve the negative value as it's used for representing
 * MATCH_PARENT(-1) and WRAP_CONTENT(-2).
 * Ignore the round error that might happen in dividing the pixel by the density.
 *
 * @param pixel   the value in pixel
 *
 * @return the converted value in dp
 */
fun Context.pixelToDp(pixel: Int): Int {
    val displayMetrics = this.resources.displayMetrics
    return if (pixel < 0) pixel else Math.round(pixel / displayMetrics.density)
}

/**
 * Convert dp to pixel. Preserve the negative value as it's used for representing
 * MATCH_PARENT(-1) and WRAP_CONTENT(-2).
 *
 * @param dp      the value in dp
 *
 * @return the converted value in pixel
 */
fun Context.dpToPixel(dp: Int): Int {
    val displayMetrics = this.resources.displayMetrics
    return if (dp < 0) dp else Math.round(dp * displayMetrics.density)
}
