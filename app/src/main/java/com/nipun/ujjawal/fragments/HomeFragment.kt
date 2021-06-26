package com.nipun.ujjawal.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ActionTypes
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemChangeListener
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.interfaces.TouchListener
import com.denzcoskun.imageslider.models.SlideModel
import com.nipun.ujjawal.MandiRateActvity
import com.nipun.ujjawal.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() , com.nipun.ujjawal.ItemClickListener {
    private  var image_slider : ImageSlider? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*initViews(view)*/
        image_slider = view?.findViewById(R.id.image_slider);



       cardVIEW4.setOnClickListener { view ->

           onClickOfItem(text1.text.toString(),"https://raw.githubusercontent.com/lucifernipun22/image/main/onion_image.png")

        }
        cardVIEW5.setOnClickListener { view ->

            onClickOfItem(text2.text.toString(),"https://raw.githubusercontent.com/lucifernipun22/image/main/beetroot.png")

        }
        cardVIEW6.setOnClickListener { view ->

            onClickOfItem(text3.text.toString(),"https://raw.githubusercontent.com/lucifernipun22/image/main/potato.png")

        }
        cardVIEW7.setOnClickListener { view ->

            onClickOfItem(text4.text.toString(),"https://raw.githubusercontent.com/lucifernipun22/image/main/maize.png")


        }
        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel("https://raw.githubusercontent.com/lucifernipun22/image/main/Add%20a%20heading.png",ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel("https://raw.githubusercontent.com/lucifernipun22/image/main/Add%20a%20heading%20(1).png",ScaleTypes.CENTER_CROP))


            image_slider?.setImageList(imageList)

       image_slider?.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                // You can listen here.
            }
        })

        image_slider?.setItemChangeListener(object : ItemChangeListener {
            override fun onItemChanged(position: Int) {
                //println("Pos: " + position)
            }
        })

        image_slider?.setTouchListener(object : TouchListener {
            override fun onTouched(touched: ActionTypes) {
                if (touched == ActionTypes.DOWN){
                   image_slider?.stopSliding()
                } else if (touched == ActionTypes.UP ) {
                    image_slider?.startSliding(1000)
                }
            }
        })

    }

    override fun onClickOfItem(name: String?, img: String?) {
        val intent = Intent(activity,MandiRateActvity::class.java);
        intent.putExtra("string",name)
        intent.putExtra("img",img)
        Log.d("tag",img.toString())
        startActivity(intent)

    }


}