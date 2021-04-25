package com.smoothstack.utopiaairlines.entities;

import java.io.Serializable;
import java.util.Objects;

public class Airplane implements Serializable {
    private static final long serialVersionUID = 759683393616486352L;

    // Data
    private final int id;
    private int capacity;

    // Relationships
    // TODO: Relationships

    // Methods


    /**
     * @param id Airplane ID
     * @param capacity Airplane capacity
     */
    public Airplane(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getID() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return id == airplane.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
