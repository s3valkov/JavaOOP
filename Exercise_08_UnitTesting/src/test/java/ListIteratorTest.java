import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class ListIteratorTest {
    private ListIterator listIterator;

    @Before
    public void createValidListIterator() throws OperationNotSupportedException {
         listIterator = new ListIterator("First", "Second");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionIfIsEmpty() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test(expected = IllegalStateException.class)
    public void printShouldThrowExceptionWhenSizeIsNull() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void printShouldPrintOnTheConsoleTheCurrentStr() throws OperationNotSupportedException {
        String firstElement = this.listIterator.print();
        assertEquals(firstElement,"First");
    }

    @Test
    public void moveShouldReturnTrue(){
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void moveShouldReturnFalseWhenHasNoMoreElements() throws OperationNotSupportedException {
        listIterator.move();
        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void hasNextShouldReturnTrue(){
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void hasNextReturnFalseWhenHasNoMoreElements() throws OperationNotSupportedException {
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void shouldPrintNextElementWhenMove(){
        listIterator.move();
        assertEquals("Second",listIterator.print());
    }


}
