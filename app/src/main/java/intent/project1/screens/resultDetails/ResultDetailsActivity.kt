package intent.project1.screens.resultDetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import intent.project1.data.model.Question
import intent.project1.data.model.Result
import intent.project1.screens.theory.StudyTheoryActivity
import intetn.project1.R
import intetn.project1.databinding.ActivityResultDetailsBinding

class ResultDetailsActivity : AppCompatActivity(), ResultDetailsInterface {
    lateinit var resultDetailsPresenter: ResultDetailsPresenter
    lateinit var binding : ActivityResultDetailsBinding

    companion object{
        lateinit var listQuestion : List<Question>
        lateinit var listResultChoose : List<Result>
        var position = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_details)
        position=0
        var intent : Intent = getIntent()
        var num = intent.getIntExtra("luotthi",0)
        createBinding()
        getData(num)
        setEvent()
        setToolbar(num)
    }

    fun createBinding(){
        binding = ActivityResultDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun getData(num : Int){
        resultDetailsPresenter = ResultDetailsPresenter(this)
        resultDetailsPresenter.getResultNumExam(num)
    }

    fun setEvent(){
        binding.tvTienKQ.setOnClickListener(){
            resultDetailsPresenter.upResult(position,FragmentResultDetails.size)
        }

        binding.tvLuiKQ.setOnClickListener(){
            resultDetailsPresenter.backResult(position)
        }
    }

    fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_frameKQ, fragment)
        transaction.commit()
    }

    fun setToolbar(num:Int){
        var toolbar = binding.toolbarCTKQ
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setTitle("Kết quả đề: "+num)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    override fun PositionUp(pos: Int) {
        position = pos
        replaceFragment(FragmentResultDetails())
    }

    override fun PositionBack(pos: Int) {
        position = pos
        replaceFragment(FragmentResultDetails())
    }

    override fun getResultSuccess() {
        replaceFragment(FragmentResultDetails())
    }

    override fun getResultError() {
        TODO("Not yet implemented")
    }

    override fun getResultNumError() {
        TODO("Not yet implemented")
    }


}