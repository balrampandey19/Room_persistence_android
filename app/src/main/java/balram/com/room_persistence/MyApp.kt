package balram.com.room_persistence

import android.app.Application
import android.arch.persistence.room.Room

/**
 * Created by redcarpet on 6/20/17.
 */
class MyApp: Application(){
    companion object {
        var database: MyDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        MyApp.database =  Room.databaseBuilder(this, MyDatabase::class.java, "we-need-db").build()
    }



}