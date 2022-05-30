package intent.project1.screens.test

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import intent.project1.adapter.CheckAnswerAdapter
import intent.project1.data.model.Answer
import intent.project1.data.model.Question
import intetn.project1.R
import intetn.project1.databinding.ActivityLambaithiBinding
import intetn.project1.databinding.DialogCheckanswerBinding
import intetn.project1.databinding.DialogXemdiemBinding
import java.util.concurrent.TimeUnit

class TestActivity : AppCompatActivity(),TestInterface {
    lateinit var binding : ActivityLambaithiBinding
 //   lateinit var testPresenter : TestPresenter
    lateinit var timer : CounterClass
    var checkAnswerAdapter : CheckAnswerAdapter = CheckAnswerAdapter()

    companion object{
        lateinit var testPresenter : TestPresenter
        lateinit var listMyQuestion : List<Question>
        lateinit var listMyAnswer : ArrayList<Answer>
        lateinit var tvTimer : TextView
        var position = 0
        fun getPosition_test():Int{
            return position
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lambaithi)
        createBinding()
        tvTimer = binding.tvTimer
        //    timer = CounterClass(2 * 60 * 1000, 1000)
        timer = CounterClass(5 * 1000, 1000)
        getData()
        setEvent()
    }

    fun createBinding(){
        binding = ActivityLambaithiBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun getData(){
        testPresenter = TestPresenter(this)
        testPresenter.getListExam()
    }

    fun setEvent(){
        binding.tvTienLbt.setOnClickListener(){
            testPresenter.upQuestion(position,FragmentTest.size)
        }

        binding.tvLuiLbt.setOnClickListener(){
            testPresenter.backQuestion(position)
        }

        binding.tvKiemTra.setOnClickListener(){
            checkAnswer()
        }

        binding.tvKetthuc.setOnClickListener(){
            timer.cancel()
            checkPoint()
        }

        timer.start()

    }

     class CounterClass(millisInFuture: Long, countDownInterval: Long): CountDownTimer(millisInFuture,countDownInterval){
        override fun onTick(p0: Long) {
            var coutTime = String.format("%02d:%02d",TimeUnit.MILLISECONDS.toMinutes(p0),TimeUnit.MILLISECONDS.toSeconds(p0) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(p0)))
            tvTimer.text = coutTime
        }

        override fun onFinish() {
            tvTimer.text = "00:00"
                //chưa giải quyết được
           // TestActivity().checkPoint()
           // var dialog : Dialog = Dialog(getCon)
        }
    }

    fun checkPoint(){
        var count = testPresenter.countCorrect()
        var dialog : Dialog = Dialog(this)
        var binding2 : DialogXemdiemBinding = DialogXemdiemBinding.inflate(layoutInflater)
        dialog.setContentView(binding2.root)

        binding2.tvcaudung.text = ""+count+"/"+ listMyQuestion.size
        binding2.btnLamlai.setOnClickListener(){
            testPresenter.createList(listMyQuestion)
            position = 0
            dialog.dismiss()
            replaceFragment(FragmentTest())
            timer.start()
        }

        binding2.btnThoat.setOnClickListener(){
            dialog.dismiss()
            testPresenter.getMaxNumber()
            finish()
        }
        dialog.show()
    }

    fun checkAnswer(){
        var dialog : Dialog = Dialog(this)
        var binding3 : DialogCheckanswerBinding = DialogCheckanswerBinding.inflate(layoutInflater)
        dialog.setContentView(binding3.root)
        checkAnswerAdapter.setData(listMyQuestion)
        binding3.gvQuestion.adapter = checkAnswerAdapter
        checkAnswerAdapter.onItemClick = {
            question -> replaceFragment(FragmentTest())
            dialog.dismiss()
        }

        binding3.btnDong.setOnClickListener(){
            dialog.dismiss()
        }
        dialog.show()
    }

    fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_frame4, fragment)
        transaction.commit()
    }

    override fun PositionUp(pos: Int) {
        position = pos
        replaceFragment(FragmentTest())
    }

    override fun PositionBack(pos: Int) {
        position = pos
        replaceFragment(FragmentTest())
    }

    override fun InsertSuccess() {
        Toast.makeText(this, R.string.InsertSuccess, Toast.LENGTH_SHORT).show()
    }

    override fun getMaxError() {
        Toast.makeText(this, R.string.getMaxError, Toast.LENGTH_SHORT).show()
    }

    override fun TestInsertError() {
        Toast.makeText(this, R.string.TestInsertError, Toast.LENGTH_SHORT).show()
    }

    override fun getListError() {
        Toast.makeText(this, R.string.getListError, Toast.LENGTH_SHORT).show()
    }

    override fun GetlistQ() {
        replaceFragment(FragmentTest())
    }

}