

package com.google.android.flexbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.apps.flexbox.R

/**
 * [RecyclerView.Adapter] implementation for [FlexItemViewHolder].
 */
internal class FlexItemAdapter(
    private val activity: AppCompatActivity,
    private val flexContainer: FlexContainer
) :
    RecyclerView.Adapter<FlexItemViewHolder>() {

    private val layoutParams = mutableListOf<FlexboxLayoutManager.LayoutParams>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlexItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_flex_item, parent, false)

        return FlexItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlexItemViewHolder, position: Int) {
        val adapterPosition = holder.adapterPosition
        // TODO: More optimized set the click listener inside the view holder
        holder.itemView.setOnClickListener(
            FlexItemClickListener(
                activity,
                FlexItemChangedListenerImplRecyclerView(flexContainer, this),
                adapterPosition
            )
        )
        holder.bindTo(layoutParams[position])
    }

    fun addItem(lp: FlexboxLayoutManager.LayoutParams) {
        layoutParams.add(lp)
        notifyItemInserted(layoutParams.size - 1)
    }

    fun removeItem(position: Int) {
        if (position < 0 || position >= layoutParams.size) {
            return
        }
        layoutParams.removeAt(position)
        notifyItemRemoved(layoutParams.size)
        notifyItemRangeChanged(position, layoutParams.size)
    }

    val items get() = layoutParams

    override fun getItemCount() = layoutParams.size
}
