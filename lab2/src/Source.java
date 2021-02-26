public class Source {
    String name;
    int supply;

    enum SourceType {
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
}
