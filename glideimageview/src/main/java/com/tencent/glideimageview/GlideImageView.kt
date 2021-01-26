package com.tencent.glideimageview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

/**

 * Author：岑胜德 on 2021/1/25 14:57

 * 说明：直接将Glide封装进来。

 */
class GlideImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    companion object DiskCacheStrategy {
        const val NONE = 0;
        const val ALL = 1;
        const val DATA = 2;
        const val RESOURCE = 3;
        const val AUTOMATIC = 4;

    }

    private val errorId: Drawable?
    private val placeholder: Drawable?
    private val diskCacheStrategy: Int

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.GlideImageView)
        errorId = a.getDrawable(R.styleable.GlideImageView_errorSrc)
        placeholder = a.getDrawable(R.styleable.GlideImageView_placeholderSrc)
        diskCacheStrategy = a.getInt(R.styleable.GlideImageView_diskCacheStrategy, DiskCacheStrategy.NONE)

        a.recycle()


    }

    fun load(model: Any) {
        val builder = Glide.with(this).load(model)
        errorId?.let {
            builder.error(it)
        }
        placeholder?.let {
            builder.placeholder(it)
        }
        when (scaleType) {
            ScaleType.FIT_CENTER -> builder.fitCenter()
            ScaleType.CENTER_CROP -> builder.centerCrop()
            ScaleType.CENTER_INSIDE->builder.centerInside()
            else -> {
            }
        }
        when(diskCacheStrategy){
            NONE->builder.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE)
            ALL->builder.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
            DATA->builder.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.DATA)
            RESOURCE->builder.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.RESOURCE)
            AUTOMATIC->builder.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.AUTOMATIC)
        }

           builder .into(this)

    }

}