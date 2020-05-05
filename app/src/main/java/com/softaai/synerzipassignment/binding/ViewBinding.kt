package com.softaai.synerzipassignment.binding

import android.annotation.SuppressLint
import android.graphics.Color
import android.transition.TransitionManager
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.BindingAdapter
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import java.lang.Math.abs

@BindingAdapter("bindFab")
fun bindAppBarLayoutWithFab(appBarLayout: AppBarLayout, fab: FloatingActionButton) {
    appBarLayout.addOnOffsetChangedListener(
        AppBarLayout.OnOffsetChangedListener { appBarLayout1: AppBarLayout, verticalOffset: Int ->
            val verticalOffsetPercentage = abs(
                verticalOffset
            ).toFloat() / appBarLayout1.totalScrollRange.toFloat()
            if (verticalOffsetPercentage > 0.4f && fab.isOrWillBeShown) {
                fab.hide()
            } else if (verticalOffsetPercentage <= 0.4f && fab.isOrWillBeHidden && fab.tag != View.GONE) {
                fab.show()
            }
        })
}

@SuppressLint("NewApi")
@BindingAdapter("transformFab", "transformContainer")
fun bindTransformFab(view: View, fab: FloatingActionButton, container: CoordinatorLayout) {
    fab.setOnClickListener {
        // Begin the transition by changing properties on the start and end views or
        // removing/adding them from the hierarchy.
        fab.tag = View.GONE
        TransitionManager.beginDelayedTransition(container, getTransform(fab, view))
        fab.visibility = View.GONE
        view.visibility = View.VISIBLE
    }

    view.setOnClickListener {
        fab.tag = View.VISIBLE
        TransitionManager.beginDelayedTransition(container, getTransform(view, fab))
        fab.visibility = View.VISIBLE
        view.visibility = View.GONE
    }
}

@SuppressLint("NewApi")
internal fun getTransform(mStartView: View, mEndView: View): MaterialContainerTransform {
    return MaterialContainerTransform().apply {
        startView = mStartView
        endView = mEndView
        pathMotion = MaterialArcMotion()
        duration = 650
        scrimColor = Color.TRANSPARENT
    }
}