import org.junit.Assert;
import org.junit.Test;
import p04_BubbleSortTest.Bubble;

public class BubbleTest {
    @Test
    public void bubbleShouldReturnTheSameArray(){
        int[] actual = {1,2,3};
        int[] expected = {1,2,3};
        Bubble.sort(actual);
        Assert.assertArrayEquals(actual,expected);
    }

    @Test
    public void shouldReturnSortedArray(){
        int[] actual = {3,2,1};
        int[] expected = {1,2,3};
        Bubble.sort(actual);
        Assert.assertArrayEquals(actual,expected);
    }

    @Test
    public void shouldReturnSortedArrayWithRepeatingElements(){
        int[] actual = {3,2,1,3,3,2,2,};
        int[] expected = {1,2,2,2,3,3,3};
        Bubble.sort(actual);
        Assert.assertArrayEquals(actual,expected);
    }

    public void shouldReturnSortedArrayWithNegativeNumbers(){
        int[] actual = {-3,-26,-7};
        int[] expected = {-26,-7,-3};
        Bubble.sort(actual);
        Assert.assertArrayEquals(actual,expected);
    }

    public void shouldReturnSortedArrayWithNegativeAndPositiveNumbers(){
        int[] actual = {-3,-26,-7,25,321};
        int[] expected = {-26,-7,-3,25,321};
        Bubble.sort(actual);
        Assert.assertArrayEquals(actual,expected);
    }

    public void shouldReturnTheSameArray(){
        int[] actual = {0,0,0};
        int[] expected = {0,0,0};
        Bubble.sort(actual);
        Assert.assertArrayEquals(actual,expected);
    }
}
