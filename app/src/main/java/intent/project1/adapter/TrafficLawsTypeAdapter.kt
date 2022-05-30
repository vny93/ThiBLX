package intent.project1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intent.project1.data.model.TrafficLawsType
import intent.project1.screens.trafficlaws.DetailedLawActivity
import intetn.project1.databinding.ItemLoailuatBinding

class TrafficLawsTypeAdapter : RecyclerView.Adapter<TrafficLawsTypeAdapter.MainViewHolder>() {
    private var listData: List<TrafficLawsType> = ArrayList()

    public fun setData(list: List<TrafficLawsType>) {
        this.listData = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class MainViewHolder(val binding: ItemLoailuatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(data: TrafficLawsType) {
            binding.tvLoailuat.text = data.tenLoaiLuatGt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemLoailuatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = listData[position]
        holder.bindItem(data)
        holder.itemView.setOnClickListener() {
            val intent: Intent = Intent(holder.itemView.context, DetailedLawActivity::class.java)
            intent.putExtra("maLoailuat", listData.get(position).maLoaiLuatGt)
            holder.itemView.context.startActivity(intent)
        }
    }
}
