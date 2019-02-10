package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public int countProducts() {
        return products.size();
    }

    @Override
    public Product getProductByName(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equalsIgnoreCase(productName)) return products.get(i);
        }
        return null;
    }

    @Override
    public boolean doesProductExistByName(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean doesProductExistById(Long productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAvailableOnWarehouse(String productName) {
        if (getProductByName(productName).getProductCount() >= 1) { return true;}

        return false;
    }
}
