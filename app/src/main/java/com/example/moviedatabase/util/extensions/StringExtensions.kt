package com.example.moviedatabase.util.extensions

import com.example.moviedatabase.search.domain.entity.ProgramType

fun String.stringToEnum(): ProgramType? = enumValues<ProgramType>().find {
    it.name.equals(this, ignoreCase = true)
}