package balram.com.room_persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by redcarpet on 6/20/17.
 */
@Database(entities = arrayOf(Person::class), version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}
