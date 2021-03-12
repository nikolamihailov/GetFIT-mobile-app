package uni.fmi.bechelors.myapplicationy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FemaleWorkoutActivity : AppCompatActivity() {

    private lateinit var legsButtWs: Button
    private lateinit var fullBodyWs: Button
    private lateinit var fAbsWs: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_female_workout)

        legsButtWs = findViewById(R.id.legsAndButtButton)
        fullBodyWs = findViewById(R.id.femaleFullBodyButton)
        fAbsWs = findViewById(R.id.fAbsButton)

        legsButtWs.setOnClickListener() {
            val intent = Intent(this@FemaleWorkoutActivity, LegsAndButtActivity::class.java)
            startActivity(intent)
        }
        fullBodyWs.setOnClickListener(){
            val intent = Intent(this@FemaleWorkoutActivity, FemaleFullBodyActivity::class.java)
            startActivity(intent)
        }
        fAbsWs.setOnClickListener(){
            val intent = Intent(this@FemaleWorkoutActivity, FemaleAbsActivity::class.java)
            startActivity(intent)
        }
    }
}