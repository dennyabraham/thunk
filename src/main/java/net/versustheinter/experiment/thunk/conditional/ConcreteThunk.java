package net.versustheinter.experiment.thunk.conditional;

import net.versustheinter.experiment.thunk.Computable;

public class ConcreteThunk<T> extends Thunk<T> {
    public Computable<T> computable;
    
    public ConcreteThunk(Computable<T> computable) {
        this.computable = computable;
    }
    
    @Override 
    protected T compute() {
        return computable.compute();
    }
}