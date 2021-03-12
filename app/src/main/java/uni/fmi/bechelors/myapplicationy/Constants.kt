package uni.fmi.bechelors.myapplicationy

object Constants {

    const val DB_NAME = "GET_FIT_DB"
    const val DB_VERSION = 1

    const val TABLE_NAME = "USERS_TABLE"

    const val U_ID = "ID"
    const val U_NAME = "NAME"
    const val U_USERNAME = "USERNAME"
    const val U_PASSWORD = "PASSWORD"
    const val U_GENDER = "GENDER"

    const val CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + " (" + U_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + U_NAME + " TEXT, "
            + U_USERNAME + " TEXT, "
            + U_PASSWORD + " TEXT, "
            + U_GENDER + " TEXT"
            + ");")

}