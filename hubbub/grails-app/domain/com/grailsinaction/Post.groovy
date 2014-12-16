package com.grailsinaction

class Post {
	
	String content
	Date dateCreated

    static constraints = {
    	content(blank: false)
    }

    static belongsTo = [user : User] // when user is deleted, all their matching Post objects will be deleted too

    static mapping = {
    	sort dateCreated:"desc"
    }

    static hasMany = [tags : Tag] //many to many relationships
} 
