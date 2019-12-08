package com.yhkim.kt20191208_intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    1000이라는 숫자만 보면 어떤 의미로 쓰는 값인지 알기 어렵다.
//    상수로 이름을 지어서 읽기 편하게 가공.
    val REQ_CODE_FOR_INPUT_NAME = 1000
    val REQ_CODE_FOR_NiCKI_NAME = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputNameBtn.setOnClickListener {
            val intent = Intent(this, EditNameActivity::class.java)
//            startActivity(intent) //단순히 화면 이동을 위한 호출

//            결과를 받아오기 위한 요청(request) 을 하면서 화면 이동.
//            어떤 요청인지 구별해주는 숫자값을 적어 줘야 함.(1000)
//            startActivityForResult(intent, 1000)
            startActivityForResult(intent, REQ_CODE_FOR_INPUT_NAME)
        }

        nickNameBtn.setOnClickListener {
            val intent = Intent(this, EditNickNameActivity::class.java)
            startActivityForResult(intent, REQ_CODE_FOR_NiCKI_NAME)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        어떤 요청에 대한 결과를 가져온건지 확인
        if(requestCode == REQ_CODE_FOR_INPUT_NAME) {

//            확인버튼을 누른게 맞는지 확인
            if(resultCode == Activity.RESULT_OK) {
//                결과를 담아둔 Intent가 실제 할때만 실행됨.
                if(data != null) {
                    val inputName = data.getStringExtra("name")

                    nameTxt.text = inputName
                }
            }

        }

        else if(requestCode == REQ_CODE_FOR_NiCKI_NAME) {
            if(resultCode == Activity.RESULT_OK) {
                if(data != null) {

                    nickNameTxt.text = data.getStringExtra("name")
                }
            }
        }
    }
}
