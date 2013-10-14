package tdd;


import org.junit.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 14.10.13
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
public class TestAccount {

    @org.junit.Test
    public void getBalanceOk() {
        long balance = 1000;
        Account account = new Account(balance);
        long result = account.getBalance();

        Assert.assertEquals(balance,result);
    }
}
