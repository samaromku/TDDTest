package ru.savchenko.andrey.tddtest.entities;

/**
 * Created by Andrey on 28.10.2017.
 */

public class Pair {
    private String from;
    private String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (from != null ? !from.equals(pair.from) : pair.from != null) return false;
        return to != null ? to.equals(pair.to) : pair.to == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }
}