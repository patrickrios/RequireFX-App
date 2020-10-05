package model.entity;

public interface Persistent {
    int saveThis();
    void updateThis();
    void deleteThis();
}
