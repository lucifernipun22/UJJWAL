package com.nipun.ujjawal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.okcredit.Data.local.CustomerEntity
import com.nipun.ujjawal.transaction.CustomerAdapter
import com.nipun.ujjawal.transaction.OnRowItemClicked
import kotlinx.android.synthetic.main.item_buyers.view.*
import kotlinx.android.synthetic.main.item_buyers.view.location
import kotlinx.android.synthetic.main.item_buyers.view.relativeLayout
import kotlinx.android.synthetic.main.item_order.view.*

class BuyersAdapter (
    private val customer_list: MutableList<CustomerEntity>,
    var mlistner: OnRowItemClicked,

    ) : RecyclerView.Adapter<BuyersAdapter.ClassViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_order, parent, false)
        return ClassViewHolder(view)
    }


    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val model = customer_list[position]

        holder.setData(model, mlistner)
    }

    override fun getItemCount(): Int {
        return customer_list.size
    }

    class ClassViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(model: CustomerEntity, mlistner: OnRowItemClicked) {
            view.apply {
                BusinessName.text = model.businessname
                location1.text = model.location
                name1.text = model.name
                crop.text = model.commoditity
                //@Subscribe(threadMode = ThreadMode.MAIN)


                relativeLayout.setOnClickListener {
                    mlistner.onItemClick(model)
                }
            }

        }
    }


}