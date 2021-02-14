package com.desafio.android.features.repositories.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.desafio.android.databinding.ItemRepositoryListBinding
import com.desafio.android.features.repositories.viewmodel.model.Repository

class ListRepositoryAdapter(
    private val listener: RepositoryItemListener
) : RecyclerView.Adapter<RepositoryViewHolder>() {

    private val repositoryList = ArrayList<Repository>()

    fun addRepositoryItems(repositoryList: List<Repository>) {
        this.repositoryList.addAll(repositoryList)
        notifyDataSetChanged()
    }

    interface RepositoryItemListener {
        fun onClickedRepository(repository: Repository)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding: ItemRepositoryListBinding =
            ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = repositoryList.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(repositoryList[position])
    }
}

class RepositoryViewHolder(
    private val itemBinding: ItemRepositoryListBinding,
    private val listener: ListRepositoryAdapter.RepositoryItemListener
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var repository: Repository

    init {
        itemBinding.root.setOnClickListener(this)
    }

    fun bind(item: Repository) = with(itemBinding) {
        repository = item
        appCompatTextViewRepositoryTitle.text = item.name
        appCompatTextViewRepositoryDescription.text = item.description
        appCompatTextViewRepositoryNumberForks.text = item.forksCount.toString()
        appCompatTextViewRepositoryStars.text = item.stargazersCount.toString()
        Glide.with(root)
            .load(item.owner.avatarUrl)
            .transform(CircleCrop())
            .into(appCompatImageViewRepositoryUserAvatar)
        appCompatTextViewRepositoryUserName.text = item.owner.login
    }

    override fun onClick(view: View?) {
        listener.onClickedRepository(repository)
    }
}