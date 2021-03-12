package uni.fmi.bechelors.myapplicationy

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper


class DbHelper(context: Context?) :SQLiteOpenHelper(
        context,
        Constants.DB_NAME,
        null,
        Constants.DB_VERSION
) {



    override fun onCreate(db: SQLiteDatabase?) {
       db!!.execSQL(Constants.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS" + Constants.TABLE_NAME)
    }

    fun addUser(name: String?, username: String?, password: String?, gender: String?) : Long{
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(Constants.U_NAME, name)
        values.put(Constants.U_USERNAME, username)
        values.put(Constants.U_PASSWORD, password)
        values.put(Constants.U_GENDER, gender)

        val id = db.insert(Constants.TABLE_NAME, null, values)
        db.close()
        return id
    }
     /*fun isLoginSuccessful(
            username: String?,
            password: String?
    ): Boolean {
        val db = this.readableDatabase
         var c: Cursor? = null
      val query : String = "SELECT * FROM " + Constants.TABLE_NAME +
         " WHERE " + Constants.U_USERNAME + " = '" + username + "' AND " +
                 Constants.U_PASSWORD + " = '" + password + "'"
         c = db.rawQuery(query, null)
         return c.moveToFirst()



        return false

    }

      */
     @SuppressLint("Recycle")
     fun isLoginSuccessful(username: String?,
                           password: String?):Boolean{

        val selectQuery = "SELECT * FROM " + Constants.TABLE_NAME +
                " WHERE " + Constants.U_USERNAME + " = '" + username + "' AND " +
                Constants.U_PASSWORD + " = '" + password + "'"
        val db = this.readableDatabase
        val cursor: Cursor?
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return false
        }

        if (cursor.moveToFirst()) {

            return true
        }
       return false
    }

}

