

package com.google.android.flexbox

import android.view.ViewGroup

/**
 * Default implementation for the [FlexItemChangedListener].
 */
internal class FlexItemChangedListenerImpl(private val flexContainer: FlexContainer) : FlexItemChangedListener {

    override fun onFlexItemChanged(flexItem: FlexItem, viewIndex: Int) {
        val view = flexContainer.getFlexItemAt(viewIndex)
        view.layoutParams = flexItem as ViewGroup.LayoutParams
    }
}
