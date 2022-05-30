package intent.project1.screens.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.isVisible
import intent.project1.screens.register.RegisterActivity
import intent.project1.screens.selection.SelectionActivity
import intetn.project1.R
import intetn.project1.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity(), LoginInterface {
    private lateinit var binding : ActivityMainBinding
    public lateinit var mloginPresenter : LoginPresenter
    lateinit var tvTB : TextView
    companion object{
        public var id : String=""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createBinding()
        setEvent()
    }
    fun setEvent(){
        tvTB.isVisible = false
        mloginPresenter = LoginPresenter(this)
        binding.btnDangNhap.setOnClickListener{
            checkLogin()
        }
        binding.tvDangKy.setOnClickListener(){
            val intent : Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun createBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tvTB = binding.tvTB
    }
    fun checkLogin(){
        val username = binding.tendn.text.toString()
        val password = binding.password.text.toString()
        mloginPresenter.checkEmpty(username,password)
    }

    override fun loginSuccess() {
        println("Đăng nhập thành công")
        id = mloginPresenter.user.email
        //println("getUser: "+mloginPresenter.user.email)
        val intent : Intent = Intent(this, SelectionActivity::class.java)
        intent.putExtra("user", mloginPresenter.user)
        startActivity(intent)
    }

    override fun logigError_Empty() {
        tvTB.isVisible = true
        tvTB.setText(R.string.logigError_Empty)
    }

    override fun loginError_Exit() {
        tvTB.isVisible = true
        tvTB.setText(R.string.loginError_Exit)
    }

    override fun loginError_Wrong_pw() {
        tvTB.isVisible = true
        tvTB.setText(R.string.loginError_Wrong_pw)
    }

    override fun loginError() {
        tvTB.isVisible = true
        tvTB.setText(R.string.loginError)
    }

}