package net.versustheinter.experiment.thunk.conditional;

import net.versustheinter.experiment.thunk.Computable;

public class Thunk<T> extends AbstractThunk<T> {
    public Computable<T> computable;
    
    public Thunk(Computable<T> computable) {
        this.computable = computable;
    }
    
    @Override 
    protected T compute() {
        return computable.compute();
    }
}