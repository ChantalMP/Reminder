package cp.sameprocedure

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

/**
 * Created by Chantal on 25.12.2017.
 */
class MainAdapter(var remItems: Reminders) :RecyclerView.Adapter<CustomViewHolder>() {

    //val VideoTitles = listOf("first", "second", "3rd", "4")

    override fun getItemCount(): Int {
        return remItems.reminders.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.reminder_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {

        val reminder = remItems.reminders.get(position)
        holder?.view?.findViewById<TextView>(R.id.textView_reminder_title)?.text = reminder.name
        holder?.view?.findViewById<TextView>(R.id.textView_time)?.text = reminder.time + " " + reminder.timePeriod

        val imageView = holder?.view?.findViewById<CircleImageView>(R.id.image)
        Picasso.with(holder?.view?.context).load(reminder.imageUrl).into(imageView)

        holder?.view?.setOnLongClickListener {
            delete(reminder, remItems, this)
        }


    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view)

fun delete(item: Reminder, remItems: Reminders, adapter: MainAdapter) : Boolean{
    remItems.reminders.remove(item)
    adapter.notifyDataSetChanged()
    return true
}