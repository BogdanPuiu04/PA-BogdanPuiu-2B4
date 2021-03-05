import java.util.*;

public class City {
    private String name;
  private List<Location> lista=new ArrayList<>();

    public Location getLista(int n) {
        return lista.get(n);
    }

    public void addLista(int index,Location a) {
        this.lista.add(index,a);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", lista=" + lista +
                '}';
    }
}
