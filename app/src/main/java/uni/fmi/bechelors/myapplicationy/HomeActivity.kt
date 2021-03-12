package uni.fmi.bechelors.myapplicationy




import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class HomeActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {

    private var drawer: DrawerLayout? = null
    private lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawer = findViewById(R.id.drawer_layout)

        dbHelper = DbHelper(this)


        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)




    }

    override fun onNavigationItemSelected( menuItem: MenuItem): Boolean {
        val id = menuItem.itemId
        if(id == R.id.nav_BMI){
            val intent = Intent(this@HomeActivity, BmiActivity::class.java)
            startActivity(intent)
        }
        if(id == R.id.nav_about){
            val intent = Intent(this@HomeActivity, AboutActivity::class.java)
            startActivity(intent)
        }
        if(id == R.id.nav_logout){
            val intent = Intent(this@HomeActivity, LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext, "You just logged out of the app!", Toast.LENGTH_LONG).show()
        }
        if(id == R.id.nav_dice){
            val intent = Intent(this@HomeActivity, DiceActivity::class.java)
            startActivity(intent)

        }
        if(id == R.id.nav_skills){
            val intent = Intent(this@HomeActivity, SkillsActivity::class.java)
            startActivity(intent)

        }

        if(id == R.id.nav_workout){

            val intent = Intent(this@HomeActivity, WorkoutsActivity::class.java)
            startActivity(intent)
        }

        drawer?.closeDrawer(GravityCompat.START)
        return true

    }

    override fun onBackPressed() {
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
            Toast.makeText(applicationContext, "You just logged out of the app", Toast.LENGTH_LONG).show()
        }
    }


}
