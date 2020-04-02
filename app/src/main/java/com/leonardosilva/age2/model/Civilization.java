package com.leonardosilva.age2.model;

import java.util.List;

public class Civilization {
    private String name;
    private String expansion;
    private String army_type;
    private String team_bonus;
    private List<String> civilization_bonus;

    public List<String> getCivilization_bonus() {
        return civilization_bonus;
    }

    public void setCivilization_bonus(List<String> civilization_bonus) {
        this.civilization_bonus = civilization_bonus;
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public String getArmy_type() {
        return army_type;
    }

    public void setArmy_type(String army_type) {
        this.army_type = army_type;
    }

    public String getTeam_bonus() {
        return team_bonus;
    }

    public void setTeam_bonus(String team_bonus) {
        this.team_bonus = team_bonus;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
