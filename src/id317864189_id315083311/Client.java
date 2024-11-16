package id317864189_id315083311;

import java.util.Random;

public class Client implements Cloneable{
    private String name;
    protected int rank;

    public Client(String name) {
        this.name = name;
        Random rand = new Random();
        this.rank = rand.nextInt(11);
    }

    @Override
    public Client clone() throws CloneNotSupportedException {
        return (Client) super.clone();
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

}
