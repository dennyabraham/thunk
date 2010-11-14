package net.versustheinter.experiment.thunk.nonconditional;

import net.versustheinter.experiment.thunk.Computable;
import net.versustheinter.experiment.thunk.Thunkable;

public class NonConditionalThunk<T> implements Thunkable<T> {
    private Computation<T> computation;
    
    public NonConditionalThunk(Computable<T> computable) {
        this.computation = new DelayedComputation<T>(computable);
    }

    @Override
    public T get() {
        this.computation = computation.evaluate();
        return computation.value();
    }
}
