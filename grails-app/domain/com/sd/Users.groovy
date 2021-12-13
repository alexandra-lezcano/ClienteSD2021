package com.sd

class Users {
    private String name;
    private String surname;
    private String username;
    private Integer cn;
    private String address;
    private String email;
    private Integer phone;
    private City city;
    public String password;

    static hasMany = [neighborhoods : Neighborhood]

    static constraints = {
    }
}
