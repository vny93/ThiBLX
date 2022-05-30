package intent.project1.screens.register

import android.widget.Toast
import intent.project1.data.api.ApiUserService
import intent.project1.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter {
    var mregisterInterface : RegisterInterface

    constructor(mregisterInterface: RegisterInterface) {
        this.mregisterInterface = mregisterInterface
    }

    fun checkEmpty(email :String, hoten: String, sdt:String, mk: String){
        if(email.isEmpty() || hoten.isEmpty() || sdt.isEmpty() || mk.isEmpty()) {
            mregisterInterface.RegisterErrorEmpty()
            return
        }
        checkUserExists(email, hoten, sdt, mk)
    }

    fun checkUserExists(email :String, hoten: String, sdt:String, mk: String){
        ApiUserService.ApiUser.apiUserService.getUserByID(email).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                    mregisterInterface.RegisterErrorExits()
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                register(email, hoten, sdt, mk)
            }

        })
    }

    fun register(email :String, hoten: String, sdt:String, mk: String){
        ApiUserService.ApiUser.apiUserService.insertTK(email,hoten,sdt,mk).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                mregisterInterface.RegisterSuccess()
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                mregisterInterface.RegisterError()
            }

        })
    }
}