import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p05_CustomLinkedList.CustomLinkedList;

public class CustomLinkedListTest {
    private CustomLinkedList<Integer> customLinkedList;

    @Before
    public void init() {
        customLinkedList = new CustomLinkedList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getShouldThrowExceptionWhenIndexIsNotValid() {
        customLinkedList.get(-1);
    }

    @Test
    public void getShouldReturnElementAtTheGivenIndex() {
        customLinkedList.add(33);
        int value = customLinkedList.get(0);
        Assert.assertEquals(33, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getShouldThrowExceptionWhenIndexIsGreater() {
        customLinkedList.add(33);
        customLinkedList.get(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setShouldThrowExceptionWhenIndexIsGreater() {
        customLinkedList.add(33);
        customLinkedList.set(2, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setShouldThrowExceptionWhenIndexIsNotValid() {
        customLinkedList.set(-1, 100);
    }

    @Test
    public void setElementAtSpecifiedPosition() {
        customLinkedList.add(2);
        customLinkedList.set(0, 1);
        Assert.assertEquals(customLinkedList.get(0).intValue(), 1);
    }

    @Test
    public void addElementAtLastPosition() {
        customLinkedList.add(33);
        customLinkedList.add(34);
        Assert.assertEquals(customLinkedList.get(1).intValue(), 34);
    }

    @Test
    public void shouldReturnAndRemoveElementAtGivenPosition() {
        customLinkedList.add(33);
        int value = customLinkedList.removeAt(0);
        Assert.assertEquals(33, value);
    }

    @Test
    public void shouldReturnTheElementOfTheRemovedElement() {
        customLinkedList.add(33);
        int index = customLinkedList.remove(33);
        Assert.assertEquals(0, index);
    }

    @Test
    public void shouldGiveNegativeResultIfElementNotFound() {
        customLinkedList.add(33);
        int index = customLinkedList.remove(100);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void shouldReturnTheIndexOfTheFirstElementWithTheGivenValue() {
        customLinkedList.add(33);
        customLinkedList.add(34);
        customLinkedList.add(33);
        int index = customLinkedList.indexOf(33);
        Assert.assertEquals(0, index);
    }

    @Test
    public void indexOfShouldGiveNegativeResultIfElementNotFound() {
        customLinkedList.add(33);
        int index = customLinkedList.indexOf(100);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void shouldGiveTrueIfContains(){
        customLinkedList.add(33);
        Assert.assertTrue(customLinkedList.contains(33));
    }

    @Test
    public void shouldGiveFalseIfDoesNotContains(){
        customLinkedList.add(33);
        Assert.assertFalse(customLinkedList.contains(100));
    }






}
