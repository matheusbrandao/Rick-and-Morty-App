package com.matheusbrandao.rickandmorty.ui.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("characterImage")
    fun loadCharacterImage(view: AppCompatImageView, userImage: String?) {
        userImage?.let {
            val options = RequestOptions()
                .centerCrop()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)

            Glide.with(view.context)
                .load(userImage)
                .apply(options)
                .into(view)
        }
    }

    @JvmStatic
    @BindingAdapter("characterDetailImage")
    fun loadCharacterDetailImage(view: AppCompatImageView, userImage: String?) {
        userImage?.let {
            val options = RequestOptions()
                .centerCrop()
                .circleCrop()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)

            Glide.with(view.context)
                .load(userImage)
                .apply(options)
                .into(view)
        }
    }
}