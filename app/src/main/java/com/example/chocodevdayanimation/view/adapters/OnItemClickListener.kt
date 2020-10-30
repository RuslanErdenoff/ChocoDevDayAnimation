package com.example.chocodevdayanimation.view.adapters

import android.view.View

/**
 * Created by Ruslan Erdenoff on 29.10.2020.
 */
interface OnItemClickListener {
    fun onClick(view: View?,position:Int,item:Any?)
}