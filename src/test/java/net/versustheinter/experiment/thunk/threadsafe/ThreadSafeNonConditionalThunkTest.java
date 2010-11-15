package net.versustheinter.experiment.thunk.threadsafe;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import net.versustheinter.experiment.thunk.Thunkable;
import net.versustheinter.experiment.thunk.conditional.ConditionalThunkTest;
import net.versustheinter.experiment.thunk.nonconditional.NonConditionalThunk;

import org.junit.Test;

public class ThreadSafeNonConditionalThunkTest<T> extends ConditionalThunkTest {

    public ExecutorService executor = newFixedThreadPool(4);
    
    @Override
    public void initializeThunk() {
        thunk = new ThreadSafeThunk(computable);
    }
    
    @Test
    public void normalThunkComputesMultipleTimesInDifferentThreads() throws InterruptedException, ExecutionException {
        PausingComputable mcguffin = new PausingComputable();
        Thunkable thunk = new NonConditionalThunk(mcguffin);
        
        Future future1 = executor.submit(thunkRunnable(thunk));
        Future future2 = executor.submit(thunkRunnable(thunk));
        Future future3 = executor.submit(thunkRunnable(thunk));
        mcguffin.unpause();

        future1.get();
        future2.get();
        future3.get();
        assertThat(mcguffin.numberOfTimesComputed, is(3));
    }

    @Test
    public void threadSafeThunkComputesOnlyOnceInDifferentThreads() throws InterruptedException, ExecutionException {
        PausingComputable mcguffin = new PausingComputable();
        Thunkable thunk = new ThreadSafeThunk(mcguffin);
        
        Future future1 = executor.submit(thunkRunnable(thunk));
        Future future2 = executor.submit(thunkRunnable(thunk));
        Future future3 = executor.submit(thunkRunnable(thunk));
        mcguffin.unpause();

        future1.get();
        future2.get();
        future3.get();
        assertThat(mcguffin.numberOfTimesComputed, is(1));
    }
    
    public Runnable thunkRunnable(final Thunkable thunk) {
        return new Runnable() {
            @Override
            public void run() {
                thunk.get();
            }
        };
    }
}



