package com.example.kotlinspringbootdomademo.application.input

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class VoteInput {
    @NotBlank
    @Size(max = 20)
    var voter: String? = null

    @NotBlank
    @Size(max = 50)
    var candidate: String? = null
}
