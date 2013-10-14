package tdd;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 14.10.13
 * Time: 13:11
 * To change this template use File | Settings | File Templates.
 */
public class Account {

    private long balance;

    public Account() {

    }

    public Account(long b) {
        this.balance = b;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
