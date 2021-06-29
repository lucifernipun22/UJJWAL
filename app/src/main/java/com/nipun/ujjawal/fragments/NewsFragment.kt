package com.nipun.ujjawal.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nipun.okcredit.Data.local.CustomerEntity
import com.nipun.ujjawal.R
import com.nipun.ujjawal.news.Data
import com.nipun.ujjawal.news.NewsAdapters
import com.nipun.ujjawal.news.UjjwalFactory
import com.nipun.ujjawal.news.UjjwalViewModel
import com.nipun.ujjawal.transaction.CustomerViewModelFactory
import com.nipun.ujjawal.transaction.UjjwalApplication
import kotlinx.android.synthetic.main.app_bar_news.*
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsFragment : Fragment() {

    var newsList: List<Data> = emptyList()

    //    lateinit var supplyAdapter: SupplyAdapter
    lateinit var viewModel: UjjwalViewModel
    lateinit var newsAdapters: NewsAdapters
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    companion object {

        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModel()
        super.onViewCreated(view, savedInstanceState)
        btn.setOnClickListener { view ->
            setRecyclerView()
            CoroutineScope(Dispatchers.IO).launch {
                newsList = viewModel.getAgreeNews("politics")!!
                Log.d("News", "${newsList}")
            }
            newsAdapters.notifyDataSetChanged()


        }
    }

    private fun setRecyclerView() {
        newsAdapters = NewsAdapters(newsList)
        RvSupply.layoutManager = LinearLayoutManager(context)
        RvSupply.adapter = newsAdapters
    }


    /*private fun initViewModel() {
        val appClass = activity?.application as UjjwalApplication

        val repository = appClass.repository2
        val viewModelFactory = UjjwalFactory(repository)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(UjjwalViewModel::class.java)
    }*/
    private fun initViewModel() {
        val application = activity?.application as UjjwalApplication
        val repo = application.okCreditDAO
        val viewModelFactory = UjjwalFactory(repo)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(UjjwalViewModel::class.java)
    }


}


