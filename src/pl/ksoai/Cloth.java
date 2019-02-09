package pl.ksoai;

public class Cloth extends Product {
    private String size;
    private String material;

    public String getMaterial() {
        return material;
    }

    public String getSize() {
        return size;
    }

    public Cloth(long id, String productName, double price, double weight, String color, int productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }
}
