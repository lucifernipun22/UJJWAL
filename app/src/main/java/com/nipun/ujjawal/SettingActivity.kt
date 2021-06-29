package com.nipun.ujjawal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        var btn_update=  findViewById<AppCompatButton>(R.id.btn_update)
        btn_update.setOnClickListener { view ->
            deleteData()
        }
        var lyt_login_register5 = findViewById<LinearLayout>(R.id.lyt_login_register5)
        lyt_login_register5.setOnClickListener { view->
            shareMeetingInvitationCode()
        }

        var text1 =intent.getStringExtra("phoneNumber")
        txt_register.text =text1
        Log.d("nipun2",text1.toString())


    }
    private fun deleteData() {
        val name = sharedPrefNames()
        applicationContext.getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE).edit().clear()
            .apply()
        val intnet = Intent(this,LoginActivity::class.java)
        startActivity(intnet)
    }

    private fun shareMeetingInvitationCode() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Earn with every successful referral Download this app by using this link https://com.nipun.ujjwal")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, "Share Refer")
        startActivity(shareIntent)
    }
}