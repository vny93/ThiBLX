package intent.project1.data.model

import java.io.Serializable

data class Question(val macauhoi: Int, val noidung: String,
                    val a:String, val b:String, val c:String, val d:String,
                    val dapan:String, val hinhanh:String):Serializable
//class Cauhoi : Serializable {
//    private var macauhoi: Int? = null
//    private var noidung: String? = null
//    private  var a:String? = null
//    private  var b:String? = null
//    private  var c:String? = null
//    private  var d:String? = null
//    private  var dapan:String? = null
//    private  var hinhanh:String? = null
//
//    fun Cauhoi() {}
//
//    fun Cauhoi(
//        macauhoi: Int?,
//        noidung: String?,
//        a: String,
//        b: String,
//        c: String,
//        d: String,
//        dapan: String,
//        hinhanh: String
//    ) {
//        this.macauhoi = macauhoi
//        this.noidung = noidung
//        this.a = a
//        this.b = b
//        this.c = c
//        this.d = d
//        this.dapan = dapan
//        this.hinhanh = hinhanh
//    }
//
//    fun getMacauhoi(): Int? {
//        return macauhoi
//    }
//
//    fun setMacauhoi(macauhoi: Int?) {
//        this.macauhoi = macauhoi
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
//    fun getA(): String? {
//        return a
//    }
//
//    fun setA(a: String) {
//        this.a = a
//    }
//
//    fun getB(): String? {
//        return b
//    }
//
//    fun setB(b: String) {
//        this.b = b
//    }
//
//    fun getC(): String? {
//        return c
//    }
//
//    fun setC(c: String) {
//        this.c = c
//    }
//
//    fun getD(): String? {
//        return d
//    }
//
//    fun setD(d: String) {
//        this.d = d
//    }
//
//    fun getDapan(): String? {
//        return dapan
//    }
//
//    fun setDapan(dapan: String) {
//        this.dapan = dapan
//    }
//
//    fun getHinhanh(): String? {
//        return hinhanh
//    }
//
//    fun setHinhanh(hinhanh: String) {
//        this.hinhanh = hinhanh
//    }
//}