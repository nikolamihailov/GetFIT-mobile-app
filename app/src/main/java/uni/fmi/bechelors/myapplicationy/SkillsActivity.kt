package uni.fmi.bechelors.myapplicationy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SkillsActivity : AppCompatActivity() {

    private lateinit var handstand: Button
    private lateinit var humanFlag: Button
    private lateinit var planche: Button
    private lateinit var frontLever: Button
    private lateinit var backLever: Button
    private lateinit var lSit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)

        handstand = findViewById(R.id.hanstandButton)
        humanFlag = findViewById(R.id.humanFlagButton)
        planche = findViewById(R.id.plancheButton)
        frontLever = findViewById(R.id.frontLeverButton)
        backLever = findViewById(R.id.backLeverButton)
        lSit = findViewById(R.id.lSitButton)

        handstand.setOnClickListener(){
            val intent = Intent(this@SkillsActivity, HandstandActivity::class.java)
            startActivity(intent)
        }
        humanFlag.setOnClickListener(){
            val intent = Intent(this@SkillsActivity, HumanFlagActivity::class.java)
            startActivity(intent)
        }
        planche.setOnClickListener(){
            val intent = Intent(this@SkillsActivity, PlancheActivity::class.java)
            startActivity(intent)
        }
        frontLever.setOnClickListener(){
            val intent = Intent(this@SkillsActivity, FrontLeverActivity::class.java)
            startActivity(intent)
        }
        backLever.setOnClickListener(){
            val intent = Intent(this@SkillsActivity, BackLeverActivity::class.java)
            startActivity(intent)
        }
        lSit.setOnClickListener(){
            val intent = Intent(this@SkillsActivity, LSitActivity::class.java)
            startActivity(intent)
        }



    }
}