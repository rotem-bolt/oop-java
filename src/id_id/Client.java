package id_id;

import java.util.Random;

public class Client {
    private String name;
    protected int rank;
    //TO DO: must be a random num between 0-10

    public Client(String name) {
        this.name = name;
        Random rand = new Random();
        this.rank = rand.nextInt(11);
    }

    public Client cloneClient() {
        return new Client(this.name);
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

}
