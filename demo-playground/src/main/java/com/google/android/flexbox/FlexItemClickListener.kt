

package com.google.android.flexbox

import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * Implementation of the [android.view.View.OnClickListener] when a flex item is clicked in
 * the Flexbox Playground demo app.
 */
internal class FlexItemClickListener(private val activity: AppCompatActivity, private val flexItemChangedListener: FlexItemChangedListener,
                                     private val viewIndex: Int) : View.OnClickListener {

    override fun onClick(v: View) =
            FlexItemEditFragment.newInstance(v.layoutParams as FlexItem, viewIndex).apply {
                setFlexItemChangedListener(flexItemChangedListener)
            }.show(activity.supportFragmentManager, EDIT_DIALOG_TAG)

    companion object {

        private const val EDIT_DIALOG_TAG = "edit_dialog_tag"
    }
}
