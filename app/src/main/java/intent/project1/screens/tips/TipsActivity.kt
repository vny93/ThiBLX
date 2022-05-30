package intent.project1.screens.tips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import intent.project1.adapter.TipsTypeAdapter
import intent.project1.data.model.TipsType
import intetn.project1.R
import intetn.project1.databinding.ActivityMeothiBinding

class TipsActivity : AppCompatActivity(), TipsInterface {
    lateinit var binding : ActivityMeothiBinding
    private lateinit var tipsPresenter: TipsPresenter
    var tipsTypeAdapter: TipsTypeAdapter = TipsTypeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meothi)
        createBinding()
        getData()
        setToolbar()
    }

    fun getData(){
        tipsPresenter = TipsPresenter(this)
        tipsPresenter.loadListTips()
    }

    fun createBinding(){
        binding = ActivityMeothiBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun SetAdapterTips(list: List<TipsType>) {
        tipsTypeAdapter.setData(list)
        binding.lvLoaimeo.adapter = tipsTypeAdapter
        binding.lvLoaimeo.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    fun setToolbar(){
        var toolbar = binding.toolbarMeo
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    override fun TipsError() {
        println(R.string.SelectionError)
        Toast.makeText(this, R.string.SelectionError, Toast.LENGTH_SHORT).show()
    }
}