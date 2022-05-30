package intent.project1.screens.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import intetn.project1.R
import intetn.project1.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), RegisterInterface {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var mRegisterPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        createBinding()
        setEvent()
    }

    fun createBinding(){
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun setEvent(){
        mRegisterPresenter = RegisterPresenter(this)
        binding.btnDangKy.setOnClickListener(){
            var email = binding.edtEmail.text.toString()
            var hoten = binding.edtHoTen.text.toString()
            var sdt = binding.edtSDT.text.toString()
            var mk = binding.edtMatkhau.text.toString()
            mRegisterPresenter.checkEmpty(email,hoten,sdt,mk)
        }
    }

    override fun RegisterSuccess() {
        binding.edtEmail.setText("")
        binding.edtHoTen.setText("")
        binding.edtSDT.setText("")
        binding.edtMatkhau.setText("")
        Toast.makeText(this, R.string.RegisterSuccess, Toast.LENGTH_SHORT).show()
    }

    override fun RegisterError() {
        Toast.makeText(this, R.string.RegisterError, Toast.LENGTH_SHORT).show()
    }

    override fun RegisterErrorEmpty() {
        Toast.makeText(this, R.string.RegisterErrorEmpty, Toast.LENGTH_SHORT).show()
    }

    override fun RegisterErrorExits() {
        Toast.makeText(this, R.string.RegisterErrorExits, Toast.LENGTH_SHORT).show()
    }
}