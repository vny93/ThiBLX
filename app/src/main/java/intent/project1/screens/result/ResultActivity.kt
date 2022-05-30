package intent.project1.screens.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import intent.project1.adapter.ResultAdapter
import intent.project1.data.model.ExamType
import intent.project1.data.model.NumberResult
import intent.project1.screens.theoryType.TheoryTypePresenter
import intetn.project1.R
import intetn.project1.databinding.ActivityKetquaBinding
import intetn.project1.databinding.ActivityLithuyetBinding

class ResultActivity : AppCompatActivity(),ResultInterface {
    lateinit var binding : ActivityKetquaBinding
    lateinit var resultPresenter: ResultPresenter
    var resultAdapter : ResultAdapter = ResultAdapter()
    companion object{
        lateinit var exams : ArrayList<NumberResult>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ketqua)
        createBinding()
        getData()
        setToolbar()
    }

    fun createBinding(){
        binding = ActivityKetquaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun getData(){
        resultPresenter = ResultPresenter(this)
        resultPresenter.getNumberExam()
    }

    fun setToolbar(){
        var toolbar = binding.toolbarKq
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    override fun getNumberError() {
        Toast.makeText(this, R.string.getNumberError, Toast.LENGTH_SHORT).show()
    }

    override fun setAdapterNumber() {
        resultAdapter.setData(exams)
        binding.rcvKq.adapter = resultAdapter
    }
}