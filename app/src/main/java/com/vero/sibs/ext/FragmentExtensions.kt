package com.vero.sibs.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.showToolbar(isShown : Boolean) {
    if (isShown)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    else (requireActivity() as AppCompatActivity).supportActionBar?.hide()
}