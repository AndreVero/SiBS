package com.vero.sibs.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.vero.sibs.ext.gone

@BindingAdapter("gone")
fun bindGone(view: View, shouldBeGone: Boolean) {
    view.gone(shouldBeGone)
}
