import java.time.LocalTime;

public class Restaurant extends Location implements Visitable,Classifiable{
    private String name;
    private LocalTime openingTime,closingTime;
    private double rank;

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                '}';
    }

    public Restaurant(String name1) {

        super(name1);
        this.name = name1;
    }
    public void addCost(Location location,int index)
    {
        map.put(location,index);
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    @Override
    public double getRank() {
        return rank;
    }
}
