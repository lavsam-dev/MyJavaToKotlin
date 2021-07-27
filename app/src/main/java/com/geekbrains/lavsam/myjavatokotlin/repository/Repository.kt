package com.geekbrains.lavsam.myjavatokotlin.repository

import com.geekbrains.lavsam.myjavatokotlin.data.Weather

interface IRepository{
    fun getWeathers(): List<Weather>
}

object RepositorySingle : IRepository {

    private val weathers: List<Weather> = listOf(
            Weather("Москва", 25),
            Weather("Санкт-Петербург", 20),
            Weather("Самара", 23),
            Weather("Новосибирск", 15)
        )

    override fun getWeathers(): List<Weather> {
        return weathers
    }
}
