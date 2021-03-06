package balram.com.room_persistence

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    var list: List<Person> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var flotingButton = findViewById(R.id.myFAB) as FloatingActionButton
        registerAllPersonListener();
        flotingButton.setOnClickListener {

        }
    }


    fun registerAllPersonListener() {

        MyApp.database?.personDao()?.getAllPeople()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { listOfPeople ->
                    var listview = findViewById(R.id.recyclerview) as ListView
                  listview.adapter = ListExampleAdapter(this,listOfPeople)
                }
    }

    private class ListExampleAdapter(context: Context, items: List<Person>) : BaseAdapter() {

        private val mInflater: LayoutInflater = LayoutInflater.from(context)
        private val item: List<Person> = items


        override fun getCount(): Int {
            return item.size
        }

        override fun getItem(position: Int): Any {
            return item[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            val view: View?
            val vh: ListRowHolder
            if (convertView == null) {
                view = this.mInflater.inflate(R.layout.itemlistrow, parent, false)
                vh = ListRowHolder(view)
                view.tag = vh
            } else {
                view = convertView
                vh = view.tag as ListRowHolder
            }
            var data: Person = item[position]
            vh.firstName.text =data.firstName
            vh.lastName.text = data.lastName

            return view
        }
    }

    private class ListRowHolder(row: View?) {
         val firstName: TextView = row?.findViewById(R.id.first_name) as TextView
        val lastName: TextView = row?.findViewById(R.id.last_name) as TextView


    }
}
