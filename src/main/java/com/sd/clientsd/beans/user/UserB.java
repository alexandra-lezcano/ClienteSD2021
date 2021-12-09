package com.sd.clientsd.beans.user;

import com.sd.clientsd.beans.base.BaseBean;
import com.sd.clientsd.beans.location.CityB;
import com.sd.clientsd.beans.location.NeighborhoodB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserB extends BaseBean  {
    private static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private String username;
    private Integer cn;
    private String address;
    private String email;
    private Integer phone;
    private CityB city;
    private String password;
    //private Integer roleId;
    private List<NeighborhoodB> neighborhoods;
   // private Set<Integer> denunciasIds;

    public UserB(Map<String, String> params) {
        super(params);
    }
    public UserB(){}

    @Override
    protected void create(Map<String, String> params) {
        if(params.containsKey("id") && params.get("id")!=null){
            setId(Integer.valueOf(params.get("id")));
        }else{
            setId(0);
        }
        setName(params.get("name"));
        setSurname(params.get("surname"));
        setUsername(params.get("username"));
        setCn(Integer.valueOf(params.get("cn")));
        setAddress(params.get("address"));
        setEmail(params.get("email"));
        setPhone(Integer.valueOf(params.get("phone")));
        setPassword(params.get("password"));

        this.neighborhoods = new ArrayList<>();
    }

    public void constructB(Map<String, String> params) { this.create(params);}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCn() {
        return cn;
    }

    public void setCn(Integer cn) {
        this.cn = cn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public CityB getCity() {
        return city;
    }

    public void setCity(CityB city) {
        this.city = city;
    }

    public List<NeighborhoodB> getNeighborhoods() {
        return neighborhoods;
    }

    public void setNeighborhoods(List<NeighborhoodB> neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
