package com.siberiadante.kutilsample.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.siberiadante.kutilsample.R
import com.siberiadante.kutilsample.model.UtilModel
import kotlinx.android.synthetic.main.item_text_utils.view.*

/**
 * CreateTime: 2018/7/4
 * UpDateTime:
 * Describe:
 */
class MainAdapter(val context: Context, val items: ArrayList<UtilModel<*>>, var itemClickListener: (UtilModel<*>) -> Unit) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var mContext = context
    var datas = items
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_text_utils, parent, false)
        return MainViewHolder(view,itemClickListener)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        holder?.bind(datas[position])
    }

    class MainViewHolder(val view: View,var itemClickListener: (UtilModel<*>) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bind(utilModel: UtilModel<*>) {
            view.tv_item_content.text = utilModel.title
            view.setOnClickListener {
                itemClickListener(utilModel)
            }
        }
    }
}