package com.example.chocodevdayanimation.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.chocodevdayanimation.R
import com.example.chocodevdayanimation.view.entity.OnBoardingPage
import kotlinx.android.synthetic.main.onboarding_page_item.view.*

/**
 * Created by Ruslan Erdenoff on 28.10.2020.
 */

class OnBoardingPagerAdapter(private val onBoardingPageList:Array<OnBoardingPage> = OnBoardingPage.values())
: RecyclerView.Adapter<PagerViewHolder>() {
	
	
	
	override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PagerViewHolder {
		return LayoutInflater.from(parent.context).inflate(
				PagerViewHolder.LAYOUT, parent, false
		).let { PagerViewHolder(it) }
	}
	
	override fun getItemCount() = onBoardingPageList.size
	
	override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
		holder.bind(onBoardingPageList[position])
	}
}

class PagerViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
	fun bind(onBoardingPage: OnBoardingPage) {
		with(root){
			val res = context.resources
			titleTv?.text = res.getString(onBoardingPage.titleResource)
			subTitleTv?.text = res.getString(onBoardingPage.subTitleResource)
			descTV?.text = res.getString(onBoardingPage.descriptionResource)
			img.setImageResource(onBoardingPage.logoResource)
			tag = bindingAdapterPosition
		}
		
	}
	
	companion object {
		@LayoutRes
		val LAYOUT = R.layout.onboarding_page_item
	}
}