package net.versustheinter.experiment.thunk.conditional;

import net.versustheinter.experiment.thunk.ThunkComputer;

public class ConcreteThunk<T> extends Thunk<T> {
    public ThunkComputer<T> computer;
    
    public ConcreteThunk(ThunkComputer<T> computer) {
        this.computer = computer;
    }
    
    @Override 
    protected T compute() {
        return computer.compute();
    }
}