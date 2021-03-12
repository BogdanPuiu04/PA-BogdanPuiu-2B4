public class School implements Comparable<School>{
    private int capacity;
    private String name;

    public School(int capacity, String name) {
        this.capacity = capacity;
        this.name = name;
    }

    public void lowerCapacity() {
        capacity--;
    }
    @Override
    public int compareTo(School o)
    {
        if(this.capacity>o.capacity)
            return 1;
        return -1;
    }
    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return capacity;
    }

}
