package com.example.note_app;

import java.util.Objects;

public class Note {
    private String module ;
    private int id = 0;
    private double note ;


    public Note(String module, double note) {
        this.module = module;
        this.note = note;
        this.id +=1;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String toString() {
        return this.module +"       "+ this.note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return getModule().equals(note.getModule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModule());
    }
}
