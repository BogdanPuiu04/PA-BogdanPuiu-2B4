import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;
        Destination that = (Destination) o;
        return demand == that.demand && Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", demand=" + demand +
                '}';
    }
}
