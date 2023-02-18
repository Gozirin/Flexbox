
package com.google.android.flexbox.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager

/**
 * Adapter for the tests for nested RecyclerViews.
 * This Adapter is used for the outer RecyclerView.
 */
internal class NestedOuterAdapter(
        @param:FlexDirection private val flexDirection: Int, private val innerAdapterItemCount: Int,
        @param:LayoutRes private val viewHolderResId: Int
) : RecyclerView.Adapter<NestedOuterAdapter.OuterViewHolder>() {

    private val viewHolderList = mutableListOf<OuterViewHolder>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OuterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewHolderResId, parent, false)
        val holder = OuterViewHolder(view)
        viewHolderList.add(holder)
        return holder
    }

    override fun onBindViewHolder(holder: OuterViewHolder, position: Int) {
        val layoutManager = FlexboxLayoutManager(holder.itemView.context)
        layoutManager.flexDirection = flexDirection
        holder.innerRecyclerView.layoutManager = layoutManager
        holder.innerRecyclerView.adapter = NestedInnerAdapter(position, innerAdapterItemCount)
    }

    fun getViewHolder(position: Int) = viewHolderList[position]

    override fun getItemCount() = ITEM_COUNT

    internal class OuterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val innerRecyclerView: RecyclerView = itemView.findViewById(R.id.recyclerview_inner)
    }

    companion object {
        private const val ITEM_COUNT = 4
    }
}
