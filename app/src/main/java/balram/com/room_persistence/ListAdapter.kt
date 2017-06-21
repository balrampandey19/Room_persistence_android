package balram.com.room_persistence

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

/**
 * Created by redcarpet on 6/20/17.
 */

class ListAdapter : ArrayAdapter<Person> {

    constructor(context: Context, textViewResourceId: Int) : super(context, textViewResourceId) {}

    constructor(context: Context, resource: Int, items: List<Person>) : super(context, resource, items) {}

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var v = convertView as View

        if (v == null) {
            val vi: LayoutInflater = LayoutInflater.from(context)
            v = vi.inflate(R.layout.itemlistrow, null)
        }

        return v

    }


}