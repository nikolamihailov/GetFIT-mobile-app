package uni.fmi.bechelors.myapplicationy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils

import android.widget.*
import androidx.core.view.isNotEmpty


class RegisterActivity : AppCompatActivity() {

    private lateinit var regButton2: Button
    private lateinit var cancelButton: Button
    private lateinit var nameEt: EditText
    private lateinit var usernameEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var rPasswordEt: EditText
    private lateinit var genderRG: RadioGroup
    private lateinit var maleRB: RadioButton
    private lateinit var femaleRB: RadioButton
    private lateinit var otherRB: RadioButton

    private var name: String? = ""
    private var username: String? = ""
    private var password: String? = ""
    private var rpassword: String? = ""
    private var gender: String? = ""


    private lateinit var dbHelper: DbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        nameEt = findViewById(R.id.nameEditText)
        usernameEt = findViewById(R.id.usernameEditText)
        passwordEt = findViewById(R.id.passwordEditText)
        rPasswordEt = findViewById(R.id.rPasswordEditText)
        genderRG = findViewById(R.id.genderRadioGroup)
        maleRB = findViewById(R.id.MaleRadioButton)
        femaleRB = findViewById(R.id.FemaleRadioButton)
        otherRB = findViewById(R.id.otherRadioButton)

        if(maleRB.isActivated){
            gender = maleRB.toString()

        }
        if(femaleRB.isActivated){
            gender = femaleRB.toString()

        }
        if(otherRB.isActivated){
            gender = otherRB.toString()

        }

        dbHelper = DbHelper(this)

        regButton2 = findViewById(R.id.registerButton2)
        cancelButton = findViewById(R.id.cancelButton)

        regButton2.setOnClickListener{
            if(addRecord()){
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        cancelButton.setOnClickListener {
            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun addRecord(): Boolean{

        name = "" + nameEt.text.toString().trim()
        username = "" + usernameEt.text.toString().trim()
        password = "" + passwordEt.text.toString().trim()
        rpassword = "" + rPasswordEt.text.toString().trim()
        gender

        if(password != rpassword){
            Toast.makeText(applicationContext, "Password must be the same!", Toast.LENGTH_LONG).show()
            return false
        }

        if(nameEt.text.toString().isNotEmpty() && usernameEt.text.toString().isNotEmpty() && passwordEt.text.toString().isNotEmpty() && rPasswordEt.text.toString().isNotEmpty() && genderRG.isNotEmpty()){
            dbHelper.addUser(""+name, ""+username, ""+password, ""+gender)
            Toast.makeText(applicationContext, "User added!", Toast.LENGTH_LONG).show()

        }else{
            if(TextUtils.isEmpty(name) && TextUtils.isEmpty(username) && TextUtils.isEmpty(password) && TextUtils.isEmpty(rpassword) && gender.isNullOrEmpty()) {
                nameEt.error = "You must fill this field!"
                usernameEt.error = "You must fill this field!"
                passwordEt.error = "You must fill this field!"
                rPasswordEt.error = "You must fill this field!"
            }
            Toast.makeText(applicationContext, "Please fill all fields! ", Toast.LENGTH_LONG).show()
            return false
        }
        return true



    }


}