package com.ampaschal.soilinfo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ampaschal.soilinfo.R
import com.ampaschal.soilinfo.entities.SoilLayer
import com.ampaschal.soilinfo.ui.CompareAdapter.CompareViewHolder

class CompareAdapter : RecyclerView.Adapter<CompareViewHolder>() {
    private var compareLayer1: List<SoilLayer>? = null
    private var compareLayer2: List<SoilLayer>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompareViewHolder {
        val context = parent.context
        val itemView = LayoutInflater.from(context).inflate(
            R.layout.compare_list_item,
            parent, false
        )
        return CompareViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CompareViewHolder, position: Int) {
        val layer_1 = compareLayer1?.getOrNull(position)
        val layer_2 = compareLayer2?.getOrNull(position)
        holder.bind(layer_1, layer_2)
    }

    override fun getItemCount(): Int {
        return if (compareLayer1 != null) compareLayer1!!.size else 0
    }

    fun setData(
        compareLayer1: List<SoilLayer>?,
        compareLayer2: List<SoilLayer>?
    ) {
        this.compareLayer1 = compareLayer1
        this.compareLayer2 = compareLayer2
        notifyDataSetChanged()
    }

    inner class CompareViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvAppResistanceValue: TextView
        var tvThicknessValue: TextView
        var tvDepthValue: TextView
        var tvDescription: TextView
        var tvAppResistanceValue_2: TextView
        var tvThicknessValue_2: TextView
        var tvDepthValue_2: TextView
        var tvDescription_2: TextView
        fun bind(compareLayer_1: SoilLayer?, compareLayer_2: SoilLayer?) {
            tvAppResistanceValue.text = compareLayer_1?.appRes.toString() ?: "NA"
            tvThicknessValue.text = compareLayer_1?.thickness.toString() ?: "NA"
            tvDepthValue.text = compareLayer_1?.depth.toString() ?: "NA"
            tvDescription.text = compareLayer_1?.description ?: "NA"
            tvAppResistanceValue_2.text = compareLayer_2?.appRes.toString() ?: "NA"
            tvThicknessValue_2.text = compareLayer_2?.thickness.toString() ?: "NA"
            tvDepthValue_2.text = compareLayer_2?.depth.toString() ?: "NA"
            tvDescription_2.text = compareLayer_2?.description ?: "NA"
        }

        init {
            tvAppResistanceValue =
                itemView.findViewById<View>(R.id.tv_app_resistance_value) as TextView
            tvThicknessValue =
                itemView.findViewById<View>(R.id.tv_thickness_value) as TextView
            tvDepthValue = itemView.findViewById<View>(R.id.tv_depth_value) as TextView
            tvDescription =
                itemView.findViewById<View>(R.id.tv_description_text) as TextView
            tvAppResistanceValue_2 =
                itemView.findViewById<View>(R.id.tv_app_resistance_value_red) as TextView
            tvThicknessValue_2 =
                itemView.findViewById<View>(R.id.tv_thickness_value_red) as TextView
            tvDepthValue_2 =
                itemView.findViewById<View>(R.id.tv_depth_value_red) as TextView
            tvDescription_2 =
                itemView.findViewById<View>(R.id.tv_description_text_red) as TextView
        }
    }
}