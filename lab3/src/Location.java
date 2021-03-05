import java.util.HashMap;
import java.util.Map;

public abstract class Location {
    private String name;
    protected final Map<Location,Integer> map=new HashMap<>();

    public Map<Location, Integer> getMap() {
        return map;
    }
}
