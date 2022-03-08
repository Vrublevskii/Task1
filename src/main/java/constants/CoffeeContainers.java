package constants;

public enum CoffeeContainers {

    BEANS_IN_BAG("Coffee beans in a bag",10, 10),
    JAR("Jar with coffee",60, 35),
    BAG("Bag with coffee",10, 10),
    ONE_PORTION_BAG("Coffee bag, one portion",3, 3);

    final String containerName;

    final int containerWeight;

    final double containerPrice;

    CoffeeContainers(String containerName, int containerWeight, double containerPrice) {
        this.containerName = containerName;
        this.containerWeight = containerWeight;
        this.containerPrice = containerPrice;
    }

    public String getContainerName() {
        return containerName;
    }

    public int getContainerWeight() {
        return containerWeight;
    }

    public double getContainerPrice() {
        return containerPrice;
    }
}
