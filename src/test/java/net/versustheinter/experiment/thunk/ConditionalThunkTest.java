package net.versustheinter.experiment.thunk;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import net.versustheinter.experiment.thunk.conditional.Thunk;
import org.junit.Before;
import org.junit.Test;

public class ConditionalThunkTest {
    
    protected Computable computer;
    protected Thunkable thunk;
    
    @Before
    public void setUp() {
        mockOutComputer();
        initializeThunk();
    }
    
    public void initializeThunk() {
        thunk = new Thunk(computer);
    }
    
    public void mockOutComputer() {
        computer = mock(Computable.class);
    }
    
    @Test
    public void computesWhenReceivingGet() {        
        thunk.get();
        
        verify(computer).compute();
    }
    
    @Test
    public void doesNotComputeWhenReceivingSubsequentGets() {        
        thunk.get();
        thunk.get();
        
        verify(computer, times(1)).compute();
    } 
}
