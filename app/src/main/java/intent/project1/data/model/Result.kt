package intent.project1.data.model

import java.io.Serializable
import kotlin.Result

//data class Result(var id: Int, var phuongan: String, var luotthi: Int, var mauser: String, var macauhoi: Int ): Serializable
class Result: Serializable{
    var id : Int =0
    lateinit var phuongan: String
    var luotthi: Int = 0
    lateinit var mauser: String
    var macauhoi: Int =0
}

//class Ketqua : Serializable {
//    private var id: Int? = null
//    private var phuongan: String? = null
//    private var luotthi: Int? = null
//    private var mauser: String? = null
//    private var macauhoi: Int? = null
//
//    fun Ketqua() {}
//
//    fun Ketqua(id: Int?, phuongan: String?, luotthi: Int?, mauser: String?, macauhoi: Int?) {
//        this.id = id
//        this.phuongan = phuongan
//        this.luotthi = luotthi
//        this.mauser = mauser
//        this.macauhoi = macauhoi
//    }
//
//    fun getId(): Int? {
//        return id
//    }
//
//    fun setId(id: Int?) {
//        this.id = id
//    }
//
//    fun getPhuongan(): String? {
//        return phuongan
//    }
//
//    fun setPhuongan(phuongan: String?) {
//        this.phuongan = phuongan
//    }
//
//    fun getLuotthi(): Int? {
//        return luotthi
//    }
//
//    fun setLuotthi(luotthi: Int?) {
//        this.luotthi = luotthi
//    }
//
//    fun getMauser(): String? {
//        return mauser
//    }
//
//    fun setMauser(mauser: String?) {
//        this.mauser = mauser
//    }
//
//    fun getMacauhoi(): Int? {
//        return macauhoi
//    }
//
//    fun setMacauhoi(macauhoi: Int?) {
//        this.macauhoi = macauhoi
//    }
//}