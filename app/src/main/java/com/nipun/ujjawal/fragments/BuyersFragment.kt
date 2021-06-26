package com.nipun.ujjawal.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nipun.okcredit.Data.local.CustomerEntity
import com.nipun.ujjawal.BuyersAdapter
import com.nipun.ujjawal.R
import com.nipun.ujjawal.transaction.*
import kotlinx.android.synthetic.main.add_contact_gone.*
import kotlinx.android.synthetic.main.fragment_buyers.*
import kotlinx.android.synthetic.main.fragment_order.*
import kotlinx.android.synthetic.main.fragment_order.btnAdd
import kotlinx.android.synthetic.main.fragment_order.rv_rv


class BuyersFragment : Fragment(),OnRowItemClicked {
    var customerList = mutableListOf<CustomerEntity>()
    lateinit var customerAdapter: BuyersAdapter
    lateinit var viewModel: CustomerViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_buyers, container, false)
    }

    companion object {

        fun newInstance(): BuyersFragment {
            return BuyersFragment()
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
            rv_rv2.setLayoutManager(linearLayoutManager)
            customerAdapter = BuyersAdapter(customerList, this)
            rv_rv2.setAdapter(customerAdapter)
        })




    }

    override fun onItemClick(model: CustomerEntity) {


    }
}

