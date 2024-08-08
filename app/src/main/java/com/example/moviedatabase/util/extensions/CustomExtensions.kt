package com.example.moviedatabase.util.extensions

import com.example.moviedatabase.details.domain.entity.ProgramDetails
import com.example.moviedatabase.util.Constant.IMAGE_BASE_URL

fun ProgramDetails.updateProgramImage(): ProgramDetails =
    this.copy(posterPath = IMAGE_BASE_URL + posterPath)