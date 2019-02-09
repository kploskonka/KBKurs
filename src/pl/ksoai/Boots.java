package pl.ksoai;

public class Boots extends Product {
    private int size;
    private boolean isNaturalSkin;

    public int getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    public Boots(long id, String productName, double price, double weight, String color, int productCount, int size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }
}
