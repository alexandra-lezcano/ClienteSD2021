package com.sd.clientsd.beans.location;

import com.sd.clientsd.beans.base.BaseBean;

import java.util.Map;

public class NeighborhoodB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String description;
    private String name;
    private CityB city_id;

    public NeighborhoodB(Map<String, String> params){super(params);}

    @Override
    protected void create(Map<String, String> params) {
            if(params.containsKey("id") && params.get("id") != null){
                setId(Integer.valueOf(params.get("id")));
            } else {
                setId(0);
            }
            setDescription(params.get("description"));
            setName(params.get("name"));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityB getCity_id() {
        return city_id;
    }

    public void setCity_id(CityB city_id) {
        this.city_id = city_id;
    }
}
