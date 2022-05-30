package intent.project1.data.model

import java.io.Serializable

data class TipsType(val maLoaiMeo: Int, val tenLoaiMeo: String ): Serializable
//class Loaimeo : Serializable {
//    private var maLoaiMeo: Int? = null
//    private var tenLoaiMeo: String? = null
//
//    fun Loaimeo() {}
//
//    fun Loaimeo(maloaimeo: Int?, tenloaimeo: String?) {
//        maLoaiMeo = maloaimeo
//        tenLoaiMeo = tenloaimeo
//    }
//
//    fun getMaloaimeo(): Int? {
//        return maLoaiMeo
//    }
//
//    fun setMaloaimeo(maloaimeo: Int?) {
//        maLoaiMeo = maloaimeo
//    }
//
//    fun getTenloaimeo(): String? {
//        return tenLoaiMeo
//    }
//
//    fun setTenloaimeo(tenloaimeo: String?) {
//        tenLoaiMeo = tenloaimeo
//    }
//}