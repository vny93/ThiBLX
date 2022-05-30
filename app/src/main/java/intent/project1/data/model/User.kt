package intent.project1.data.model

import java.io.Serializable

data class User(val email:String, val hoten:String, val sdt: String): Serializable


//class User : Serializable {
//    private var email: String? =null
//    private var hoten: String? =null
//    private var sdt: String? =null
//
//    constructor()
//    constructor(email: String, hoten: String, sdt: String) {
//        this.email = email
//        this.hoten = hoten
//        this.sdt = sdt
//    }
//
//
//    fun setEmail(email: String){
//        this.email = email
//    }
//
//    fun getEmail(): String? {
//        return email
//    }
//
//    fun getHoten(): String? {
//        return hoten
//    }
//
//    fun setHoten(hoten: String) {
//        this.hoten = hoten
//    }
//
//    fun getSdt(): String? {
//        return sdt
//    }
//
//    fun setSdt(sdt: String) {
//        this.sdt = sdt
//    }

//}