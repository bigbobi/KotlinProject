package com.test.bobi.kotlinproject

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Interpolator
import android.view.animation.LayoutAnimationController

/**
 * Created by bobi on 2017/1/16.
 */

object AnimationBuild {
    //Property Animation属性动画
    val alpha = "alpha"//透明
    val translationY = "translationY"//位移Y轴
    val translationX = "translationX"//位移X轴
    val rotationX = "rotationX"//X轴旋转
    val rotationY = "rotationY"//Y轴旋转
    val rotation = "rotation"//普通旋转
    val scaleX = "scaleX"//缩放X轴
    val scaleY = "scaleY"//缩放Y轴

    /**
     * 动画集合的builder
     */
    class AnimatorSetBuilder {
        val animatorSet: AnimatorSet

        init {
            animatorSet = AnimatorSet()
        }

        /**
         * 设置动画集合的Together运行方式
         * @param animators
         * *
         * @return
         */
        fun animatorSetTogether(vararg animators: ObjectAnimator): AnimatorSetBuilder {
            animatorSet.playTogether(*animators)
            return this
        }

        fun animatorSetBefore(animator1: ObjectAnimator, animator2: ObjectAnimator): AnimatorSetBuilder {
            animatorSet.play(animator1).before(animator2)
            return this
        }

        /**
         * 设置动画集合的运行时间
         * @param duration
         * *
         * @return
         */
        fun duration(duration: Long): AnimatorSetBuilder {
            animatorSet.duration = duration
            return this
        }

        /**
         * 设置动画集合的延迟时间
         * @param delay
         * *
         * @return
         */
        fun delay(delay: Long): AnimatorSetBuilder {
            animatorSet.startDelay = delay
            return this
        }

        /**
         * 设置监听
         * @param listener
         * *
         * @return
         */
        fun addListener(listener: Animator.AnimatorListener): AnimatorSetBuilder {
            animatorSet.addListener(listener)
            return this
        }

        /**
         * 设置插值器
         * @param interpolator
         * *
         * @return
         */
        fun interpolator(interpolator: Interpolator): AnimatorSetBuilder {
            animatorSet.interpolator = interpolator
            return this
        }

        /**
         * 返回动画集合
         * @return
         */
        fun build(): AnimatorSet {
            return animatorSet
        }
    }

    /**
     * 属性动画的builder
     */
    class PropertyAnimationBuilder {
        private var animator: ObjectAnimator? = null

        /**
         * 创建动画
         * @param object
         * *
         * @param animation
         * *
         * @return
         */
        fun animation(`object`: Any?, animation: String?, vararg values: Float): PropertyAnimationBuilder {
//            if (null == `object` || null == animation || animation.isEmpty()) {
//                return null
//            }
            animator = ObjectAnimator.ofFloat(`object`, animation, *values)
            return this
        }

        /**
         * 设置动画运行时间
         * @param duration
         * *
         * @return
         */
        fun duration(duration: Long): PropertyAnimationBuilder {
            animator!!.duration = duration
            return this
        }

        /**
         * 设置动画延迟时间
         * @param delay
         * *
         * @return
         */
        fun delay(delay: Long): PropertyAnimationBuilder {
            animator!!.startDelay = delay
            return this
        }

        /**
         * 设置监听
         * @param listener
         * *
         * @return
         */
        fun addListener(listener: Animator.AnimatorListener): PropertyAnimationBuilder {
            animator!!.addListener(listener)
            return this
        }

        /**
         * 设置插值器
         * @param interpolator
         * *
         * @return
         */
        fun interpolator(interpolator: Interpolator): PropertyAnimationBuilder {
            animator!!.interpolator = interpolator
            return this
        }

        /**
         * 返回动画
         * @return
         */
        fun build(): ObjectAnimator {
            return animator!!
        }

    }

    /**
     * 创建布局动画
     * @param viewGroup
     * *
     * @param animation
     * *
     * @param delay
     */
    fun createLayoutAnimation(viewGroup: ViewGroup, animation: Animation, delay: Float) {
        val layoutAnimationController = LayoutAnimationController(animation, delay)
        viewGroup.layoutAnimation = layoutAnimationController
    }
}
