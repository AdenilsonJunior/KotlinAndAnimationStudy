package br.com.adenilsonnoronha.kotlinandanimationstudy

import android.animation.*
import android.util.Log
import android.view.View
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator
import android.widget.ProgressBar

/**
 * @author adenilsonnoronha<noronha.adenilson@gmail.com>
 * @since 08/29/2017
 */
class ObjectAnimatorUtil {

    companion object {

        fun getTranslateXAnimation(view: View, toX: Float, duration: Long = 600, interpolator: Interpolator = LinearInterpolator()):
                Animator {
            val animation = ObjectAnimator.ofFloat(view, "x", toX)
            animation.configAnimation(duration, interpolator)

            return animation
        }

        fun changeProgress(view: ProgressBar, byProgress: Int, toProgress: Int, duration: Long = 1000, interpolator: Interpolator =
        LinearInterpolator()): Animator {
            val animator = ObjectAnimator.ofInt(view, "progress", byProgress, toProgress)
            animator.configAnimation(duration = duration, interpolator = interpolator)
            return animator
        }

        fun getTranslateXAndYAnimation(view: View, byX: Float, toX: Float, byY: Float, toY: Float, duration: Long = 1000, interpolator:
        Interpolator = LinearInterpolator()): Animator {
            val translateX = PropertyValuesHolder.ofFloat("x", byX, toX)
            val translateY = PropertyValuesHolder.ofFloat("y", byY, toY)
            val animator = ObjectAnimator.ofPropertyValuesHolder(view, translateX, translateY)
            animator.configAnimation(duration, interpolator)
            return animator
        }

        fun getColorAnimation(view: View, propertyValue: String, toArgb: Int, duration: Long = 1000, interpolator: Interpolator =
        LinearInterpolator()): Animator {
            val colorAnimation = ObjectAnimator.ofArgb(view, propertyValue, toArgb)
            colorAnimation.configAnimation(duration, interpolator)
            return colorAnimation
        }

        fun orchestrateAnimationTogether(listener: AnimatorListenerAdapter, vararg animations: Animator ): AnimatorSet {
            val animatorSet = AnimatorSet()
            animatorSet.playTogether(*animations)
            animatorSet.addListener(listener)
            return animatorSet
        }

        fun orchestrateAnimationSequentially(vararg animations: Animator) {
            animateOther(0, animations.size, *animations)
        }

        private fun animateOther(i: Int, size: Int, vararg animations: Animator) {
            animations[i].addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    if (i + 1 < size) {
                        animateOther(i + 1, size, *animations)
                        Log.i(i.toString(), "Finished")
                    }
                }
            })
            animations[i].start()
            Log.i(i.toString(), "Started")
        }


        private fun Animator.configAnimation(duration: Long = 1000, interpolator: Interpolator = LinearInterpolator()) {
            this onDuration duration
            this onMode interpolator
        }

        // Training infix functions
        private infix fun Animator.onDuration(duration: Long) {
            this.duration = duration
        }

        private infix fun Animator.onMode(interpolator: Interpolator) {
            this.interpolator = interpolator
        }

    }
}