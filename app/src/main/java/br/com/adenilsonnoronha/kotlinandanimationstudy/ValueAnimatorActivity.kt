package br.com.adenilsonnoronha.kotlinandanimationstudy

import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_value_animator.*

class ValueAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator)

        // GUYYSSSSSSSSSSS, remember: USE MAX OF PROGRESS A HIGHER NUMBER! YOUR ANIMATION WILL BE BETTER WITH THIS.
        //jogar isso para o value animator
        button25.setOnClickListener({
            val progressAnimator = ValueAnimator.ofInt(0, 2500)
            progressAnimator.addUpdateListener { animation ->
                val animatedValue = animation.animatedValue as Int
                progressBar.progress = animatedValue
                progressBar.invalidate()
            }
            progressAnimator.interpolator = OvershootInterpolator()
            progressAnimator.duration = 1000
            progressAnimator.start()
        })

        button75.setOnClickListener({
            val progressAnimator = ValueAnimator.ofInt(2500, 7500)
            progressAnimator.addUpdateListener { animation ->
                val animatedValue = animation.animatedValue as Int
                progressBar.progress = animatedValue
                progressBar.invalidate()
            }
            progressAnimator.interpolator = AccelerateDecelerateInterpolator()
            progressAnimator.duration = 1000
            progressAnimator.start()
        })

        button100.setOnClickListener({
            val progressAnimator = ValueAnimator.ofInt(7500, 10000)
            progressAnimator.addUpdateListener { animation ->
                val animatedValue = animation.animatedValue as Int
                progressBar.progress = animatedValue
                progressBar.invalidate()
            }
            progressAnimator.interpolator = BounceInterpolator()
            progressAnimator.duration = 1000
            progressAnimator.start()
        })
    }
}
