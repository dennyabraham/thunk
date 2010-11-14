package net.versustheinter.experiment.thunk.conditional;

import net.versustheinter.experiment.thunk.Thunkable;

public abstract class AbstractThunk<T> implements Thunkable<T> {
    private boolean evaluated;
    private T value;

    @Override
    public T get() {
        if (!evaluated) {
            value = compute();
            evaluated = true;
        }
        return value;
    }

    abstract protected T compute();
}
