package intent.project1.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import intent.project1.screens.result.ResultActivity
import intent.project1.activity.*
import intent.project1.screens.test.TestActivity
import intent.project1.screens.theoryType.TheoryTypeActivity
import intent.project1.screens.tips.TipsActivity
import intent.project1.screens.trafficlawsType.LawSearchActivity
import intetn.project1.databinding.FragmentMenuBinding

class FragmentMenu : Fragment() {
    private lateinit var binding : FragmentMenuBinding
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentMenuBinding.inflate(inflater,container,false)
        setEvent()
        return binding.root
    }

    fun setEvent() {
        binding.imvHoclithuyet.setOnClickListener() {
            //  var intent : Intent = Intent(context,LithuyetActivity::class.java)
            var intent: Intent = Intent(context, TheoryTypeActivity::class.java)
            startActivity(intent)
        }
        binding.imvLambaithi.setOnClickListener() {
            var intent: Intent = Intent(context, TestActivity::class.java)
            startActivity(intent)
        }
        binding.imvKetqua.setOnClickListener() {
            var intent: Intent = Intent(context, ResultActivity::class.java)
            startActivity(intent)
        }
        binding.imvMeo.setOnClickListener() {
            println("meo")
            var intent: Intent = Intent(context, TipsActivity::class.java)
            startActivity(intent)
        }
        binding.imvCausai.setOnClickListener() {
            var intent: Intent = Intent(context, WrongResultActivity::class.java)
            startActivity(intent)
        }
        binding.imvluat.setOnClickListener() {
            var intent: Intent = Intent(context, LawSearchActivity::class.java)
            startActivity(intent)
        }
    }
}