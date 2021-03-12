package uni.fmi.bechelors.myapplicationy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WorkoutsActivity : AppCompatActivity() {

    private lateinit var maleWs: Button
    private lateinit var femaleWs: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workouts)

        maleWs = findViewById(R.id.maleWorkoutsButton)
        femaleWs = findViewById(R.id.femaleWorkoutsButton)

        maleWs.setOnClickListener(){
            val intent = Intent(this@WorkoutsActivity, MaleWorkoutsActivity::class.java)
            startActivity(intent)
        }

        femaleWs.setOnClickListener(){
            val intent = Intent(this@WorkoutsActivity, FemaleWorkoutActivity::class.java)
            startActivity(intent)
        }
    }
}