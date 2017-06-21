package balram.com.room_persistence

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        val firstName =findViewById(R.id.firstName) as EditText
        val lastName = findViewById(R.id.lastName) as EditText
        val addUser = findViewById(R.id.addData) as Button

        addUser.setOnClickListener {

            val fname: String = firstName.text.toString()
            val lname: String = lastName.text.toString()
             addPerson(fname,lname);
        }


    }
    fun addPerson(firstName: String, lastName: String) {
        val person = Person(0, firstName, lastName)

        Single.fromCallable {
            MyApp.database?.personDao()?.insert(person)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }
}
