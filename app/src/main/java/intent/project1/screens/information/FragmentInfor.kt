package intent.project1.screens.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import intent.project1.data.model.User
import intent.project1.screens.login.LoginActivity
import intetn.project1.R
import intetn.project1.databinding.FragmentInforBinding


class FragmentInfor : Fragment(), InforInterface {
    private lateinit var binding : FragmentInforBinding
    private lateinit var inforPresenter: InforPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentInforBinding.inflate(inflater,container,false)
        val view = binding.root
        inforPresenter = InforPresenter(this)
        getData()
        setEvent()
        return view
    }

    fun getData(){
        inforPresenter.LoadInformation(LoginActivity.id)
    }

    fun setEvent() {
        binding.fgBtnLuutt.setOnClickListener(){
            var email :String = binding.fgEdtEmail.text.toString().trim()
            var hoten : String = binding.fgEdtHoten.text.toString().trim()
            var sdt : String = binding.fgEdtSDT.text.toString().trim()
            inforPresenter.checkEmpty(email,hoten,sdt)
        }
    }

    override fun InforList(user: User) {
        binding.fgEdtEmail.setText(user.email)
        binding.fgEdtHoten.setText(user.hoten)
        binding.fgEdtSDT.setText(user.sdt)
    }

    override fun InforError() {
        Toast.makeText(context, R.string.SelectionError, Toast.LENGTH_SHORT).show()
    }

    override fun InforEmpty() {
        Toast.makeText(context, R.string.InforEmpty, Toast.LENGTH_SHORT).show()
    }

    override fun InforSuccess() {
        Toast.makeText(context, R.string.Success, Toast.LENGTH_SHORT).show()
    }

}