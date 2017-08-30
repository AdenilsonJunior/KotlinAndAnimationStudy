package br.com.adenilsonnoronha.kotlinandanimationstudy

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

/**
 * @author adenilsonnoronha<noronha.adenilson@gmail.com>
 * @since 08/29/2017
 */
class DashBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val intent = Intent(this, AnimationViewActivity::class.java)
        buttonAnimationView.setOnClickListener({
            startActivity(intent)
        })

    }
}