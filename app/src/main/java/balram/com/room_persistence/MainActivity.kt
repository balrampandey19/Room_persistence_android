package balram.com.room_persistence

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.widget.ListView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    var list: List<Person> = ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listview = findViewById(R.id.recyclerview) as ListView
        var flotingButton = findViewById(R.id.myFAB) as FloatingActionButton
    }

    fun addPerson(firstName: String, lastName: String) {
        val person = Person(0, firstName, lastName)

        Single.fromCallable {
            MyApp.database?.personDao()?.insert(person)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }
    fun registerAllPersonListener() {

        MyApp.database?.personDao()?.getAllPeople()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { listOfPeople ->

                }
    }

    fun populateListView()
    {


    }
}
