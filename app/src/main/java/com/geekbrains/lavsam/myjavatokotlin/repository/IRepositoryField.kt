package com.geekbrains.lavsam.myjavatokotlin.repository

import com.geekbrains.lavsam.myjavatokotlin.data.CopyField

interface IRepositoryField {
    fun getFields(): CopyField
}

object RepositoryFieldSingle: IRepositoryField {
    private val copyfields = CopyField("12345", "54321")

    override fun getFields(): CopyField {
        return copyfields
    }
}