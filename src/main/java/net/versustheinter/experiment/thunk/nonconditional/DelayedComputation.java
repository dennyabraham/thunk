package net.versustheinter.experiment.thunk.nonconditional;

import net.versustheinter.experiment.thunk.Computable;

public class DelayedComputation<T> implements Computation<T> {
    public Computable<T> computable;
    
    public DelayedComputation(Computable<T> computable) {
        this.computable = computable;
    }

    @Override
    public Computation<T> evaluate() {
        return new FinishedComputation<T>(compute());
    }

    @Override
    public T value() {
        return compute();
    }

    private T compute() {
        return computable.compute();
    }
}