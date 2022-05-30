package intent.project1.data.model

import java.io.Serializable

data class TrafficLawsType(val maLoaiLuatGt: Int, val tenLoaiLuatGt: String ):Serializable
//class Loailuat : Serializable {
//    private var maLoaiLuatGt: Int? = null
//    private var tenLoaiLuatGt: String? = null
//
//    fun Loailuat() {}
//
//    fun Loailuat(maLoaiLuatGt: Int?, tenLoaiLuatGt: String?) {
//        this.maLoaiLuatGt = maLoaiLuatGt
//        this.tenLoaiLuatGt = tenLoaiLuatGt
//    }
//
//    fun getMaLoaiLuatGt(): Int? {
//        return maLoaiLuatGt
//    }
//
//    fun setMaLoaiLuatGt(maLoaiLuatGt: Int?) {
//        this.maLoaiLuatGt = maLoaiLuatGt
//    }
//
//    fun getTenLoaiLuatGt(): String? {
//        return tenLoaiLuatGt
//    }
//
//    fun setTenLoaiLuatGt(tenLoaiLuatGt: String?) {
//        this.tenLoaiLuatGt = tenLoaiLuatGt
//    }
//}