package intent.project1.screens.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.squareup.picasso.Picasso
import intent.project1.data.model.Question
import intetn.project1.R
import intetn.project1.databinding.FragmentLambaithiBinding

class FragmentTest : Fragment() {
    lateinit var binding: FragmentLambaithiBinding
    private var position = 0

    companion object {
        var size: Int = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLambaithiBinding.inflate(inflater, container, false)
        val view = binding.root
        position = TestActivity.getPosition_test()
        getListQuestion2(position)
        return view
    }

    fun getListQuestion2(positon: Int) {
        var question: Question = TestActivity.listMyQuestion.get(positon)
        size = TestActivity.listMyQuestion.size
        binding.tvSTTcauLbt.text = "Câu " + (position + 1)
        binding.tvCauhoiltLbt.text = question.noidung
        binding.rad1Lbt.text = question.a
        binding.rad2Lbt.text = question.b
        if (question.hinhanh == null) binding.imvHinhanhLbt.isVisible = false
        else Picasso.get().load(question.hinhanh).into(binding.imvHinhanhLbt)
        if (question.c == null) binding.rad3Lbt.isVisible = false
        else binding.rad3Lbt.text = question.c
        if (question.d == null) binding.rad4Lbt.isVisible = false
        else binding.rad4Lbt.text = question.d
        checkRadio(TestActivity.listMyAnswer.get(position).traloi)
        binding.radGLbt.setOnCheckedChangeListener { radioGroup, i ->
            TestActivity.listMyAnswer.get(position).traloi = clickRadio(i)
        }
    }

    fun checkRadio(myA: String) {
        if (myA.equals("A")) {
            binding.rad1Lbt.isChecked = true
        } else if (myA.equals("B")) {
            binding.rad2Lbt.isChecked = true
        } else if (myA.equals("C")) {
            binding.rad3Lbt.isChecked = true
        } else if (myA.equals("D")) {
            binding.rad4Lbt.isChecked = true
        }
    }

    fun clickRadio(id: Int): String {
        if (id == R.id.rad1_lbt) {
            return "A"
        } else if (id == R.id.rad2_lbt) {
            return "B"
        } else if (id == R.id.rad3_lbt) {
            return "C"
        } else if (id == R.id.rad4_lbt) {
            return "D"
        }
        return ""
    }
}