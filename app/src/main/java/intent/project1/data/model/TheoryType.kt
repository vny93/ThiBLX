package intent.project1.data.model

import java.io.Serializable

data class TheoryType(val maLoaiLiThuyet: Int, val tenloai: String):Serializable
//class Loailithuyet : Serializable {
//    private var maLoaiLiThuyet: Int? = null
//    private var tenloai: String? = null
//
//    fun Loailithuyet(maLoaiLiThuyet: Int?, tenloai: String?) {
//        this.maLoaiLiThuyet = maLoaiLiThuyet
//        this.tenloai = tenloai
//    }
//
//    fun Loailithuyet() {}
//
//    fun getMaLoaiLiThuyet(): Int? {
//        return maLoaiLiThuyet
//    }
//
//    fun setMaLoaiLiThuyet(maLoaiLiThuyet: Int?) {
//        this.maLoaiLiThuyet = maLoaiLiThuyet
//    }
//
//    fun getTenloai(): String? {
//        return tenloai
//    }
//
//    fun setTenloai(tenloai: String?) {
//        this.tenloai = tenloai
//    }
//}