package com.c_od_e.pagination.view.db

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
class DatabaseActivity : BaseCatActivity() {

    override val viewModel: DataBaseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        viewModel.fillWithDummyCats()
        lifecycleScope.launch {
            viewModel.cats.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}