package com.yhkim.kt20191208_intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_name.cancelBtn
import kotlinx.android.synthetic.main.activity_edit_name.okBtn
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)

        cancelBtn.setOnClickListener {
            finish()
        }

        okBtn.setOnClickListener {
            val inputName = nickNameEdt.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("name", inputName)

            setResult(Activity.RESULT_OK, resultIntent)

            finish()

        }
    }
}
