package bankAccount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {
    private BigDecimal balance;
    private final static String NAME = "MyName";
    private BankAccount account;

    @Before
    public void beforeEveryTest() {
        this.balance = new BigDecimal(22);
        this.account = new BankAccount(NAME, balance);
    }

    @Test
    public void shouldReturnTheName() {
        String actual = this.account.getName();
        Assert.assertEquals("Should return the name", NAME, actual);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWhenLessChars() {
        new BankAccount("Az", balance);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWhenMoreChars() {
        new BankAccount("Azqwertyuioplkjhgfdsazxcvbnmertyuioplk", balance);
    }


    @Test
    public void shouldReturnTheBalance() {
        BigDecimal actual = this.account.getBalance();
        Assert.assertEquals("Should return the balance", balance, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWhenBalanceIsNegative() {
        new BankAccount("Azaa", BigDecimal.valueOf(-22));
    }

    @Test
    public void depositShouldAddMoneyToTheBalance() {
        this.account.deposit(balance);//should be 2 * balance
        Assert.assertEquals(BigDecimal.valueOf(44), account.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void depositShouldThrowExceptionWhenIsNegative() {
        this.account.deposit(BigDecimal.valueOf(-22));
    }


    @Test
    public void amountShouldAddMoneyToTheBalance() {
        BigDecimal actual = this.account.withdraw(BigDecimal.valueOf(10));
        Assert.assertEquals(BigDecimal.valueOf(10), actual);
    }

    @Test
    public void amountShouldSetMoneyToTheBalance() {
        this.account.withdraw(BigDecimal.valueOf(10));
        BigDecimal actual = account.getBalance();
        Assert.assertEquals(BigDecimal.valueOf(12), actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldThrowExceptionWhenIsMoneyAreMore() {
        this.account.withdraw(BigDecimal.valueOf(30));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldThrowExceptionWhenMoneyAreLess() {
        this.account.withdraw(BigDecimal.valueOf(-30));
    }


}