package br.com.adenilsonnoronha.kotlinandanimationstudy

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.View
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_object_animator.*

class ObjectAnimatorActivity : AppCompatActivity() {

    private var buttonTranslationXAnimated: Boolean = false
    private var firstAnimation : Boolean = true
    private var isAnimating : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator)

        buttonTranslateX.setOnClickListener({
            val dimensionOfScreen = DimensionUtil.getVisibleDimensionOfScreen(this)
            //Man, it's simple --'. Considering pivoX = 0 in button, we can remove its width of Screen's width. Tcharaaaaaan
            val positionX = dimensionOfScreen[0] - buttonTranslateX.measuredWidth
            if (buttonTranslationXAnimated) ObjectAnimatorUtil.getTranslateXAnimation(buttonTranslateX, 0f, duration = 800, interpolator =
            BounceInterpolator()).start()
            else ObjectAnimatorUtil.getTranslateXAnimation(view = buttonTranslateX, toX = positionX.toFloat(),
                    duration = 800, interpolator = AnticipateOvershootInterpolator())
                    .start()
            buttonTranslationXAnimated = !buttonTranslationXAnimated

        })

        buttonSmoothTransition.setOnClickListener({
            //START SCENE ALWAYS BEFORE CHANGES
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(constraintLayout)
            }
            textViewNumber.visibility = if (textViewNumber.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        })


        buttonSequentially.setOnClickListener({
            val animationButton2 = ObjectAnimatorUtil.getTranslateXAnimation(button2, (button2.width * 1).toFloat())
            val animationButton3dot2 = ObjectAnimatorUtil.getTranslateXAnimation(button3, interpolator = AccelerateDecelerateInterpolator(),
                    duration = 600, toX = (button3.width * 2).toFloat())
            ObjectAnimatorUtil.orchestrateAnimationSequentially(animationButton2, animationButton3dot2)

        })

        // GUYYSSSSSSSSSSS, remember: USE MAX OF PROGRESS A HIGHER NUMBER! YOUR ANIMATION WILL BE BETTER WITH THIS.
        button251.setOnClickListener({
            val changeProgressAnimation = ObjectAnimatorUtil.changeProgress(progressBar1, 0, 2500, 1000, BounceInterpolator())
            changeProgressAnimation.start()
        })

        button751.setOnClickListener({
            val changeProgressAnimation = ObjectAnimatorUtil.changeProgress(progressBar1, 2500, 7500, 1000, OvershootInterpolator())
            changeProgressAnimation.start()
        })

        button1001.setOnClickListener({
            val changeProgressAnimation = ObjectAnimatorUtil.changeProgress(progressBar1, 7500, 10000, 1000, DecelerateInterpolator())
            changeProgressAnimation.start()
        })

        textView.setOnClickListener({ view ->
            if(!isAnimating) {
                if (firstAnimation) {
                    //Study why height screen is wrong
                    val dimension = DimensionUtil.getVisibleDimensionOfScreen(this)
                    val width = dimension[0].toFloat()
                    val height = dimension[1].toFloat()
                    textView.setTag(R.id.KEY_ORIGINAL_POSITION_X, textView.x)
                    textView.setTag(R.id.KEY_ORIGINAL_POSITION_Y, textView.y)
                    textView.setTag(R.id.KEY_TO_POSITION_X, width - textView.width)
                    textView.setTag(R.id.KEY_TO_POSITION_Y, height - textView.height.toFloat() * 3)
                    firstAnimation = false
                }
                val translateXAndYAnimation = ObjectAnimatorUtil.getTranslateXAndYAnimation(view, view.getTag(R.id
                        .KEY_ORIGINAL_POSITION_X) as Float, view.getTag(R.id.KEY_TO_POSITION_X) as Float, view.getTag(R.id.KEY_ORIGINAL_POSITION_Y)
                        as Float, view.getTag(R.id.KEY_TO_POSITION_Y) as Float)
                val colorAnimation = ObjectAnimatorUtil.getColorAnimation(view, "textColor", ColorUtil.getRandomColor())
                val orchestrateAnimationTogether = ObjectAnimatorUtil.orchestrateAnimationTogether(object : AnimatorListenerAdapter() {
                    override fun onAnimationStart(animation: Animator?) {
                        super.onAnimationStart(animation)
                        view.setTag(R.id.KEY_ORIGINAL_POSITION_X, view.x)
                        view.setTag(R.id.KEY_ORIGINAL_POSITION_Y, view.y)
                        isAnimating = true
                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        view.setTag(R.id.KEY_TO_POSITION_X, view.getTag(R.id.KEY_ORIGINAL_POSITION_X))
                        view.setTag(R.id.KEY_TO_POSITION_Y, view.getTag(R.id.KEY_ORIGINAL_POSITION_Y))
                        view.setTag(R.id.KEY_ORIGINAL_POSITION_X, view.x)
                        view.setTag(R.id.KEY_ORIGINAL_POSITION_Y, view.y)
                        isAnimating = false
                    }
                }, translateXAndYAnimation, colorAnimation)
                orchestrateAnimationTogether.start()
            }

        })

    }

}
