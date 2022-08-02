package com.example.mazidrestapi.model

import javax.validation.constraints.NotBlank

data class Message(
    val id: Long,
    @NotBlank val time: String,
    @NotBlank val message: String,
)
