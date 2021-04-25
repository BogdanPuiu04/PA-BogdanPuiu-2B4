public class Actor {
    int id;
    String name;


    public Actor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Actor" +
                "id=" + id +
                ", name='" + name+" '";
    }
}
