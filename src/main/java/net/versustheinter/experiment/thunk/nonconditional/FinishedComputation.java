package net.versustheinter.experiment.thunk.nonconditional;

public class FinishedComputation<T> implements Computation<T> {
    private T value;

    public FinishedComputation(T value) {
        this.value = value;
    }

    @Override
    public Computation<T> evaluate() {
        return this;
    }

    @Override
    public T value() {
        return value;
    }
}
