import java.util.Objects;

public class Source {
    String name;
    int supply;

  public enum SourceType {
        WAREHOUSE, FACTORY;
    }

    SourceType type;

    public Source(String name, int supply, int type) {
        this.name = name;
        this.supply = supply;
        if (type == 1) {
            this.type = SourceType.FACTORY;
        }
        if (type == 0) {
            this.type = SourceType.WAREHOUSE;
        }
    }

    public Source() {
    }

    public int getSupply() {
        return this.supply;
    }

    public String getName() {
        return this.name;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSupply(int suppply) {
        this.supply = suppply;
    }


    @Override
    public String toString() {
        return name + " " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return supply == source.supply && Objects.equals(name, source.name) && type == source.type;
    }


}
