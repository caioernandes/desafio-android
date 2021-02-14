package com.desafio.android.commons.ext

import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.RecyclerView
import com.desafio.android.R

fun RecyclerView.animateList() {
    val animationController: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(
        context,
        R.anim.layout_animation
    )
    this.layoutAnimation = animationController
}