package br.com.adenilsonnoronha.kotlinandanimationstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    var isOnBottom: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        configureNoFillAfter()
        configureFillAfter()
        configureAnimationSet()

    }

    private fun configureAnimationSet() {
        val alphaAnimation = AlphaAnimation(1f, 0f)
        alphaAnimation onDuration 2000

        val downAnimationTranslate = getAnimateNoFillAfter()
        downAnimationTranslate onDuration 2000
        downAnimationTranslate onMode AccelerateInterpolator()
        downAnimationTranslate onFillAfter false


        val animationSet = AnimationSet(true)
        animationSet.addAnimation(alphaAnimation)
        animationSet.addAnimation(downAnimationTranslate)

        buttonAnimationSet.setOnClickListener({
            buttonAnimationSet.startAnimation(animationSet)
        })

    }

    private fun configureFillAfter() {
        buttonFillAfter.setOnClickListener({
            val animation = getAnimationFillAfter()
            buttonFillAfter.startAnimation(animation)
            isOnBottom = !isOnBottom
        })
    }

    private fun getAnimationFillAfter(): TranslateAnimation {
        val animation = if (!isOnBottom) TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 8.0f) else TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 8.0f, Animation.RELATIVE_TO_SELF, 0f)
        animation onDuration 2000
        animation onMode BounceInterpolator()
        animation onFillAfter true
        return animation
    }

    private fun configureNoFillAfter() {
        val downAnimationTranslate = getAnimateNoFillAfter()
        downAnimationTranslate onDuration 2000
        downAnimationTranslate onMode AccelerateInterpolator()
        downAnimationTranslate onFillAfter false

        buttonNoFillAfter.setOnClickListener({
            buttonNoFillAfter.startAnimation(downAnimationTranslate)
        })
    }


    private fun getAnimateNoFillAfter() = TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 8.0f)


    // Training infix functions
    infix fun Animation.onDuration(duration: Long) {
        this.duration = duration
    }

    infix fun Animation.onMode(interpolator: Interpolator) {
        this.interpolator = interpolator
    }

    infix fun Animation.onFillAfter(fillAfter: Boolean) {
        this.fillAfter = fillAfter
    }
}
