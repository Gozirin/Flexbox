
package com.google.android.flexbox.test

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexboxLayoutManager

/**
 * [RecyclerView.Adapter] implementation for [TestViewHolder].
 */
internal class TestAdapter private constructor(
        private val layoutParams: MutableList<FlexboxLayoutManager.LayoutParams>)
    : RecyclerView.Adapter<TestViewHolder>() {

    private val receivedPayloads = mutableListOf<Any>()

    constructor() : this(mutableListOf<FlexboxLayoutManager.LayoutParams>())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_viewholder, parent, false)
        return TestViewHolder(view)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.textView.text = (position + 1).toString()
        holder.textView.setBackgroundResource(R.drawable.flex_item_background)
        holder.textView.gravity = Gravity.CENTER
        holder.textView.layoutParams = layoutParams[position]
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int, payloads: List<Any>) {
        receivedPayloads.addAll(payloads)
        onBindViewHolder(holder, position)
    }

    fun addItem(position: Int, flexItem: FlexboxLayoutManager.LayoutParams) {
        layoutParams.add(position, flexItem)
        notifyItemInserted(position)
    }

    fun addItem(flexItem: FlexboxLayoutManager.LayoutParams) {
        layoutParams.add(flexItem)
        notifyItemInserted(layoutParams.size - 1)
    }

    fun changeItemWithPayload(position: Int, payload: Any) {
        notifyItemChanged(position, payload)
    }

    val payloads get() = receivedPayloads.toList()

    fun getItemAt(index: Int) = layoutParams[index]

    override fun getItemCount() = layoutParams.size
}
