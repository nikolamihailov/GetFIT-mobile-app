package uni.fmi.bechelors.myapplicationy

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast



class BmiActivity : AppCompatActivity() {


        private lateinit var weight: EditText
        private lateinit var height: EditText
        private lateinit var calculateB: Button
        private lateinit var result: TextView




        @SuppressLint("SetTextI18n")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_bmi)



            weight = findViewById(R.id.weightEditText)
            height = findViewById(R.id.heightEditText)
            calculateB = findViewById(R.id.calculateBmiButton)
            result = findViewById(R.id.bmiTextView)



            calculateB.setOnClickListener {
                 val res: Double

                if ((weight.text.isNotEmpty() && weight.text.toString().toInt() != 0) && (height.text.isNotEmpty() && height.text.toString().toInt() != 0)) {
                    res = weight.text.toString().toDouble() / (height.text.toString()
                        .toDouble() * height.text.toString().toDouble()) * 10000
                    result.text = "Your BMI in % is: $res"

                    if(res <= 18.5){
                        Toast.makeText(applicationContext, "You should eat more! You are underweight!", Toast.LENGTH_LONG).show()
                    }
                    if(res > 18.5 && res <= 24.9 ){
                        Toast.makeText(applicationContext, " You are in perfect health!", Toast.LENGTH_LONG).show()
                    }
                    if(res > 24.9 && res <= 30.0 ){
                        Toast.makeText(applicationContext, " You should go on a diet! You are overweight!", Toast.LENGTH_LONG).show()
                    }
                    if(res > 30.0 ){
                        Toast.makeText(applicationContext, " You should go to a doctor! You are obese!", Toast.LENGTH_LONG).show()
                    }


                    Toast.makeText(applicationContext, " " + result.text.toString().substring(0, 22), Toast.LENGTH_LONG).show()

                }else

                Toast.makeText(applicationContext, "You must fill all fields and must not put 0 !", Toast.LENGTH_LONG).show()
            }
        }

}