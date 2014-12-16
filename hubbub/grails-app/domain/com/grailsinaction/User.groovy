package com.grailsinaction

class User {

	String userId
	String password
	String homepage
	Date dateCreated
	Profile profile //1:1 link

    static constraints = {
    	userId(size: 3..20, unique: true)
    	password(size: 6..8, validator: {passwd, user -> 
    		passwd != user.userId
		})
    	homepage(url:true, nullable: true)
    	profile(nullable: true)
    }

    static hasMany = [posts : Post, tags : Tag, following : User] //our User object is links to many Post objects

    static mapping = {
    	profile lazy:false //tell Grails to load Profile with User
    	posts sort:'dateCreated' //only sort by dateCreated when accessing the posts collection via user
    }

}
