import org.junit.Assert;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

public class DatabaseTest {
    private static final Integer[] ELEMENTS = new Integer[]{1, 2, 3};

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithLessThanOneElement() throws OperationNotSupportedException {
        Database db = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithMoreThanSixteenElement() throws OperationNotSupportedException {
        Database db = new Database(new Integer[17]);
    }

    @Test
    public void constructingDatabaseShouldIncreaseElementsCount() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Database db = new Database(ELEMENTS);

        Field field = Database.class.getDeclaredField("elementsCount");
        field.setAccessible(true);
        int fieldCurrValue = field.getInt(db);

        Assert.assertEquals(ELEMENTS.length, fieldCurrValue);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullElementShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(ELEMENTS);
        db.add(null);
    }

    @Test
    public void addElementShouldIncreaseElementCount() throws OperationNotSupportedException {
        Database db = new Database(ELEMENTS);

        for (int i = 0; i < 3; i++) {
            db.add(i);
        }

        Assert.assertEquals(ELEMENTS.length + 3, db.getElements().length);
    }

    @Test
    public void removeElementShouldDecreaseElementCount() throws OperationNotSupportedException {
        Database db = new Database(ELEMENTS);

        db.remove();

        Assert.assertEquals(db.getElements().length, ELEMENTS.length - 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowExceptionIfThereIsNoElementToRemove() throws OperationNotSupportedException {
        Database db = new Database(ELEMENTS);

        for (int i = 0; i < 4; i++) {
            db.remove();
        }
    }

    @Test
    public void getElementsShouldGiveArray() throws OperationNotSupportedException {
        Database db = new Database(ELEMENTS);
        Assert.assertArrayEquals(db.getElements(), ELEMENTS);
    }

    @Test
    public void getElementsTypeMustBeArray() throws OperationNotSupportedException {
        Database db = new Database(ELEMENTS);
        String type = db.getElements().getClass().getSimpleName();
        Assert.assertEquals(type, "Integer[]");
    }


}
