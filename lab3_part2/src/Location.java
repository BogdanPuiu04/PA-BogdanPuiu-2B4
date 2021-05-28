import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Visitable  {
    private String name;
    protected final Map<Location,Integer> map=new HashMap<>();

    public Location(String name) {
        this.name = name;
    }

    public Map<Location, Integer> getMap() {
        return map;
    }




    public String getName() {
        return name;
    }
}
