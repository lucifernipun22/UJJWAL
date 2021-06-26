package com.nipun.ujjawal.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nipun.okcredit.Data.local.CustomerEntity
import com.nipun.ujjawal.R
import com.nipun.ujjawal.transaction.*
import kotlinx.android.synthetic.main.fragment_order.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class OrderFragment : Fragment(), OnRowItemClicked {
    var customerList = mutableListOf<CustomerEntity>()
    lateinit var customerAdapter: CustomerAdapter
    lateinit var viewModel: CustomerViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var intent : Intent? = null
       // val cropName: String? = intent?.getStringExtra("customer")
        //customer = arguments?.getString("name").toString()


        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    companion object {

        fun newInstance(): OrderFragment {
            return OrderFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initView(view)

        }

    private fun initView(view: View) {


        val appClass = activity?.application as UjjwalApplication

        val repository = appClass.repository
        val viewModelFactory = CustomerViewModelFactory(repository)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CustomerViewModel::class.java)

        viewModel.getCustomerList().observe(viewLifecycleOwner, Observer {
            if (it != null)
                customerList = it as MutableList<CustomerEntity>

            customerList = it as MutableList<CustomerEntity>
            val linearLayoutManager = LinearLayoutManager(context)
            rv_rv.setLayoutManager(linearLayoutManager)
            customerAdapter = CustomerAdapter(customerList, this)
            rv_rv.setAdapter(customerAdapter)
        })
        btnAdd.setOnClickListener { view ->
            val intent = Intent(activity, AddContactActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onItemClick(model: CustomerEntity) {


    }
}

