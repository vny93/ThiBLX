package intent.project1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intent.project1.data.model.TrafficLaws
import intetn.project1.R
import intetn.project1.databinding.ItemChitietluatBinding
import intetn.project1.databinding.ItemLithuyetBinding

class TrafficLawsAdapter : RecyclerView.Adapter<TrafficLawsAdapter.MainViewHolder>() {
    private var listData: List<TrafficLaws> = ArrayList()

    public fun setData(list: List<TrafficLaws>) {
        this.listData = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class MainViewHolder(val binding: ItemChitietluatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(data: TrafficLaws) {
            binding.tvNdluat.text = data.noidung
            binding.tvMpluat.text = data.mucphat
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemChitietluatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = listData[position]
        holder.bindItem(data)
        holder.itemView.setOnClickListener(){

        }
//        holder.binding.tvLt.setOnClickListener() {
//
//        }
    }
}
//class TrafficLawsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private var listData: List<TrafficLaws> = ArrayList()
//
//    public fun setData(list: List<TrafficLaws>) {
//        this.listData = list
//        notifyDataSetChanged()
//    }
//
//    override fun getItemCount(): Int {
//        return listData.size
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return LoaiDeAdapterHolder(
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_chitietluat, parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (holder is LoaiDeAdapterHolder) {
//            holder.bindingData(listData.get(position))
//            holder.itemView.setOnClickListener(){
//            }
//        }
//    }
//
//    public class LoaiDeAdapterHolder constructor(itemView: View) :
//        RecyclerView.ViewHolder(itemView) {
//
//        fun bindingData(trafficLaws: TrafficLaws) {
//            itemView.tv_ndluat.text = trafficLaws.noidung
//            itemView.tv_mpluat.text = trafficLaws.mucphat
//        }
//    }
//}