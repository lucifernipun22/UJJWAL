package com.nipun.ujjawal.transaction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.okcredit.Data.local.CustomerEntity
import com.nipun.ujjawal.R
import kotlinx.android.synthetic.main.item_buyers.view.*

class CustomerAdapter(
    private val customer_list: MutableList<CustomerEntity>,
    var mlistner: OnRowItemClicked,

    ) : RecyclerView.Adapter<CustomerAdapter.ClassViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_buyers, parent, false)
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
                name.text = model.name
                location.text = model.location
                business.text = model.businessname
                commodity.text = model.commoditity
                //@Subscribe(threadMode = ThreadMode.MAIN)


                relativeLayout.setOnClickListener {
                    mlistner.onItemClick(model)
                }
            }

        }
    }


}