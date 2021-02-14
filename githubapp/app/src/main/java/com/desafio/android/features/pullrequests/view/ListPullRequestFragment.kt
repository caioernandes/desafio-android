package com.desafio.android.features.pullrequests.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafio.android.commons.autoCleared
import com.desafio.android.commons.ext.animateList
import com.desafio.android.commons.ext.gone
import com.desafio.android.commons.ext.visible
import com.desafio.android.commons.network.Resource
import com.desafio.android.databinding.FragmentListPullRequestBinding
import com.desafio.android.features.MainActivity
import com.desafio.android.features.pullrequests.repository.mappers.toPullRequestList
import com.desafio.android.features.pullrequests.repository.model.entities.PullRequestAndUser
import com.desafio.android.features.pullrequests.view.adapter.ListPullRequestAdapter
import com.desafio.android.features.pullrequests.viewmodel.PullRequestListViewModel
import com.desafio.android.features.repositories.viewmodel.model.Repository
import com.desafio.android.util.notify
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListPullRequestFragment : Fragment() {

    private var binding: FragmentListPullRequestBinding by autoCleared()
    private val viewModelPullRequestList: PullRequestListViewModel by viewModel()
    private var repository: Repository? = null
    private val adapterListPullRequest by lazy {
        ListPullRequestAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        repository = requireArguments().getParcelable("repository")
        binding = FragmentListPullRequestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateToolbarTitle()
        loadPullRequests()
        setupRecyclerViewPullRequests()
    }

    private fun updateToolbarTitle() {
        (requireActivity() as MainActivity).toolbar.title = repository?.name
    }

    private fun loadPullRequests() = with(viewModelPullRequestList) {
        val creatorRepository = repository?.owner?.login.orEmpty()
        val repositoryName = repository?.name.orEmpty()
        loadPullRequests(creatorRepository, repositoryName).observe(viewLifecycleOwner) {
                when (it.status) {
                    Resource.Status.SUCCESS -> showPullRequestsDataResult(it.data)
                    Resource.Status.ERROR -> showMessageError(it.message)
                    Resource.Status.LOADING -> showLoadingProgressBar()
                }
            }
    }

    private fun setupRecyclerViewPullRequests() = with(binding.recyclerViewListPullRequest) {
        animateList()
        layoutManager = LinearLayoutManager(requireContext())
        adapter = adapterListPullRequest
    }

    private fun showPullRequestsDataResult(result: List<PullRequestAndUser>?) {
        result?.let {
            binding.progressBarListPullRequest.gone()
            binding.recyclerViewListPullRequest.visible()
            adapterListPullRequest.addAllPullRequests(result.toPullRequestList())
        }
    }

    private fun showMessageError(message: String?) {
        notify(binding.root, message.orEmpty())
    }

    private fun showLoadingProgressBar() {
        binding.progressBarListPullRequest.visibility = View.VISIBLE
    }
}