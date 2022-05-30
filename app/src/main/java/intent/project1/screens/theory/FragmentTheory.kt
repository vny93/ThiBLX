package intent.project1.screens.theory

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import intent.project1.data.model.Question
import intetn.project1.R
import intetn.project1.databinding.FragmentHoclithuyetBinding

class FragmentTheory : Fragment() {
    private lateinit var binding: FragmentHoclithuyetBinding
    private var position = 0

    companion object {
        var size: Int = 0
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHoclithuyetBinding.inflate(inflater, container, false)
        val view = binding.root
        position = StudyTheoryActivity.position
        getListQuestion(position)
        return view
    }

    fun getListQuestion(position: Int) {
        var question : Question = StudyTheoryActivity.listQuestion.get(position)
        size = StudyTheoryActivity.listQuestion.size
        var examAnswers = question.dapan.trim()

        binding.tvSTTcau.text = "Câu "+ (position+1)
        binding.tvCauhoilt.text = question.noidung
        binding.rad1.text = question.a
        binding.rad2.text = question.b
        if(question.hinhanh == null) binding.imvHinhanh.isVisible = false
        else Picasso.get().load(question.hinhanh).into(binding.imvHinhanh)
        if(question.c ==null) binding.rad3.isVisible = false
        else binding.rad3.text = question.c
        if(question.d ==null) binding.rad4.isVisible = false
        else binding.rad4.text = question.d
        binding.radG.setOnCheckedChangeListener { radioGroup, i -> clickRadio(i,examAnswers) }

    }

    fun clickRadio(id: Int, answer: String) {
        if (id == R.id.rad1) {
            if (answer.equals("A")) {
                binding.rad1.setBackgroundColor(Color.GREEN)
            } else binding.rad1.setBackgroundColor(Color.RED)
            binding.rad2.setBackgroundColor(Color.WHITE)
            binding.rad3.setBackgroundColor(Color.WHITE)
            binding.rad4.setBackgroundColor(Color.WHITE)
        } else if (id == R.id.rad2) {
            if (answer.equals("B")) {
                binding.rad2.setBackgroundColor(Color.GREEN)
            } else binding.rad2.setBackgroundColor(Color.RED)
            binding.rad1.setBackgroundColor(Color.WHITE)
            binding.rad3.setBackgroundColor(Color.WHITE)
            binding.rad4.setBackgroundColor(Color.WHITE)
        } else if (id == R.id.rad3) {
            if (answer.equals("C")) {
                binding.rad3.setBackgroundColor(Color.GREEN)
            } else binding.rad3.setBackgroundColor(Color.RED)
            binding.rad1.setBackgroundColor(Color.WHITE)
            binding.rad2.setBackgroundColor(Color.WHITE)
            binding.rad4.setBackgroundColor(Color.WHITE)
        } else if (id == R.id.rad4) {
            if (answer.equals("D")) {
                binding.rad4.setBackgroundColor(Color.GREEN)
            } else binding.rad4.setBackgroundColor(Color.RED)
            binding.rad1.setBackgroundColor(Color.WHITE)
            binding.rad2.setBackgroundColor(Color.WHITE)
            binding.rad3.setBackgroundColor(Color.WHITE)
        }
    }

}