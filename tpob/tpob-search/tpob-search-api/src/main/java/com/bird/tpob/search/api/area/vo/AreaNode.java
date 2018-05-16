package com.bird.tpob.search.api.area.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AreaNode implements Serializable {

    private Integer id;

    private String name;

    private Integer parentId;

    private List<AreaNode> sons;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<AreaNode> getSons() {
        return sons;
    }

    public void setSons(List<AreaNode> sons) {
        this.sons = sons;
    }

    public void addSon(AreaNode areaNode) {
        if(sons==null) {
            sons = new ArrayList<AreaNode>();
        }
        sons.add(areaNode);
    }

    public boolean hasChildren() {
        return sons!=null&&sons.size()>0;
    }
}
