package net.versustheinter.experiment.thunk.threadsafe;

import net.versustheinter.experiment.thunk.Computable;
import net.versustheinter.experiment.thunk.Thunkable;
import net.versustheinter.experiment.thunk.nonconditional.Computation;
import net.versustheinter.experiment.thunk.nonconditional.DelayedComputation;

public class ThreadSafeThunk<T> implements Thunkable<T> {
    private Computation<T> computation;
    
    public ThreadSafeThunk(Computable<T> computable) {
        this.computation = new DelayedComputation<T>(computable);
    }

    //I'm told this is expensive
    @Override
    public synchronized T get() {
        this.computation = computation.evaluate();
        return computation.value();
    }
}
