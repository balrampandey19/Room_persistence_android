package balram.com.room_persistence

import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

/**
 * Created by redcarpet on 6/20/17.
 */
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getAllPeople(): Flowable<List<Person>>

    @Insert
    fun insert(person: Person)
}