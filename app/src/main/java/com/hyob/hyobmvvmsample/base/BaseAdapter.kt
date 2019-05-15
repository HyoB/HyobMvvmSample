package com.hyob.hyobmvvmsample.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T>(comparator: DiffUtil.ItemCallback<T>? = null): ListAdapter<T, BaseHolder<T>>(comparator!!) {

    abstract fun initComparator(): DiffUtil.ItemCallback<T>

    abstract val test: DiffUtil.ItemCallback<T>

}