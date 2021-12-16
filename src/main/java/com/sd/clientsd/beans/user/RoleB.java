package com.sd.clientsd.beans.user;

import com.sd.clientsd.beans.base.BaseBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoleB extends BaseBean {
    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
    private List<UserB> users;
    public RoleB(Map<String, String> params){
    super(params);
}

    @Override
    protected void create(Map<String, String> params) {
        if(params.containsKey("id") && params.get("id")!=null){
            setId(Integer.valueOf(params.get("id")));
        }else{
            setId(0);
        }

        setName(params.get("name"));
        setDescription(params.get("description"));
        this.users=new ArrayList<>();


    }


    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserB> getUsers() {
        return users;
    }

    public void setUsers(List<UserB> users) {
        this.users = users;
    }
}
