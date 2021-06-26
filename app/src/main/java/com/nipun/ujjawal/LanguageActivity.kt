package com.nipun.ujjawal

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.util.*

class LanguageActivity : AppCompatActivity() {
    var language = "en"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        if (restorePrefData()) {
            val mainActivity = Intent(applicationContext, MainActivity::class.java)
            startActivity(mainActivity)
            finish()
        }
        val languageEnglish = findViewById<ImageView>(R.id.languageEnglish);
        languageEnglish.setOnClickListener {
            language = "hi"
            val locale = Locale(language)
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            resources.updateConfiguration(config, resources.displayMetrics)
            val intent = Intent(this@LanguageActivity, IntroductionActivity::class.java)
            startActivity(intent)


        }


        /*btnNext.setOnClickListener {
            val intent = Intent(this@LanguageActivity, com.nipun.okcredit.Views.activities.IntroductionActivity::class.java)
            startActivity(intent)

        }*/
        val languageHindi = findViewById<ImageView>(R.id.languageHindi)
        languageHindi.setOnClickListener {
            val locale = Locale(language)
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            resources.updateConfiguration(config, resources.displayMetrics)
            val intent = Intent(this@LanguageActivity, IntroductionActivity::class.java)
            startActivity(intent)


        }
    }
    private fun restorePrefData(): Boolean {
        val pref = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        return pref.getBoolean("isIntroOpnend", false)
    }

    private fun savePrefsData() {
        val pref = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("isIntroOpnend", true)
        editor.commit()
    }

}