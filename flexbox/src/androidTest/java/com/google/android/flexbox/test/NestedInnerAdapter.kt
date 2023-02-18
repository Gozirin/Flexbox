
package com.google.android.flexbox.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for the tests for nested RecyclerViews.
 * This Adapter is used for the inner RecyclerView.
 */
internal class NestedInnerAdapter(private val innerPosition: Int, private val itemCount: Int)
    : RecyclerView.Adapter<NestedInnerAdapter.InnerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedInnerAdapter.InnerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_textview, parent, false)
        return InnerViewHolder(view)
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        holder.textView.text = holder.textView.resources.getString(R.string.item_description, innerPosition, position)
    }

    override fun getItemCount() = itemCount

    internal class InnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView: TextView = itemView.findViewById(R.id.textview)
    }
}
