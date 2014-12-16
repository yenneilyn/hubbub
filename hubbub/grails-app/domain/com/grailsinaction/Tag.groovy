package com.grailsinaction

class Tag {

    String name
    User user

    static constraints = {
        name(blank: false)
    }

    static hasMany = [ posts : Post] //many to many relationship

    static belongsTo = [User, Post]
}
