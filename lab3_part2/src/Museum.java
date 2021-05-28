import java.time.LocalTime;

public class Museum  extends Location implements Visitable,Payable{
    private String name;
    private LocalTime openingTime,closingTime;
    private double ticketPrice;
    public void addCost(Location location,int index)
    {
        map.put(location,index);
    }

    public Museum(String name) {
        super(name);
        this.name=name;
    }

    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
