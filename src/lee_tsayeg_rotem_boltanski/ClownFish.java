package lee_tsayeg_rotem_boltanski;

public class ClownFish extends Fish {
    public ClownFish(int age, double length, String[] colors, String pattern) {
        super(age, length, pattern, colors);
        this.pattern = "Stripes";
        this.foodAmount = 2;
        this.colors = new String[]{"ORANGE", "BLACK", "WHITE"};
    }

}

