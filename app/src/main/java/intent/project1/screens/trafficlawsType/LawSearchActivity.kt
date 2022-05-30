package intent.project1.screens.trafficlawsType

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import intent.project1.adapter.TrafficLawsTypeAdapter
import intent.project1.data.model.TrafficLawsType
import intetn.project1.R
import intetn.project1.databinding.ActivityTracuuluatBinding

class LawSearchActivity : AppCompatActivity(), TrafficLawsTypeInterface {
    lateinit var binding : ActivityTracuuluatBinding
    var trafficLawsTypeAdapter: TrafficLawsTypeAdapter = TrafficLawsTypeAdapter()
    private lateinit var trafficLawsTypePresenter : TrafficLawsTypePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracuuluat)
        createBinding()
        getData()
        setToolbar()
    }

    fun createBinding(){
        binding = ActivityTracuuluatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun getData(){
        trafficLawsTypePresenter = TrafficLawsTypePresenter(this)
        trafficLawsTypePresenter.loadListLawsType()
    }

    override fun SetAdapterLawsType(list: List<TrafficLawsType>) {
        trafficLawsTypeAdapter.setData(list)
        binding.rcvLoailuat.adapter = trafficLawsTypeAdapter
        binding.rcvLoailuat.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    fun setToolbar(){
        var toolbar = binding.toolbarLoailuat
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true;
    }

    override fun LawsTypeError() {
        Toast.makeText(this, R.string.SelectionError, Toast.LENGTH_SHORT).show()
    }
}