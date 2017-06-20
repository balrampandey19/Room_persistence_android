package balram.com.room_persistence

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by redcarpet on 6/20/17.
 */
@Entity
data class Person(
        @PrimaryKey(autoGenerate = true)
        val uid: Long,
        val firstName: String = "",
        val lastName: String = ""
)


