public class Price implements Comparable<Price>{

    Source source;
    Destination destination;
    Integer price;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Price(Source source, Destination destination, int price) {
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    @Override
    public int compareTo(Price o) {
        return this.price.compareTo(o.price);
    }

    @Override
    public String toString() {
        return "Price{" +
                "source=" + source +
                ", destination=" + destination +
                ", price=" + price +
                '}';
    }
}

