package com.grailsinaction

import grails.test.spock.IntegrationSpec
import com.grailsinaction.Post

class PostIntegrationIntegrationSpec extends IntegrationSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test First Post"() {
    	def user = new User(userId: 'joe', password:'secret').save()
    	def post1 = new Post(content: 'First post')
    	user.addToPost(post1)

   		def post2 = new Post(content: 'Second Post')
   		user.addToPost(post2)

   		def post3 = new Post(content: 'Third Post')
   		user.addToPost(post3)
   		assertEquals 3, User.get(user.id).posts.size()
    }
}
