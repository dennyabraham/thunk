package net.versustheinter.experiment.thunk.nonconditional;

public interface Computation<T> {
    public Computation<T> evaluate();
    public T value();
}
