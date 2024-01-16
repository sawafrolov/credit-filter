package com.github.sawafrolov.creditfilter.dto

data class CheckStopFactorsResultDto(
    val isRejected: Boolean,
    val rejectReason: String
)
