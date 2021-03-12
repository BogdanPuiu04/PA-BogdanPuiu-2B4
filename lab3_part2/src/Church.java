import java.time.LocalTime;

public class Church extends Location implements Visitable{
    private String name;
    private LocalTime openingTime,closingTime;
    public Church(String name) {
        super(name);
        this.name=name;
    }
    public void addCost(Location location,int index)
    {
        map.put(location,index);
    }

    @Override
    public String toString() {
        return "Church{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }
}
