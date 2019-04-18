package com.lastminute.flightsearch.service.rule;

abstract public class AbstractPeople {
    protected int peopleCount;

    public AbstractPeople(int peopleCount) {
        setPeopleCount(peopleCount);
    }

    /**
     * @return the peopleCount
     */
    public int getPeopleCount() {
        return peopleCount;
    }

    /**
     * @param peopleCount the peopleCount to set
     */
    public void setPeopleCount(int peopleCount) {
        if (peopleCount < 0) {
            peopleCount = 0;
        }
        this.peopleCount = peopleCount;
    }
}