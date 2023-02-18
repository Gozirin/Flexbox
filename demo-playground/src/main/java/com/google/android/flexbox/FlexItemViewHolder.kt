

package com.google.android.flexbox

import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.apps.flexbox.R

/**
 * ViewHolder implementation for a flex item.
 */
class FlexItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textView: TextView = itemView.findViewById(R.id.textview)

    fun bindTo(params: RecyclerView.LayoutParams) {
        val adapterPosition = adapterPosition
        textView.apply {
            text = (adapterPosition + 1).toString()
            setBackgroundResource(R.drawable.flex_item_background)
            gravity = Gravity.CENTER
            layoutParams = params
        }
    }
}
