package com.c_od_e.pagination.view.networkanddb

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import com.c_od_e.pagination.core.BaseCatActivity
import com.c_od_e.pagination.databinding.ActivityCatsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@ExperimentalPagingApi
@AndroidEntryPoint
class NetworkAndDatabaseActivity : BaseCatActivity() {

    override val viewModel: NetworkAndDbViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter(true)
        lifecycleScope.launch {
            viewModel.cats.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}