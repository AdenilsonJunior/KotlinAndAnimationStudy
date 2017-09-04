package br.com.adenilsonnoronha.kotlinandanimationstudy

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import java.util.*

/**
 * @author adenilsonnoronha<noronha.adenilson@gmail.com>
 * @since 09/03/2017
 */

class ColorUtil {

    companion object {

        fun getRandomColor(alpha: Int = 255): Int {
            val random = Random()
            val a: Int =  alpha
            val r: Int = random.nextInt(255)
            val g: Int = random.nextInt(255)
            val b: Int = random.nextInt(255)

            return  Color.argb(a, r, g, b)


        }
    }

}