package com.example.robolectrictestapp

import android.app.appsearch.SearchResult
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.robolectrictestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ViewSearchContract  {
    private var totalCount: Int = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUI() = with(binding){
        toDetailsActivityButton.setOnClickListener {
            startActivity(DetailsActivity.getIntent(this@MainActivity, totalCount)
            )
        }
        setQueryListener()
        setRecyclerView()
    }

    override fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    ) {
        this.totalCount = totalCount
        adapter.updateResults(searchResults)
    }

}

