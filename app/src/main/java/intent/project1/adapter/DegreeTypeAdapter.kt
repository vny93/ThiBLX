package intent.project1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intent.project1.data.model.DegreeType
import intetn.project1.databinding.ItemLoaideBanglaiBinding
//import kotlinx.android.synthetic.main.item_loaide_banglai.view.*


class DegreeTypeAdapter : RecyclerView.Adapter<DegreeTypeAdapter.MainViewHolder>() {

    private var listData: List<DegreeType> = ArrayList()
    public var maLoaiBL: Int = 0

    public fun setData(list: List<DegreeType>) {
        this.listData = list
        notifyDataSetChanged()
    }

    inner class MainViewHolder(val binding: ItemLoaideBanglaiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(data: DegreeType) {
            binding.tvLt2.text = data.tenloaibang
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemLoaideBanglaiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = listData[position]
        holder.bindItem(data)
        holder.binding.tvLt2.setOnClickListener() {
            maLoaiBL = listData.get(position).maloaibang
            println("maloaiBL: " + maLoaiBL)
        }

    }

    override fun getItemCount(): Int {
        return listData.size
    }


//class DegreeTypeAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    class MyViewHolder(val myView: View) : RecyclerView.ViewHolder(myView)

//    private var listData: List<DegreeType> = ArrayList()
//    public var maLoaiBL : Int = 0
//
//    public fun setData(list: List<DegreeType>) {
//        this.listData = list
//        notifyDataSetChanged()
//    }
//
//    override fun getItemCount(): Int {
//        return listData.size
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val binding = CardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding.root)
////        return LoaiDeAdapterHolder(
////            LayoutInflater.from(parent.context)
////                .inflate(R.layout.item_loaide_banglai, parent, false)
////        )
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (holder is LoaiDeAdapterHolder) {
//            holder.bindingData(listData.get(position))
//            holder.itemView.setOnClickListener(){
//                maLoaiBL = listData.get(position).maloaibang
//                println("maloaiBL: "+maLoaiBL)
//            }
//        }
//    }
//
//    public class LoaiDeAdapterHolder constructor(itemView: View) :
//        RecyclerView.ViewHolder(itemView) {
//
//        fun bindingData(loaiBL: DegreeType) {
//            itemView.tv_lt2.text = loaiBL.tenloaibang
//        }
//    }
}