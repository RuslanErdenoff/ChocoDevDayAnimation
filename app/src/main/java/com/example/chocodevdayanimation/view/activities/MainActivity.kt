package com.example.chocodevdayanimation.view.activities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.chocodevdayanimation.R
import com.example.chocodevdayanimation.view.adapters.OnBoardingPagerAdapter
import com.example.chocodevdayanimation.view.entity.OnBoardingPage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.onboarding_page_item.view.*

class MainActivity : AppCompatActivity() {
	private val offsets: HashMap<Int, Int> = HashMap()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setUpSlider()
		nextBtn.setOnClickListener {
			startActivity(Intent(this,RestaurantsActivity::class.java))
		}
	}
	
	private fun setUpSlider() {
		with(slider) {
			adapter = OnBoardingPagerAdapter()
			startBtn.alpha = 0f

			setPageTransformer { page ,position ->
				
				page.apply {
					when {
						position < -1 -> alpha = 0f

						position <= 0 -> alpha = 1f

						position <= 1 -> {
							alpha = 1 - position
							img.translationX = position * (width/2f)
						}
						position >= 2 -> {

						}
						else -> alpha = 0f
					}
				}
			}

			addSlideChangeListener()

		}
		
	}
	
	private fun addSlideChangeListener() {
		landscape.visibility = View.VISIBLE
		slider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
			override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
				super.onPageScrolled(position, positionOffset, positionOffsetPixels)
				offsets[position] = positionOffsetPixels
				val totalOffset = offsets.values.sumBy { it }
				landscape.translationX = -totalOffset/4f + 200f

				when{
					position > 1 -> {
						val objectAnimatorA = ObjectAnimator.ofFloat(nextBtn, View.ALPHA, 1f,0f)
						objectAnimatorA.duration = 500

						val objectAnimatorA2 = ObjectAnimator.ofFloat(skipBtn, View.ALPHA, 1f,0f)
						objectAnimatorA2.duration = 500

						val objectAnimatorA3 = ObjectAnimator.ofFloat(startBtn, View.ALPHA, 0f,1f)
						objectAnimatorA2.duration = 500

						val objectAnimatorS = ObjectAnimator.ofFloat(nextBtn, View.SCALE_X, 1f,0f)
						objectAnimatorA.duration = 500

						val objectAnimatorS2 = ObjectAnimator.ofFloat(skipBtn, View.SCALE_X, 1f,0f)
						objectAnimatorA2.duration = 500

						val animtorSet = AnimatorSet()
						animtorSet.play(objectAnimatorA)
							.with(objectAnimatorA2)
							.with(objectAnimatorA3)
							.with(objectAnimatorS)
							.with(objectAnimatorS2)

						animtorSet.start()
					}
					else -> {
						nextBtn.alpha = 1f
						skipBtn.alpha = 1f
						nextBtn.scaleX = 1f
						skipBtn.scaleX = 1f
						startBtn.alpha = 0f
					}
				}
			}
		})
	}
}