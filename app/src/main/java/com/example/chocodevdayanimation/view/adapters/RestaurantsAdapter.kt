package com.example.chocodevdayanimation.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import com.example.chocodevdayanimation.R
import kotlinx.android.synthetic.main.item_rest.view.*
import java.util.*


/**
 * Created by Ruslan Erdenoff on 29.10.2020.
 */
class RestaurantsAdapter(private val myDataset: List<String>) :
    RecyclerView.Adapter<RestaurantsAdapter.RestViewHolder>() {

    private var clickListener:OnItemClickListener? = null

    fun setOnClickListener(clickListener: OnItemClickListener){
        this.clickListener = clickListener
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rest, parent, false)

        return RestViewHolder(view)
    }
    override fun onBindViewHolder(holder: RestViewHolder, position: Int) {
        holder.apply {
            itemView.text_rest_name.text = "Test Rest ${myDataset[position]}"
            itemView.setOnClickListener {
                clickListener?.onClick(it, bindingAdapterPosition, myDataset[position])
            }

            val anim = ScaleAnimation(
                0.0f,
                1.0f,
                0.0f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration = 1000
            itemView.startAnimation(anim)
        }


    }
    override fun getItemCount() = myDataset.size

    class RestViewHolder(view: View) : RecyclerView.ViewHolder(view)
}