package com.cordova.cordovarestapi
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cordova.cordovarestapi.databinding.ItemTweetBinding

class TweetAdapter : ListAdapter<Tweet, TweetAdapter.TweetViewHolder>(TweetDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val binding: ItemTweetBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_tweet,
            parent,
            false
        )
        return TweetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val tweet = getItem(position)
        holder.bind(tweet)
    }

    class TweetViewHolder(private val binding: ItemTweetBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tweet: Tweet) {
            binding.tweet = tweet
            binding.executePendingBindings()
        }
    }

    private class TweetDiffCallback : DiffUtil.ItemCallback<Tweet>() {

        override fun areItemsTheSame(oldItem: Tweet, newItem: Tweet): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Tweet, newItem: Tweet): Boolean {
            return oldItem == newItem
        }
    }
}
