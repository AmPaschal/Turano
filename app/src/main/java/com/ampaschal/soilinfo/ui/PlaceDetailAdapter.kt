package com.ampaschal.soilinfo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ampaschal.soilinfo.R
import com.ampaschal.soilinfo.entities.SoilLayer
import com.ampaschal.soilinfo.ui.PlaceDetailAdapter.PlaceDetailViewHolder

class PlaceDetailAdapter : RecyclerView.Adapter<PlaceDetailViewHolder>() {
    var soilLayers: List<SoilLayer>? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlaceDetailViewHolder {
        val context = parent.context
        val itemView: View
        itemView = if (viewType % 2 == 0) {
            LayoutInflater.from(context)
                .inflate(R.layout.layer_detail_left_list, parent, false)
        } else {
            LayoutInflater.from(context)
                .inflate(R.layout.layer_detail_right_list, parent, false)
        }
        return PlaceDetailViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: PlaceDetailViewHolder,
        position: Int
    ) {
        val soilLayer = soilLayers!![position]
        holder.bind(soilLayer)
    }

    override fun getItemCount(): Int {
        return if (soilLayers != null) soilLayers!!.size else 0
    }

    fun setData(soilLayers: List<SoilLayer>?) {
        this.soilLayers = soilLayers
        notifyDataSetChanged()
    }

    inner class PlaceDetailViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(soilLayer: SoilLayer?) {
            //TODO bind the views to the itemView
        }
    }
}