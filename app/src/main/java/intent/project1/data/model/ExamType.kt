package intent.project1.data.model

import java.io.Serializable

data class ExamType(val maloaide: Int, val socau:Int, val thoigian:Int, val tenloaide: String):Serializable
//class Loaide : Serializable {
//    private var maloaide: Int? = 0
//    private var socau:Int? = 0
//    private var thoigian:Int? = 0
//    private var tenloaide: String? = "null"
//
//    constructor()
//
//    constructor(maloaide: Int?, socau: Int?, thoigian: Int?, tenloaide: String?) {
//        this.maloaide = maloaide
//        this.socau = socau
//        this.thoigian = thoigian
//        this.tenloaide = tenloaide
//    }
//
//    fun getMaloaide(): Int? {
//        return maloaide
//    }
//
//    fun setMaloaide(maloaide: Int?) {
//        this.maloaide = maloaide
//    }
//
//    fun getSocau(): Int? {
//        return socau
//    }
//
//    fun setSocau(socau: Int?) {
//        this.socau = socau
//    }
//
//    fun getThoigian(): Int? {
//        return thoigian
//    }
//
//    fun setThoigian(thoigian: Int?) {
//        this.thoigian = thoigian
//    }
//
//    fun getTenloaide(): String? {
//        return tenloaide
//    }
//
//    fun setTenloaide(tenloaide: String?) {
//        this.tenloaide = tenloaide
//    }
//}