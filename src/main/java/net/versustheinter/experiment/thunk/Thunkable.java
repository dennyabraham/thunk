package net.versustheinter.experiment.thunk;

public interface Thunkable<T> {
    public abstract T get();
}