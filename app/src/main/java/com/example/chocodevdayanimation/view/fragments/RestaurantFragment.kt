package com.example.chocodevdayanimation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionInflater
import com.example.chocodevdayanimation.R
import com.example.chocodevdayanimation.view.adapters.OnItemClickListener
import com.example.chocodevdayanimation.view.adapters.RestaurantsAdapter
import kotlinx.android.synthetic.main.fragment_restaurant.*


class RestaurantFragment : Fragment(),OnItemClickListener {

    private lateinit var adapter:RestaurantsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter(){
        val dummy = ArrayList<String>()
        for (i in 0..10) dummy.add(i.toString())
        adapter = RestaurantsAdapter(dummy)
        adapter.setOnClickListener(this)
        rest_list.layoutManager = LinearLayoutManager(context)
        rest_list.adapter = adapter
    }

    override fun onClick(view: View?, position: Int, item: Any?) {
        goToDetailFragment(view?.findViewById(R.id.rest_image)!!, position)
    }

    private fun goToDetailFragment(imageView: ImageView, position: Int) {

        val args = Bundle()
        args.putInt("rest_pos", position)

        val fragment = DetailRestFragment()
        fragment.arguments = args

        activity?.let {
            it.supportFragmentManager
                .beginTransaction()
                .setReorderingAllowed(true)
                .addSharedElement(imageView, imageView.transitionName)
                .replace(R.id.list_container, fragment)
                .addToBackStack("TAG")
                .commit()
        }

    }
}