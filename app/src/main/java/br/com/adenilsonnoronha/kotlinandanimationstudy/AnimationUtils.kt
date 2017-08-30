package br.com.adenilsonnoronha.kotlinandanimationstudy

import android.view.animation.*

/**
 * @author adenilsonnoronha<noronha.adenilson@gmail.com>
 * @since 08/29/2017
 */
class AnimationUtils {
    companion object {
        fun getTranslateAnimation(byX: Float, toX: Float, byY: Float, toY: Float, duration: Long = 1000, interpolator: Interpolator =
        LinearInterpolator(), fillAfter: Boolean = false): TranslateAnimation {
            val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF, byX, Animation.RELATIVE_TO_SELF, toX,
                    Animation.RELATIVE_TO_SELF, byY, Animation.RELATIVE_TO_SELF, toY)
            translateAnimation.configAnimation(duration, interpolator, fillAfter)
            return translateAnimation
        }

        fun getAlphaAnimation(by: Float, to: Float, duration: Long = 1000, interpolator: Interpolator = LinearInterpolator(),
                              fillAfter: Boolean = false): Animation {
            val alphaAnimation = AlphaAnimation(by, to)

            alphaAnimation.configAnimation(duration, interpolator, fillAfter)

            return alphaAnimation
        }

        fun createSetAnimation(duration: Long = 1000, interpolator: Interpolator = LinearInterpolator(), fillAfter: Boolean = false, vararg
        animations: Animation): AnimationSet {
            val animationSet = AnimationSet(true)
            for (animation in animations) {
                animationSet.addAnimation(animation)
            }
            animationSet.configAnimation(duration, interpolator, fillAfter)

            return animationSet
        }

        fun Animation.configAnimation(duration: Long = 1000, interpolator: Interpolator = LinearInterpolator(), fillAfter: Boolean = false) {
            this onDuration duration
            this onMode interpolator
            this onFillAfter fillAfter
        }


        // Training infix functions
        private infix fun Animation.onDuration(duration: Long) {
            this.duration = duration
        }

        private infix fun Animation.onMode(interpolator: Interpolator) {
            this.interpolator = interpolator
        }

        private infix fun Animation.onFillAfter(fillAfter: Boolean) {
            this.fillAfter = fillAfter
        }

    }

}