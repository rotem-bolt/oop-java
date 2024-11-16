package id317864189_id315083311;

import java.util.Comparator;

public class CompareAccountNumber implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return (o1.getAccountNumber() - o2.getAccountNumber());
    }
}
