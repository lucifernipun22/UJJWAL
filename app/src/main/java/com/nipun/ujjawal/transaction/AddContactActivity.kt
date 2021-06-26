package com.nipun.ujjawal.transaction

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nipun.okcredit.Data.local.CustomerEntity
import com.nipun.ujjawal.R
import com.nipun.ujjawal.fragments.OrderFragment
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.fragment_buyers.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddContactActivity : AppCompatActivity() {

    lateinit var customerViewModel: CustomerViewModel
    lateinit var customerEntity: CustomerEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        initView();
    }

    private fun initView() {
        val appClass = application as UjjwalApplication
        val repository = appClass.repository
        val viewModelFactory = CustomerViewModelFactory(repository)
        customerViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CustomerViewModel::class.java)


        btnaddd.setOnClickListener {

            customerEntity = CustomerEntity(
                et_name.text.toString(),
                et_location.text.toString(),
                et_business.text.toString(),
                et_commodity.text.toString()
            )
            customerViewModel.addNewCustomer(customerEntity)
            // intent = Intent(this, MainActivity::class.java)
            //intent.putExtra("customer", customerEntity.toString())
            // startActivity(intent)
            // gotoCustomerTransactionPage()
            //launchFragment(OrderFragment.newInstance())
            Toast.makeText(this@AddContactActivity , R.string.orderAdd,Toast.LENGTH_LONG ).show()
        }


    }

    fun launchFragment(fragmentName: OrderFragment) {
        var bundle = Bundle()
        /*var supplyList = mutableListOf<CustomerEntity>()
        CoroutineScope(Dispatchers.IO).launch {
            customerViewModel.getCustomerList().observe(this@AddContactActivity, Observer {
               supplyList = it
                Log.d("Data", "${it}")
            })


        }*/


        /*bundle.putString("name", customerEntity.name)
        bundle.putString("location", customerEntity.location)
        bundle.putString("business", customerEntity.businessname)
        bundle.putString("commodity", customerEntity.commoditity)
*/
        fragmentName.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, fragmentName, "fragmentName")
            .commit()
    }
}