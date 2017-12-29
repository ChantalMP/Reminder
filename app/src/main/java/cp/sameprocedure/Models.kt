package cp.sameprocedure

import android.graphics.drawable.Drawable

/**
 * Created by Chantal on 25.12.2017.
 */
class Reminders(var reminders: MutableList<Reminder>)

class Reminder(var name:String, var imageUrl:Int, var time:String, var timePeriod:String, var startTime:String, var rememberMe: Boolean)
