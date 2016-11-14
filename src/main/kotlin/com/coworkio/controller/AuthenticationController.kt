package com.coworkio.controller

import com.coworkio.AUTH_PREFIX
import com.coworkio.controller.exception.BadRegistrationDataException
import com.coworkio.dto.UserDto
import com.coworkio.service.security.AuthenticationService
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(AUTH_PREFIX)
open class AuthenticationController {

    private val log = LogFactory.getLog(this.javaClass)

    @Autowired
    private lateinit var authService: AuthenticationService

    @RequestMapping(value = "/confirm", method = arrayOf(RequestMethod.PUT))
    fun confirm(id: String): Boolean {
        return authService.confirm(id)
    }

    @RequestMapping(value = "/register", method = arrayOf(RequestMethod.POST))
    fun register(@Valid @RequestBody user: UserDto, bindingResult: BindingResult): Boolean {
        if(bindingResult.hasErrors()) {
            throw BadRegistrationDataException()
        }
        try {
            authService.register(user)
        } catch (ex: BadCredentialsException) {
            log.warn("Can't register user due to an error.", ex)
            throw BadRegistrationDataException()
        }

        return true
    }
}