package pl.ksoai.service;

import pl.ksoai.entity.Boots;
import pl.ksoai.entity.Cloth;
import pl.ksoai.entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProductsPositive() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1L, "Shoe", 10f, 1.2f, "brown", 1));
        productList.add(new Product(2L, "Shirt", 15f, 0.5f, "blue", 5));
        productList.add(new Product(3L, "Skirt", 20f, 0.7f, "black", 2));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        List<Product> productListFromTestClass = productService.getAllProducts();

        Assert.assertEquals(productList, productListFromTestClass);
    }

    @Test
    public void testGetAllProductsNegative() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Cloth(1L, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        productList.add(new Boots(2L, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(productList));
        productList.add(new Cloth(3L, "Spodnie", 44.f, 0.f, "White", 3, "S", "COTTON"));
        List<Product> listFromTestClass = productService.getAllProducts();

        Assert.assertNotEquals(productList, listFromTestClass);
    }

    @Test
    public void testCountProductsWithProducts() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Cloth(1L, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        productList.add(new Boots(2L, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        final int result = productService.countProducts();

        Assert.assertEquals(2, result);
    }

    @Test
    public void testCountProductsWithNoProducts() {
        List<Product> productList = new ArrayList<Product>();

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        final int result = productService.countProducts();

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByNameWhenExist() {
        List<Product> productList = new ArrayList<Product>();
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON");
        productList.add(cloth);
        productList.add(new Boots(2L, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        final Product result = productService.getProductByName("T-SHIRT");

        Assert.assertEquals(cloth, result);

    }

    @Test
    public void testGetProductByNameWhenNoExist() {
        List<Product> productList = new ArrayList<Product>();
        Product cloth = new Cloth(1L, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON");
        productList.add(cloth);
        productList.add(new Boots(2L, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        final Product result = productService.getProductByName("RANDOM-PRODUCT");

        Assert.assertNull(result);

    }

    @Test
    public void testDoesProductExistByNameWhenExist() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(2L, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        final boolean result = productService.doesProductExist("Boots");

        Assert.assertTrue(result);
    }

    @Test
    public void testDoesProductExistByNameWhenNoExist() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(2L, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        final boolean result = productService.doesProductExist("RANDOM-PRODUCT");

        Assert.assertFalse(result);
    }

    @Test
    public void testDoesProductExistByIDWhenExist() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(2L, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        final boolean result = productService.doesProductExist(2L);

        Assert.assertTrue(result);
    }

    @Test
    public void testDoesProductExistByIDWhenNoExist() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(2L, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        final boolean result = productService.doesProductExist(15L);

        Assert.assertFalse(result);
    }

    @Test
    public void isAvailableOnWarehouseWhenIs() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(2L, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        final boolean result = productService.isAvailableOnWarehouse("Boots");

        Assert.assertTrue(result);
    }

    @Test
    public void isAvailableOnWarehouseWhenIsNot() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(2L, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        final boolean result = productService.isAvailableOnWarehouse("RANDOM-PRODUCT");

        Assert.assertFalse(result);
    }

}
