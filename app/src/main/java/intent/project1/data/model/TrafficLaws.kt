package intent.project1.data.model

import java.io.Serializable


data class TrafficLaws(val maluat: Int, val noidung: String, val mucphat:String ): Serializable
//class Luat : Serializable {
//    private var maluat: Int? = null
//    private var noidung: String? = null
//    private var mucphat:String? = null
//
//    fun Luat() {}
//
//    fun Luat(maluat: Int?, noidung: String?, mucphat: String) {
//        this.maluat = maluat
//        this.noidung = noidung
//        this.mucphat = mucphat
//    }
//
//    fun getMaluat(): Int? {
//        return maluat
//    }
//
//    fun setMaluat(maluat: Int?) {
//        this.maluat = maluat
//    }
//
//    fun getNoidung(): String? {
//        return noidung
//    }
//
//    fun setNoidung(noidung: String?) {
//        this.noidung = noidung
//    }
//
//    fun getMucphat(): String? {
//        return mucphat
//    }
//
//    fun setMucphat(mucphat: String) {
//        this.mucphat = mucphat
//    }
//}