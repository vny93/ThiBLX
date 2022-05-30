package intent.project1.screens.selection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import intent.project1.screens.menu.MenuActivity
import intent.project1.adapter.DegreeTypeAdapter
import intent.project1.adapter.ExamTypeAdapter
import intent.project1.data.model.DegreeType
import intent.project1.data.model.ExamType
import intent.project1.data.model.User
import intetn.project1.R
import intetn.project1.databinding.ActivitySelectionBinding

class SelectionActivity : AppCompatActivity(), SelectionInterface {
    private lateinit var mselectionPresenter: SelectionPresenter
    private lateinit var binding : ActivitySelectionBinding
    var examTypeAdapter : ExamTypeAdapter = ExamTypeAdapter()
    var degreeTypeAdapter : DegreeTypeAdapter = DegreeTypeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
        createBinding()
        getData()
        setEvent()


    }
    fun createBinding(){
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun setEvent(){
        binding.btnChoose.setOnClickListener(){
            var maloaide = examTypeAdapter.maLoaide
            var maloaiBL = degreeTypeAdapter.maLoaiBL
            println("getMaloaiDe: "+maloaide)
            println("getMaloaiBL "+maloaiBL)
            mselectionPresenter.checkEmpty(maloaide,maloaiBL)
        }
    }

    fun getData(){
        mselectionPresenter = SelectionPresenter(this)
        mselectionPresenter.getExamType()
        mselectionPresenter.getDriverLicense()
    }

    override fun SelectionSuccess(id1: Int, id2: Int) {
        var intent1 : Intent = getIntent()
        var data : User = intent1.getSerializableExtra("user") as User //ở đây cần ép kiểu về User nếu không sẽ báo lỗi
        val intent : Intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("data",data)
        intent.putExtra("maloaide",id1)
        intent.putExtra("maloaiBL",id2)
        startActivity(intent)
    }


    override fun SetAdapterLD(list: List<ExamType>) {
        examTypeAdapter.setData(list)
        binding.lvloaide.adapter = examTypeAdapter
        //đổ theo chiều ngang hay dọc
        // reverseLayou : true: đảo chiều, false: kh đảo chiều
        binding.lvloaide.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    }

    override fun SetAdapterLBL(list: List<DegreeType>) {
        degreeTypeAdapter.setData(list)
        binding.lvloaiBL.adapter = degreeTypeAdapter
        binding.lvloaiBL.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun SelectionErrorEmpty() {
        Toast.makeText(this, R.string.SelectionEmpty, Toast.LENGTH_SHORT).show()
    }

    override fun SelectionError() {
        Toast.makeText(this, R.string.SelectionError, Toast.LENGTH_SHORT).show()
    }
}
