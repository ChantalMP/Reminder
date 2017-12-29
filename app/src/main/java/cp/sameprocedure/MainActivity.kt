package cp.sameprocedure

import android.app.Dialog
import android.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.new_item_dialog.*
import kotlinx.android.synthetic.main.new_item_dialog.view.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view_reminders.layoutManager = LinearLayoutManager(this)

        var adapter = MainAdapter(Reminders(mutableListOf()))
        recycler_view_reminders.adapter = adapter

        fab!!.setOnClickListener {

            var dialog: Dialog = Dialog(this)
            dialog.setContentView(R.layout.new_item_dialog);
            //var dialog: Dialog = builder.create()
            dialog.spinner_period.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.timeperiods))

            dialog.saveBtn.setOnClickListener{
                checkFields()
                var eventname: String = dialog.editText_new_eventname.text.toString()
                var time: String = dialog.editText_count.text.toString()
                var period: String = dialog.spinner_period.selectedItem.toString()
                var firstTime: String = dialog.editText_firstDate.text.toString()
                var remember: Boolean = dialog.remember_checkbox.isChecked
                adapter.remItems.reminders.add(Reminder(eventname,
                        R.drawable.ic_add_black_24dp,
                        time,
                        period,
                        firstTime,
                        remember))
                adapter.notifyDataSetChanged()

                Log.i("test", eventname +"\n"+time+"\n"+period+"\n"+firstTime+"\n"+remember)

                dialog.dismiss()}

            dialog.show();
        }



    }

    private fun checkFields() {

    }
}
