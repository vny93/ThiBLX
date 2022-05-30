package intent.project1.screens.menu

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import intent.project1.data.model.User
import intent.project1.fragment.FragmentMenu
import intent.project1.screens.account.FragmentAccount
import intent.project1.screens.information.FragmentInfor
import intent.project1.screens.login.LoginActivity
import intetn.project1.R
import intetn.project1.databinding.ActivityMenuBinding
import intetn.project1.databinding.HeaderNaviBinding

class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    MenuInterface {
    private lateinit var binding: ActivityMenuBinding
    companion object {
        var idTestKit : Int = 0
    }
    //  private lateinit var binding_header: HeaderNaviBinding
    private lateinit var mMenuPresenter: MenuPresenter
    lateinit var toggle: ActionBarDrawerToggle
    public var FRAGMENT_1 = 0
    public var FRAGMENT_2 = 1
    public var FRAGMENT_3 = 2
    public var FRAGMENT_4 = 3
    public var FRAGMENT_5 = 4
    public var mCurrentFragment = FRAGMENT_1
    public lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        createBingding()
        mMenuPresenter = MenuPresenter(this)
        setView()
    }

    fun createBingding() {
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding_header = HeaderNaviBinding.inflate(layoutInflater)
        //   setContentView(binding_header.root)
    }

    fun setView() {
        drawerLayout = binding.drawerLayout
        val toolbar: Toolbar = binding.toolbar
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        var navigationView: NavigationView = binding.navigationView
        navigationView.setNavigationItemSelectedListener(this)
        replaceFragment(FragmentMenu())
        navigationView.menu.findItem(R.id.nax_1).setCheckable(true)

        //lay user
        var intent: Intent = getIntent()
        var data: User =
            intent.getSerializableExtra("data") as User //ở đây cần ép kiểu về User nếu không sẽ báo lỗi
        println("data: " + data.email)

        //lấy mã bộ đề
        var maloaide: Int = intent.getIntExtra("maloaide", 0)
        var maLoaiBL: Int = intent.getIntExtra("maloaiBL", 0)
        mMenuPresenter.getExamCode(maLoaiBL, maloaide)

        //ánh xạ header_nav
//        var headerLayout = navigationView.getHeaderView(0)
//        var tvUsername = headerLayout.findViewById<View>(R.id.tvUsername) as TextView
//        var tvEmail2 = headerLayout.findViewById<View>(R.id.tvEmail2) as TextView
//        tvEmail2.text = data.email
//        tvUsername.text = data.hoten
        val headerBinding: HeaderNaviBinding =HeaderNaviBinding.bind(binding.navigationView.getHeaderView(0))
        headerBinding.tvEmail2.text = data.email
        headerBinding.tvUsername.text = data.hoten

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        if (id == R.id.nax_1) {
            if (mCurrentFragment != FRAGMENT_1) {
                replaceFragment(FragmentMenu())
                mCurrentFragment = FRAGMENT_1
            }
        } else if (id == R.id.nax_2) {
            if (mCurrentFragment != FRAGMENT_2) {
                //  replaceFragment(Fragment2())
                mCurrentFragment = FRAGMENT_2
            }
        } else if (id == R.id.nax_3) {
            if (mCurrentFragment != FRAGMENT_3) {
                //   replaceFragment(Fragment3())
                mCurrentFragment = FRAGMENT_3
            }
        } else if (id == R.id.nax_4) {
            if (mCurrentFragment != FRAGMENT_4) {
                replaceFragment(FragmentInfor())
                mCurrentFragment = FRAGMENT_4

            }
        } else if (id == R.id.nax_5) {
            if (mCurrentFragment != FRAGMENT_5) {
                replaceFragment(FragmentAccount())
                mCurrentFragment = FRAGMENT_5
            }
        } else if (id == R.id.nax_6) {
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return false
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_frame, fragment)
        transaction.commit()
    }

    override fun getExamCode_Success() {
        Toast.makeText(this, R.string.getExamCode_Success, Toast.LENGTH_SHORT).show()
    }

    override fun getExamCode_Error() {
        Toast.makeText(this, R.string.getExamCode_Error, Toast.LENGTH_SHORT).show()
    }
}