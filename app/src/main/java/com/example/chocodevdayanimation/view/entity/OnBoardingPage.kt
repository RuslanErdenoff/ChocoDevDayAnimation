package com.example.chocodevdayanimation.view.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.chocodevdayanimation.R

/**
 * Created by Ruslan Erdenoff on 28.10.2020.
 */

enum class OnBoardingPage(
		@StringRes val titleResource: Int,
		@StringRes val subTitleResource: Int,
		@StringRes val descriptionResource: Int,
		@DrawableRes val logoResource: Int
) {
	
	ONE(R.string.onboarding_slide1_title, R.string.onboarding_slide1_subtitle,R.string.onboarding_slide1_desc, R.drawable.ic_food),
	TWO(R.string.onboarding_slide2_title, R.string.onboarding_slide2_subtitle,R.string.onboarding_slide2_desc, R.drawable.ic_driver),
	THREE(R.string.onboarding_slide2_title, R.string.onboarding_slide3_subtitle,R.string.onboarding_slide1_desc, R.drawable.ic_rating)
	
}