package com.desafio.android.features.repositories.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafio.android.R
import com.desafio.android.commons.autoCleared
import com.desafio.android.commons.ext.animateList
import com.desafio.android.commons.ext.gone
import com.desafio.android.commons.ext.visible
import com.desafio.android.databinding.FragmentListRepositoryBinding
import com.desafio.android.features.repositories.repository.mappers.toRepositoryListResult
import com.desafio.android.features.repositories.repository.model.entities.ResultDataWithListRepository
import com.desafio.android.features.repositories.view.adapter.ListRepositoryAdapter
import com.desafio.android.features.repositories.viewmodel.RepositoryListViewModel
import com.desafio.android.features.repositories.viewmodel.model.Repository
import com.desafio.android.commons.network.Resource
import com.desafio.android.util.notify
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListRepositoryFragment : Fragment(), ListRepositoryAdapter.RepositoryItemListener {

    private var binding: FragmentListRepositoryBinding by autoCleared()
    private val viewModelRepositoryList: RepositoryListViewModel by viewModel()
    private var pageIndex = 1

    private val adapterListRepository by lazy {
        ListRepositoryAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListRepositoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeRepositories()
        setupRecyclerViewRepositories()
    }

    private fun observeRepositories() {
        viewModelRepositoryList.getRepositories(pageIndex).observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    showRepositoriesDataResult(it.data)
                }
                Resource.Status.ERROR -> {
                    showMessageError(it.message)
                }
                Resource.Status.LOADING -> {
                    showLoadingProgressBar()
                }
            }
        }
    }

    private fun setupRecyclerViewRepositories() = with(binding.recyclerViewListRepository) {
        animateList()
        layoutManager = LinearLayoutManager(requireContext())
        adapter = adapterListRepository
    }

    private fun showRepositoriesDataResult(result: ResultDataWithListRepository?) {
        result?.let {
            val resultMapped = it.toRepositoryListResult()
            binding.progressBarListRepository.gone()
            binding.recyclerViewListRepository.visible()
            adapterListRepository.addRepositoryItems(resultMapped.items)
        }
    }

    private fun showMessageError(message: String?) {
        notify(binding.root, message.orEmpty())
    }

    private fun showLoadingProgressBar() {
        binding.progressBarListRepository.visible()
    }

    override fun onClickedRepository(repository: Repository) {
        findNavController().navigate(
            R.id.action_listRepositoryFragment_to_listPullRequestFragment,
            bundleOf("repository" to repository)
        )
    }
}