package intent.project1.screens.login

import intent.project1.data.api.ApiAccountService
import intent.project1.data.api.ApiUserService
import intent.project1.data.model.Account
import intent.project1.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter {
     var mloginInterface: LoginInterface
     public lateinit var user : User

    public constructor(mloginInterface: LoginInterface) {
        this.mloginInterface = mloginInterface
    }

    fun checkEmpty(tk: String, mk: String){
        if(!tk.equals("") && !mk.equals("")){
            checkUserExit(tk,mk)
        }
        else{
            mloginInterface.logigError_Empty()
        }
    }
    fun checkUserExit(tk: String, mk: String) {
        ApiAccountService.ApiTK.API_ACCOUNT_SERVICE.getTKByID(tk).enqueue(object : Callback<Account> {
            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if (response.isSuccessful) {
                    //  checkPassword(tk,mk)
                    getUserByTk(tk)
                }
            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                mloginInterface.loginError_Exit()
            }

        })
    }
 //   var loginActivity : LoginActivity = LoginActivity()
    fun getUserByTk(tk : String){
        ApiUserService.ApiUser.apiUserService.getUserByID(tk).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    user = response.body()!!
               //     LoginActivity().id = user.email
//                    loginActivity.id = user.email
//                    println("id longin1: "+loginActivity.id)
                    mloginInterface.loginSuccess()
                }

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                mloginInterface.loginError_Wrong_pw()
            }

        })
    }

}