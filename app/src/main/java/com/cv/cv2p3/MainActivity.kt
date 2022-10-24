package com.cv.cv2p3


import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.cv.cv2p3.databinding.FragmentSecondBinding
import com.google.gson.Gson
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    private lateinit var appPreferences: SharedPreferences
    private var gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                val dialogClickListener =
                    DialogInterface.OnClickListener { dialog, which ->
                        when (which) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                appPreferences =
                                    getSharedPreferences("local_shared_pref", Context.MODE_PRIVATE)
                                appPreferences.edit().clear().apply()
                                exitProcess(0)
                            }
                            DialogInterface.BUTTON_NEGATIVE -> {

                                dialog.dismiss()
                            }
                        }
                    }


                val builder: AlertDialog.Builder = AlertDialog.Builder(this)


                builder.setTitle("Logout")
                builder.setMessage("Are you sure you want to logout?")

                    .setPositiveButton("Yes", dialogClickListener)

                    .setNegativeButton("No", dialogClickListener)

                    .show()


            }
        }
        return true
    }
}