package com.mysamples.mvc.model.validator

import com.mysamples.mvc.model.domain.Credential

interface Validator {

    fun validate(credential: Credential): Boolean

}
