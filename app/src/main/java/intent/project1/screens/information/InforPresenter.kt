package intent.project1.screens.information

import intent.project1.data.api.ApiUserService
import intent.project1.data.model.User
import intent.project1.screens.login.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InforPresenter {
    var inforInterface : InforInterface

    constructor(inforInterface: InforInterface) {
        this.inforInterface = inforInterface
    }

    fun checkEmpty(email : String, hoten: String, sdt:String){
        if(email.isEmpty() || hoten.isEmpty() || sdt.isEmpty()){
            inforInterface.InforEmpty()
            return
        }
        var user : User = User(email,hoten,sdt)
        updateUser(user)
    }

    fun LoadInformation(id : String){
        ApiUserService.ApiUser.apiUserService.getUserByID(id).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    var user : User? = response.body()
                    if (user != null) {
                        inforInterface.InforList(user)
                    }
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                inforInterface.InforError()
            }

        })
    }

    fun updateUser(user : User){
        ApiUserService.ApiUser.apiUserService.update(user).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                var email = response.body()?.email.toString()
                LoginActivity.id = email
                inforInterface.InforSuccess()
                LoadInformation(email)
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                inforInterface.InforError()
            }

        })
    }
}