package br.com.adenilsonnoronha.kotlinandanimationstudy

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator

/**
 * @author adenilsonnoronha<noronha.adenilson@gmail.com>
 * @since 09/04/2017
 */
class ValueAnimatorUtil {

    companion object {

        fun animateProgressBar(by : Int = 0, to : Int, duration: Long = 1000, interpolator: Interpolator =
        LinearInterpolator(),  listener: ValueAnimator.AnimatorUpdateListener) : Animator{
            val animator = ValueAnimator.ofInt(by, to)
            animator.configAnimation(duration, interpolator)
            animator.addUpdateListener(listener)
            return animator
        }

        fun animateNumber(by : Int = 0, to : Int, duration: Long = 1000, listener: ValueAnimator.AnimatorUpdateListener ) : Animator{
            val animator = ValueAnimator.ofInt(by, to)
            animator.configAnimation(duration)
            animator.addUpdateListener(listener)
            return animator
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