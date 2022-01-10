package com.company;

public class SourceToDestinationPrice implements Comparable<SourceToDestinationPrice> {
    private Source source;
    private Destination destination;
    private Integer price;

    public SourceToDestinationPrice(Source source, Destination destination, Integer price) {
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    public Source getSource() {
        return source;
    }

    public Destination getDestination() {
        return destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int compareTo(SourceToDestinationPrice o) {
        return this.price.compareTo(o.price);
    }

    @Override
    public String toString() {
        return "SourceToDestinationPrice{" +
                "source=" + source +
                ", destination=" + destination +
                ", price=" + price +
                '}';
    }
}
