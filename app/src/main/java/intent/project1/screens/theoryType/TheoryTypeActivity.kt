package intent.project1.screens.theoryType

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import intent.project1.adapter.TheoryTypeAdapter
import intent.project1.data.model.TheoryType
import intetn.project1.R
import intetn.project1.databinding.ActivityLithuyetBinding


class TheoryTypeActivity : AppCompatActivity(), TheoryTypeInterface {
    lateinit var binding : ActivityLithuyetBinding
    lateinit var theoryTypePresenter : TheoryTypePresenter
    var theoryTypeAdapter : TheoryTypeAdapter = TheoryTypeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lithuyet)
        createBinding()
        getData()
        setToolbar()
    }

    fun createBinding(){
        binding = ActivityLithuyetBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun getData(){
        theoryTypePresenter = TheoryTypePresenter(this)
        theoryTypePresenter.loadListTheoryType()
    }

    fun setToolbar(){
        var toolbar = binding.toolbarlt
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    override fun SetAdapter(list: List<TheoryType>) {
        theoryTypeAdapter.setData(list)
        binding.rcvLoailt.adapter = theoryTypeAdapter
        binding.rcvLoailt.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun TheoryTypeError() {
        Toast.makeText(this, R.string.TheoryTypeError, Toast.LENGTH_SHORT).show()
    }
}