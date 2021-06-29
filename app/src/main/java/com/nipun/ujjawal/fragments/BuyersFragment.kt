package com.nipun.ujjawal.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nipun.ujjawal.IntroductionActivity
import com.nipun.ujjawal.R
import com.nipun.ujjawal.hp.adapters.SupplyAdapter
import com.nipun.ujjawal.hp.local.UserEntity
import com.nipun.ujjawal.hp.onclicklisteners.OnRowClicked
import com.nipun.ujjawal.hp.viewmodel.UjjwalFactory
import com.nipun.ujjawal.hp.viewmodel.UjjwalViewModel
import com.nipun.ujjawal.transaction.*
import kotlinx.android.synthetic.main.fragment_buyers.*


class BuyersFragment : Fragment(), OnRowClicked {

    //var customerList = mutableListOf<CustomerEntity>()
    //lateinit var customerAdapter: BuyersAdapter
    // lateinit var viewModel: CustomerViewModel
    lateinit var supplyAdapter: SupplyAdapter
    lateinit var viewModel: UjjwalViewModel
    var supplyerList = mutableListOf<UserEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
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
        setRecyclerView()
        updateUserList()
    }

    private fun initView(view: View) {

        val application = activity?.application as UjjwalApplication
        val repo = application.okCreditDAO
        val viewModelFactory = UjjwalFactory(repo)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(UjjwalViewModel::class.java)
    }

    private fun setRecyclerView() {
        supplyAdapter = SupplyAdapter(supplyerList,this)
        rv_rv2.layoutManager = LinearLayoutManager(context)
        rv_rv2.adapter = supplyAdapter
    }

    private fun updateUserList() {

        viewModel.fetchAllUsers().observe(viewLifecycleOwner, Observer {
            supplyerList.clear()
            supplyerList.addAll(it)
            supplyAdapter.notifyDataSetChanged()
            Log.d("Data", "${it}")
        })
    }

    override fun onItemClicked(userEntity: UserEntity) {
        val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",userEntity.UserMobNo, null))
        startActivity(phoneIntent)
    }

    /*viewModel.getCustomerList().observe(viewLifecycleOwner, Observer {
            if (it != null)
                customerList = it as MutableList<CustomerEntity>
            customerList = it as MutableList<CustomerEntity>
            val linearLayoutManager = LinearLayoutManager(context)
            rv_rv2.setLayoutManager(linearLayoutManager)
            customerAdapter = BuyersAdapter(customerList, this)
            rv_rv2.setAdapter(customerAdapter)
        })*/
}

