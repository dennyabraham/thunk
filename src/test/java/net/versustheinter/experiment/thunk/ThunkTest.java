package net.versustheinter.experiment.thunk;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import net.versustheinter.experiment.thunk.conditional.ConcreteThunk;

import org.junit.Before;
import org.junit.Test;

public class ThunkTest {
    
    protected Computable computer;
    protected Thunkable concreteThunk;
    
    @Before
    public void setUp() {
        mockOutComputer();
        initializeThunk();
    }
    
    public void initializeThunk() {
        concreteThunk = new ConcreteThunk(computer);
    }
    
    public void mockOutComputer() {
        computer = mock(Computable.class);
    }
    
    @Test
    public void computesWhenReceivingGet() {        
        concreteThunk.get();
        
        verify(computer).compute();
    }
    
    @Test
    public void doesNotComputeWhenReceivingSubsequentGets() {        
        concreteThunk.get();
        concreteThunk.get();
        
        verify(computer, times(1)).compute();
    } 
}
