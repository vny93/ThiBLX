package intent.project1.screens.theory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import intent.project1.data.model.Question
import intetn.project1.R
import intetn.project1.databinding.ActivityStudyTheoryBinding

class StudyTheoryActivity : AppCompatActivity(), StudyTheoryInterface {
    lateinit var binding : ActivityStudyTheoryBinding
    private lateinit var studyTheoryPresenter: StudyTheoryPresenter

    companion object{
        lateinit var listQuestion : List<Question>
        var position = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_theory)
        position=0
        createBinding()
        getData()
        setEvent()
        setToolbar()
    }

    fun createBinding(){
        binding = ActivityStudyTheoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun getData(){
        studyTheoryPresenter = StudyTheoryPresenter(this)
        studyTheoryPresenter.loadListTheory()
    }

    fun setEvent(){
        binding.tvTien.setOnClickListener(){
            studyTheoryPresenter.upQuestion(position,FragmentTheory.size)
        }

        binding.tvLui.setOnClickListener(){
            studyTheoryPresenter.backQuestion(position)
        }
    }

    fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_frame3, fragment)
        transaction.commit()
    }

    fun setToolbar() {
        var toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        var intent : Intent = getIntent()
        var type = intent.getStringExtra("type")
        if (type != null) {
            toolbar.setTitle(type)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    override fun TheorySuccess() {
        replaceFragment(FragmentTheory())
    }

    override fun PositionUp(pos: Int) {
        position = pos
        replaceFragment(FragmentTheory())
    }

    override fun PositionBack(pos: Int) {
        position = pos
        replaceFragment(FragmentTheory())
    }

    override fun TheoryError() {
        Toast.makeText(this, R.string.TheoryError, Toast.LENGTH_SHORT).show()
    }
}