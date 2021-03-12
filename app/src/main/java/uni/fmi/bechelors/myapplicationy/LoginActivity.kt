package uni.fmi.bechelors.myapplicationy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var login2: Button
    private lateinit var userEt: EditText
    private lateinit var passEt: EditText

    private lateinit var dbHelper: DbHelper

    private var username: String? = ""
    private var password: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userEt = findViewById(R.id.userEditText)
        passEt = findViewById(R.id.passEditText)


        dbHelper = DbHelper(this)

        login2 = findViewById(R.id.loginButton2)

        login2.setOnClickListener(clickListener)




    }
    private val clickListener = View.OnClickListener {
        if (userEt.text.isNotEmpty() && passEt.text.isNotEmpty()) {
            username = "" + userEt.text.toString().trim()
            password = "" + passEt.text.toString().trim()

            if (checkLogin()) {

                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }else {

            Toast.makeText(applicationContext, "Please fill all fields! ", Toast.LENGTH_LONG).show()
        }
    }
    private fun checkLogin(): Boolean{

        if(dbHelper.isLoginSuccessful("" + username, "" + password)){
            Toast.makeText(applicationContext, "You successfully entered the app!", Toast.LENGTH_LONG).show()
            return true
        }else{
            Toast.makeText(applicationContext, "YOU SHALL NOT PASS!", Toast.LENGTH_LONG).show()
        }
        return false





    }

}