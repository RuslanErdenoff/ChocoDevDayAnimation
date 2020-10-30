package com.example.chocodevdayanimation.view.activities

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chocodevdayanimation.R
import com.example.chocodevdayanimation.view.adapters.OnItemClickListener
import com.example.chocodevdayanimation.view.adapters.RestaurantsAdapter
import com.example.chocodevdayanimation.view.fragments.RestaurantFragment
import kotlinx.android.synthetic.main.activity_restaurants.*
class RestaurantsActivity : AppCompatActivity(){

    private var fragment:RestaurantFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)

        if(fragment == null) fragment = RestaurantFragment()

        supportFragmentManager
            .beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.list_container, fragment!!)
            .addToBackStack(null)
            .commit()
    }
}