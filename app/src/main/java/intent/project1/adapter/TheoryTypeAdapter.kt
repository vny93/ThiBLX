package intent.project1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import intent.project1.data.model.TheoryType
import intent.project1.screens.theory.StudyTheoryActivity
import intetn.project1.databinding.ItemLithuyetBinding

class TheoryTypeAdapter : RecyclerView.Adapter<TheoryTypeAdapter.MainViewHolder>() {
    private var listData: List<TheoryType> = ArrayList()
    companion object {
        var idTheory : Int = 0
    }
    fun setData(list: List<TheoryType>) {
        this.listData = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class MainViewHolder(val binding: ItemLithuyetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(data: TheoryType) {
            binding.tvLt.text = data.tenloai
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemLithuyetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = listData[position]
        holder.bindItem(data)
        holder.binding.tvLt.setOnClickListener() {
            idTheory = listData[position].maLoaiLiThuyet
            val intent: Intent = Intent(holder.itemView.context, StudyTheoryActivity::class.java)
       //     intent.putExtra("maLoailuat", listData.get(position).maLoaiLuatGt)
            intent.putExtra("type",data.tenloai)
            holder.itemView.context.startActivity(intent)
        }
    }
}
