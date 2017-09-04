package br.com.adenilsonnoronha.kotlinandanimationstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_animation_view.*

class AnimationViewActivity : AppCompatActivity() {

    var isOnBottom: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_view)

        configureNoFillAfter()
        configureFillAfter()
        configureAnimationSet()

    }

    private fun configureAnimationSet() {
        val alphaAnimation = AnimationViewUtil.getAlphaAnimation(1f, 0f)
        val downAnimationTranslate = AnimationViewUtil.getTranslateAnimation(0f, 0f, 0f, 8f)
        val animationSet = AnimationViewUtil.createSetAnimation(animations = *arrayOf(alphaAnimation, downAnimationTranslate))

        buttonAnimationSet.setOnClickListener({
            buttonAnimationSet.startAnimation(animationSet)
        })

    }

    private fun configureFillAfter() {
        buttonFillAfter.setOnClickListener({
            val animation: Animation = if (isOnBottom) AnimationViewUtil.getTranslateAnimation(0f, 0f, 8f, 0f, 1500, BounceInterpolator(),
                    true)
            else AnimationViewUtil.getTranslateAnimation(0f, 0f, 0f, 8f, 1500, BounceInterpolator(), true)
            buttonFillAfter.startAnimation(animation)
            isOnBottom = !isOnBottom
        })
    }

    private fun configureNoFillAfter() {
        val downAnimationTranslate = AnimationViewUtil.getTranslateAnimation(0f, 0f, 0f, 8f)

        buttonTranslateX.setOnClickListener({
            buttonTranslateX.startAnimation(downAnimationTranslate)
        })
    }

}
