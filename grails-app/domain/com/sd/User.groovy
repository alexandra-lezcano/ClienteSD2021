package com.sd

class User {
    private String name;
    private String surname;
    private String username;
    private Integer cn;
    private String address;
    private String email;
    private Integer phone;
    private City city;

    static hasMany = [neighborhoods : Neighborhood]

    static constraints = {
    }
}
