package br.com.adenilsonnoronha.kotlinandanimationstudy

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import java.net.ContentHandler


/**
 * @author adenilsonnoronha<noronha.adenilson@gmail.com>
 * @since 08/30/2017
 */
class DimensionUtil {

    companion object {
        fun getVisibleDimensionOfScreen(context: Activity): IntArray {

            val width = context.window.decorView.width
            val height = context.window.decorView.height

            return intArrayOf(width, height)
        }

        fun convertDptoPx(context: Context, dp: Float): Float {
            val r = context.resources
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.displayMetrics)
        }

        fun getHeightNavigationAndroidBar(context: Activity): Int {
            val resources = context.resources
            val identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")
            return resources.getDimensionPixelSize(identifier)
        }
    }
}