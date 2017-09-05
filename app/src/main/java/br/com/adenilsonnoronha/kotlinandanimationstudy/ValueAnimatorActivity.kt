package br.com.adenilsonnoronha.kotlinandanimationstudy

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_value_animator.*

class ValueAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator)

        // GUYYSSSSSSSSSSS, remember: USE MAX OF PROGRESS A HIGHER NUMBER! YOUR ANIMATION WILL BE BETTER WITH THIS.
        button25.setOnClickListener({
            ValueAnimatorUtil.animateProgressBar(0, 2500, 1000, OvershootInterpolator(), ValueAnimator.AnimatorUpdateListener {
                val animatedValue = it.animatedValue as Int
                progressBar.progress = animatedValue
            }).start()
        })

        button75.setOnClickListener({
            ValueAnimatorUtil.animateProgressBar(2500, 7500, 1000, AccelerateDecelerateInterpolator(), ValueAnimator
                    .AnimatorUpdateListener {
                val animatedValue = it.animatedValue as Int
                progressBar.progress = animatedValue
            }).start()
        })

        button100.setOnClickListener({
            ValueAnimatorUtil.animateProgressBar(7500, 10000, 1000, AccelerateDecelerateInterpolator(), ValueAnimator
                    .AnimatorUpdateListener {
                        val animatedValue = it.animatedValue as Int
                        progressBar.progress = animatedValue
                    }).start()
        })

        button.setOnClickListener({
            ValueAnimatorUtil.animateNumber(0, 10000, 40000, ValueAnimator.AnimatorUpdateListener {
                textView2.text = (it.animatedValue as Int).toString()
            }).start()
        })
    }
}
