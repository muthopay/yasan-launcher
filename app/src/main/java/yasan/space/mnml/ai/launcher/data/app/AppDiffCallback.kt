package yasan.space.mnml.ai.launcher.data.app

import androidx.recyclerview.widget.DiffUtil

/**
 * [DiffUtil.Callback] class for [App].
 *
 * @see DiffUtil
 * @see DiffUtil.Callback
 */
class AppDiffCallback : DiffUtil.ItemCallback<App>() {
    override fun areItemsTheSame(oldItem: App, newItem: App): Boolean = oldItem.isTheSameAs(newItem)
    override fun areContentsTheSame(oldItem: App, newItem: App): Boolean = oldItem == newItem
}
