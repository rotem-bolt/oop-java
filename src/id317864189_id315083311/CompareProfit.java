package id317864189_id315083311;

import java.util.Comparator;

public class CompareProfit implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return  (int) ((o2.getProfit() - o1.getProfit()) * 1000);
    }
}
