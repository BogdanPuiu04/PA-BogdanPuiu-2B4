public class Destination {
    String name;
    int demand;

    public Destination(String name, int demand) {
        this.name = name;
        this.demand = demand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public String getName() {
        return name;
    }

    public int getDemand() {
        return demand;
    }

    public Destination() {
    }
}
