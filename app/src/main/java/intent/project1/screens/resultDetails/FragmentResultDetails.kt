package intent.project1.screens.resultDetails

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import intent.project1.data.model.Question
import intent.project1.data.model.Result
import intetn.project1.databinding.FragmentChitietkqBinding


class FragmentResultDetails : Fragment() {
    private lateinit var binding: FragmentChitietkqBinding
    private var position = 0

    companion object {
        var size: Int = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChitietkqBinding.inflate(inflater, container, false)
        val view = binding.root
        position = ResultDetailsActivity.position
        getResult(position)
        return view
    }

    fun getResult(position: Int) {
        var result : Result = ResultDetailsActivity.listResultChoose.get(position)
        var question : Question = ResultDetailsActivity.listQuestion.get(position)
        var answer = question.dapan.trim()
        var myanswer = result.phuongan.trim()
        size = ResultDetailsActivity.listQuestion.size
        binding.tvSTTcauTckq.text = "Câu " + (position + 1)
        binding.tvCauhoiCtkq.text = question.noidung
        binding.rad1Ctkq.text = question.a
        binding.rad2Ctkq.text = question.b
        if(question.hinhanh == null) binding.imvHinhanhKq.isVisible = false
        else Picasso.get().load(question.hinhanh).into(binding.imvHinhanhKq)
        if(question.c ==null) binding.rad3Ctkq.isVisible = false
        else binding.rad3Ctkq.text = question.c
        if(question.d ==null) binding.rad4Ctkq.isVisible = false
        else binding.rad4Ctkq.text = question.d
        checkRadio(position,myanswer,answer)

    }

    fun checkRadio(pos: Int, myanswer: String, answer: String) {
        if (myanswer.equals("A")) {
            binding.rad1Ctkq.isChecked = true
            if (answer.equals("A")) {
                binding.rad1Ctkq.setBackgroundColor(Color.GREEN)
            } else {
                binding.rad1Ctkq.setBackgroundColor(Color.RED)
                find(answer)
            }
        } else if (myanswer.equals("B")) {
            binding.rad2Ctkq.isChecked = true
            if (answer.equals("B")) {
                binding.rad2Ctkq.setBackgroundColor(Color.GREEN)
            } else {
                binding.rad2Ctkq.setBackgroundColor(Color.RED)
                find(answer)
            }
        } else if (myanswer.equals("C")) {
            binding.rad3Ctkq.isChecked = true
            if (answer.equals("C")) {
                binding.rad3Ctkq.setBackgroundColor(Color.GREEN)
            } else {
                binding.rad3Ctkq.setBackgroundColor(Color.RED)
                find(answer)
            }
        } else if (myanswer.equals("D")) {
            binding.rad4Ctkq.isChecked = true
            if (answer.equals("D")) {
                binding.rad4Ctkq.setBackgroundColor(Color.GREEN)
            } else {
                binding.rad4Ctkq.setBackgroundColor(Color.RED)
                find(answer)
            }
        }
    }

    fun find(answer: String) {
        if (answer == "A") {
            binding.rad1Ctkq.setBackgroundColor(Color.GREEN)
        }
        if (answer == "B") {
            binding.rad2Ctkq.setBackgroundColor(Color.GREEN)
        }
        if (answer == "C") {
            binding.rad3Ctkq.setBackgroundColor(Color.GREEN)
        }
        if (answer == "D") {
            binding.rad4Ctkq.setBackgroundColor(Color.GREEN)
        }
    }
}