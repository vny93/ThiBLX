package intent.project1.adapter

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import intent.project1.data.api.ApiTipsService
import intent.project1.data.model.Tips
import intent.project1.data.model.TipsType
import intetn.project1.R
import intetn.project1.databinding.DialogMeothiBinding
import intetn.project1.databinding.ItemMeothiBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TipsTypeAdapter : RecyclerView.Adapter<TipsTypeAdapter.MainViewHolder>() {
    private var listData: List<TipsType> = ArrayList()

    public fun setData(list: List<TipsType>) {
        this.listData = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class MainViewHolder(val binding: ItemMeothiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(data: TipsType) {
            binding.tvMeothi.text = data.tenLoaiMeo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemMeothiBinding.inflate(
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
            getTips(listData[position].maLoaiMeo)
        }
    }

    fun getTips(id: Int) {
        ApiTipsService.ApiMeo.API_MEO_SERVICE.getMeo(id)
            .enqueue(object : Callback<Tips> {
                override fun onResponse(call: Call<Tips>, response: Response<Tips>) {
                    if (response.isSuccessful) {
                        response.body()?.let { it1 -> DetailedTips(Gravity.CENTER, it1.noidung) }
                    }
                }

                override fun onFailure(call: Call<Tips>, t: Throwable) {
                    println("Lổi")
                }

            })
    }

    fun DetailedTips(gravity: Int, noidung: String) {
        val dialog = Dialog(Activity())
        var binding2 : DialogMeothiBinding = DialogMeothiBinding.inflate(LayoutInflater.from(Activity()))
//                        ItemMeothiBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_meothi)

        val window = dialog.window ?: return
        window.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val windowAttributes = window.attributes
        windowAttributes.gravity = gravity
        window.attributes = windowAttributes

        //click ra bên ngoài để tắt dialog

        //click ra bên ngoài để tắt dialog
//        if (Gravity.CENTER == Gravity) {
//            dialog.setCancelable(true)
//        } else {
//            dialog.setCancelable(true)
//        }
//
//        tv_meothi = dialog.findViewById<TextView>(R.id.tvMeo)
//        tv_meothi.setText(noidung)
//        dialog.show()
    }
}
