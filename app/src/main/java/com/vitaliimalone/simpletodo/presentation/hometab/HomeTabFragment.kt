package com.vitaliimalone.simpletodo.presentation.hometab

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.vitaliimalone.simpletodo.R
import com.vitaliimalone.simpletodo.presentation.base.BaseFragment
import com.vitaliimalone.simpletodo.presentation.hometab.common.TasksAdapter
import com.vitaliimalone.simpletodo.presentation.models.HomeTab
import kotlinx.android.synthetic.main.tasks_pager_item.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeTabFragment : BaseFragment(R.layout.tasks_pager_item) {
    companion object {
        private const val ARG_HOME_TAB = "arg_home_tab"

        fun newInstance(homeTab: HomeTab): HomeTabFragment {
            return HomeTabFragment().apply {
                arguments = bundleOf(ARG_HOME_TAB to homeTab.name)
            }
        }
    }

    private val viewModel: HomeTabViewModel by viewModel()
    private val tasksAdapter by lazy { TasksAdapter() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val homeTab = HomeTab.valueOf(requireArguments().getString(ARG_HOME_TAB)!!)
        viewModel.fetchTasksForHomeTab(homeTab)
        setupClickListeners()
        setupViews()
        setupObservers()
    }

    private fun setupClickListeners() {

    }

    private fun setupViews() {
        tasksPagerRecyclerView.adapter = tasksAdapter
    }

    private fun setupObservers() {
        viewModel.tasksForHomeTab.observe(viewLifecycleOwner, Observer {
            tasksAdapter.tasks = it
        })
    }
}