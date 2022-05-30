package intent.project1.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intent.project1.data.model.ExamType
import intetn.project1.databinding.ItemLoaideBanglaiBinding


class ExamTypeAdapter : RecyclerView.Adapter<ExamTypeAdapter.MainViewHolder>() {

    public var maLoaide: Int = 0
    private var listData: List<ExamType> = ArrayList()

    public fun setData(list: List<ExamType>) {
        this.listData = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class MainViewHolder(val binding: ItemLoaideBanglaiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(data: ExamType) {
            binding.tvLt2.text = data.tenloaide
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
                maLoaide = listData.get(position).maloaide
                println("maloaide: " + maLoaide)
        }
    }
}




//class ExamTypeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    public var maLoaide: Int = 0
//    private var listData: List<ExamType> = ArrayList()
//
//    public fun setData(list: List<ExamType>) {
//        this.listData = list
//        notifyDataSetChanged()
//    }
//
//    override fun getItemCount(): Int {
//        return listData.size
//    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return LoaiDeAdapterHolder(
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_loaide_banglai, parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (holder is LoaiDeAdapterHolder) {
//            holder.bindingData(listData.get(position))
//            holder.itemView.setOnClickListener() {
//                //-----
//               // holder.itemView.setBackgroundColor(Color.BLUE)
//                if(holder.itemView.background == null){
//                    holder.itemView.setBackgroundColor(Color.BLUE)
//                }
//
//                println("blue"+Color.BLUE)
//                println("white"+Color.WHITE)
//                println("holder"+holder.itemView.tv_lt2.background)
//                //if(holder.itemView.background == Color.B)
//                //-------
//                maLoaide = listData.get(position).maloaide
//                println("maloaide: " + maLoaide)
//            }
//        }
//    }
//
//    public class LoaiDeAdapterHolder constructor(itemView: View) :
//        RecyclerView.ViewHolder(itemView) {
//        fun bindingData(examType: ExamType) {
//            itemView.tv_lt2.text = examType.tenloaide
//        }
//    }
//}




