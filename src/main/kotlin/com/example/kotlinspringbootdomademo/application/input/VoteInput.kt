package com.example.kotlinspringbootdomademo.application.input

import org.hibernate.validator.constraints.NotBlank
import javax.validation.constraints.Size

class CustomerInput {
    @NotBlank
    @Size(max = 20)
    var voter_id: Int? = null

    @NotBlank
    @Size(max = 50)
    var candidate_id: Int? = null
}
