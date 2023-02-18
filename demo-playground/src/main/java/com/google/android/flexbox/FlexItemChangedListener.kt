

package com.google.android.flexbox

/**
 * A listener that listens to the change of a flex item
 */
internal interface FlexItemChangedListener {

    fun onFlexItemChanged(flexItem: FlexItem, viewIndex: Int)
}
