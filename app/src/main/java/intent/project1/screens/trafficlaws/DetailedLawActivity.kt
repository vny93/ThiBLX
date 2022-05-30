package intent.project1.screens.trafficlaws

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import intent.project1.adapter.TrafficLawsAdapter
import intent.project1.data.model.TrafficLaws
import intetn.project1.R
import intetn.project1.databinding.ActivityDetailedLawBinding
import intetn.project1.databinding.ActivityMeothiBinding

class DetailedLawActivity : AppCompatActivity(), TrafficLawsInterface {
    private lateinit var mTrafficLawsPresenter : TrafficLawsPresenter
    lateinit var binding : ActivityDetailedLawBinding
    var mTrafficLawsAdapter : TrafficLawsAdapter = TrafficLawsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_law)
        createBinding()
        getData()
        setToolbar()
    }

    fun createBinding(){
        binding = ActivityDetailedLawBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun getData(){
        mTrafficLawsPresenter = TrafficLawsPresenter(this)
        var intent: Intent = intent
        val maLoaiLuat = intent.getIntExtra("maLoailuat",0)
        mTrafficLawsPresenter.loadListLaw(maLoaiLuat)
    }

    override fun SetAdapterLaw(list: List<TrafficLaws>) {
        mTrafficLawsAdapter.setData(list)
        binding.rcvLuat.adapter = mTrafficLawsAdapter
        binding.rcvLuat.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    }

    fun setToolbar(){
        var toolbar = binding.toolbarChitietluat
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true;
    }

    override fun LawError() {
        Toast.makeText(this, R.string.SelectionError, Toast.LENGTH_SHORT).show()
    }
}