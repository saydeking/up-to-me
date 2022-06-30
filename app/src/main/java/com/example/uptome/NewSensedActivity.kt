package com.example.uptome

import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class NewSensedActivity : AppCompatActivity() {

    private lateinit var editActivityView: EditText
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_sensed)
        editActivityView = findViewById(R.id.edit_activity)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener{
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editActivityView.text)){
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }else{
                val activity = editActivityView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, activity)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
    companion object{
        const val EXTRA_REPLY = "com.example.android.wordlist.REPLY"
    }
}