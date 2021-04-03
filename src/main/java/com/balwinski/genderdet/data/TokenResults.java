package com.balwinski.genderdet.data;

public class TokenResults {

    private int malesCount;
    private int femalesCount;

    public TokenResults(int malesCount, int femalesCount) {
        this.malesCount = malesCount;
        this.femalesCount = femalesCount;
    }

    public int getMalesCount() {
        return malesCount;
    }

    public void setMalesCount(int malesCount) {
        this.malesCount = malesCount;
    }

    public int getFemalesCount() {
        return femalesCount;
    }

    public void setFemalesCount(int femalesCount) {
        this.femalesCount = femalesCount;
    }
}
