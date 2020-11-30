package com.vero.sibs.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vero.core.model.Product
import com.vero.sibs.adapter.ProductAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("adapterProductList")
fun bindAdapterProductList(view: RecyclerView, productItemsList: List<Product>?) {
    productItemsList?.let {
        (view.adapter as? ProductAdapter)?.updateProductsItems(productItemsList)
    }
}

@BindingAdapter("imageUrl")
fun bindLoadImageView(view: ImageView, imageUrl: String) {
    Glide.with(view.context)
        .load(imageUrl)
        .into(view)
}