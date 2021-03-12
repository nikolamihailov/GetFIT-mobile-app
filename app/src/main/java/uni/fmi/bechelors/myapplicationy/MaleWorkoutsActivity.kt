package uni.fmi.bechelors.myapplicationy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MaleWorkoutsActivity : AppCompatActivity() {

    private lateinit var chestWs: Button
    private lateinit var backWs: Button
    private lateinit var absWs: Button
    private lateinit var armsWs: Button
    private lateinit var fullbWs: Button
    private lateinit var legsWs: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_male_workouts)

        chestWs = findViewById(R.id.chestButton)
        backWs = findViewById(R.id.backButton)
        absWs = findViewById(R.id.absButton)
        armsWs = findViewById(R.id.armsButton)
        fullbWs = findViewById(R.id.fullBodyButton)
        legsWs = findViewById(R.id.legsButton)

        chestWs.setOnClickListener(){
            val intent = Intent(this@MaleWorkoutsActivity, ChestActivity::class.java)
            startActivity(intent)
        }
        backWs.setOnClickListener(){
            val intent = Intent(this@MaleWorkoutsActivity, BackActivity::class.java)
            startActivity(intent)
        }
        absWs.setOnClickListener(){
            val intent = Intent(this@MaleWorkoutsActivity, AbsActivity::class.java)
            startActivity(intent)
        }
        armsWs.setOnClickListener(){
            val intent = Intent(this@MaleWorkoutsActivity, ArmsActivity::class.java)
            startActivity(intent)
        }
        fullbWs.setOnClickListener(){
            val intent = Intent(this@MaleWorkoutsActivity, FullBodyActivity::class.java)
            startActivity(intent)
        }
        legsWs.setOnClickListener(){
            val intent = Intent(this@MaleWorkoutsActivity, LegsActivity::class.java)
            startActivity(intent)
        }
    }
}