package com.jtliao.secrethitlertracker;

import java.io.Serializable;

/**
 * Created by Jason on 12/29/2016.
 */

public class PolicyInfo implements Serializable{
    public static final String EXTRA = "com.jtliao.secrethitlertracker.POLICY_INFO_EXTRA";
    private String party;
    private String president;
    private String chancellor;
    private String notes;

    public PolicyInfo(String party, String president, String chancellor, String notes) {
        this.party = party;
        this.president = president;
        this.chancellor = chancellor;
        this.notes = notes;
    }

    public String getParty() {
        return party;
    }

    public String getPresident() {
        return president;
    }

    public String getChancellor() {
        return chancellor;
    }

    public String getNotes() {
        return notes;
    }
}
