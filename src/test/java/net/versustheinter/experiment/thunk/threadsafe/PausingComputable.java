package net.versustheinter.experiment.thunk.threadsafe;

import net.versustheinter.experiment.thunk.Computable;

public class PausingComputable<T> implements Computable<T> {

    private boolean paused = true;
    public int numberOfTimesComputed = 0;

    private void pause() {
        while(paused) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void unpause() {
        paused = false;
    }
    
    @Override
    public T compute() {
        pause();
        numberOfTimesComputed++;
        return null;
    }
}
