

package com.google.android.flexbox

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Implementation for the [FlexItemChangedListener].
 * It expects RecyclerView as the underlying flex container implementation.
 */
internal class FlexItemChangedListenerImplRecyclerView(private val flexContainer: FlexContainer,
                                              private val adapter: RecyclerView.Adapter<*>) : FlexItemChangedListener {

    override fun onFlexItemChanged(flexItem: FlexItem, viewIndex: Int) {
        val view = flexContainer.getFlexItemAt(viewIndex)
        view.layoutParams = flexItem as ViewGroup.LayoutParams
        adapter.notifyDataSetChanged()
        // TODO: An Exception is thrown if notifyItemChanged(int) is used.
        // Investigate that, but using LinearLayoutManager also produces the same Exception
        // java.lang.IllegalArgumentException: Called attach on a child which is not detached:
    }
}
