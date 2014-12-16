package com.grailsinaction

import grails.test.spock.IntegrationSpec
import com.grailsinaction.User

class UserIntegrationIntegrationSpec extends IntegrationSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "TestFirstSaveEver"() {
    	def user = new User(userId: 'joe', password: 'secret', homepage: 'https://www.grailsinaction.com')
    	assertNotNull user.save()
    	assertNotNull user.id

    	def foundUser = User.get(user.id)
    	assertEquals 'joe', foundUser.userId
    }

    void "TestEvilSave"() {
        def user = new User(userId: 'chuck norris', password: 'tiny', homepage: 'not-a-url')

        assertFalse user.validate()
        assertTrue user.hasErrors()

        def errors = user.errors

        assertEquals "size.toosmall", errors.getFieldError("password").code
        assertEquals "tiny", errors.getFieldError("password").rejectedValue

        assertEquals "url.invalid", errors.getFieldError("homepage").code
        assertEquals "not-a-url", errors.getFieldError("homepage").rejectedValue

        assertNull errors.getFieldError("userId")
    }
}
