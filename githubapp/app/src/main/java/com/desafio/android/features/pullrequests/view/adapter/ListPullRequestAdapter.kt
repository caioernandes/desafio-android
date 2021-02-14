package com.desafio.android.features.pullrequests.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.desafio.android.databinding.ItemPullRequestListBinding
import com.desafio.android.features.pullrequests.viewmodel.model.PullRequest

class ListPullRequestAdapter(private val context: Context) :
    RecyclerView.Adapter<PullRequestViewHolder>() {

    private val pullRequestList = ArrayList<PullRequest>()

    fun addAllPullRequests(pullRequests: List<PullRequest>) {
        this.pullRequestList.addAll(pullRequests)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val binding: ItemPullRequestListBinding =
            ItemPullRequestListBinding.inflate(LayoutInflater.from(context), parent, false)

        return PullRequestViewHolder(binding)
    }

    override fun getItemCount(): Int = pullRequestList.size

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        holder.bind(pullRequestList[position])
    }

}

class PullRequestViewHolder(
    private val itemBinding: ItemPullRequestListBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: PullRequest) = with(itemBinding) {
        appCompatTextViewPullRequestTitle.text = item.title
        appCompatTextViewPullRequestDescription.text = item.body
        Glide.with(root)
            .load(item.user.avatarUrl)
            .transform(CircleCrop())
            .into(appCompatImageViewPullRequestUserAvatar)
        appCompatTextViewRepositoryUserName.text = item.user.login
    }
}