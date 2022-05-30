package intent.project1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import intent.project1.data.model.Answer
import intent.project1.data.model.Question
import intent.project1.screens.test.FragmentTest
import intent.project1.screens.test.TestActivity
import intent.project1.screens.test.TestPresenter
import intetn.project1.R
import intetn.project1.databinding.ItemGvdscauhoiBinding

class CheckAnswerAdapter : RecyclerView.Adapter<CheckAnswerAdapter.MainViewHolder>() {
    private var listData: List<Question> = ArrayList()
    var onItemClick: ((Question) -> Unit)? = null

    fun setData(list: List<Question>) {
        this.listData = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class MainViewHolder(val binding: ItemGvdscauhoiBinding) :
        RecyclerView.ViewHolder(binding.root) {
//        fun bindItem(data: Question) {
//
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemGvdscauhoiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
       // val data = listData[position]
       // holder.bindItem(data)
        val pos = position + 1
        holder.binding.tvNumAns.text = "Câu "+pos+": "
        var myAnswer = TestActivity.listMyAnswer.get(position).traloi
        holder.binding.tvAns.text = myAnswer
        holder.itemView.setOnClickListener(){
            TestActivity.position = position
            onItemClick?.invoke(listData[position])
        }
    }
}