package com.jtliao.secrethitlertracker;

import java.io.Serializable;

/**
 * Created by Jason on 12/28/2016.
 */

public class CardCounter implements Serializable {
    public static final String EXTRA = "com.your.package.CARD_COUNTER_EXTRA";

    private int numLiberal;
    private int numFascist;

    public CardCounter(int numLiberal, int numFascist) {
        this.numLiberal = numLiberal;
        this.numFascist = numFascist;
    }

    public void setNumLiberal(int numLiberal) {
        this.numLiberal = numLiberal;
    }

    public void setNumFascist(int numFascist) {
        this.numFascist = numFascist;
    }

    public int getNumLiberal() {
        return numLiberal;
    }

    public int getNumFascist() {
        return numFascist;
    }
}