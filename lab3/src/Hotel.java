import java.time.LocalTime;


public class Hotel extends Location implements Payable,Visitable,Classifiable{
    private String name;
    private double rank;
    private LocalTime openingTime,closingTime;
    private double ticket;
    public void addCost(Location location,int index)
    {
        map.put(location,index);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                '}';
    }

    public Hotel(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setTicket(double ticket) {
        this.ticket = ticket;
    }

    @Override
    public double getRank() {
        return rank;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public double getTicketPrice() {
        return ticket;
    }
}
