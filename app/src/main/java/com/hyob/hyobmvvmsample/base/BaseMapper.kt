package com.hyob.hyobmvvmsample.base

interface BaseMapper<V, E> {

    fun mapToEntity(value: V): E

}