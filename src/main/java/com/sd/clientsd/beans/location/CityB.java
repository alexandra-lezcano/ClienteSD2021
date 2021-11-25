package com.sd.clientsd.beans.location;

import com.sd.clientsd.beans.base.BaseBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CityB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private List<NeighborhoodB> neighborhoodBList;

    public CityB(Map<String, String> params){super(params);}

    @Override
    protected void create(Map<String, String> params){
        if (params.containsKey("id")&& params.get("id")!=null){
            setId(Integer.valueOf(params.get("id")));
        } else {
            setId(0);
        }
        setName(params.get("name"));
        setDescription(params.get("description"));
        this.neighborhoodBList = new ArrayList<>();
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

    public List<NeighborhoodB> getNeighborhoodBList() {
        return neighborhoodBList;
    }

    public void setNeighborhoodBList(List<NeighborhoodB> neighborhoodBList) {
        this.neighborhoodBList = neighborhoodBList;
    }
}
