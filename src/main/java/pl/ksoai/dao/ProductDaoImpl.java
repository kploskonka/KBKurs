package pl.ksoai.dao;

import pl.ksoai.api.ProductDao;
import pl.ksoai.entity.Product;
import pl.ksoai.entity.parser.ProductParser;
import pl.ksoai.utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

	private String fileName;
	private String productType;

	public ProductDaoImpl(String fileName, String productType) throws IOException {
		this.fileName = fileName;
		this.productType = productType;
		FileUtils.createNewFile(fileName);
	}

	@Override
	public List<Product> getAllProducts() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		List<Product> productList = new ArrayList<>();

		String readLine = reader.readLine();
		while(readLine != null) {
			Product product = ProductParser.stringToProduct(readLine, productType);
			if (product != null) {
				productList.add(product);
			}

			readLine = reader.readLine();
		}

		reader.close();

		return productList;
	}

	@Override
	public void saveProducts(List<Product> productList) throws IOException {
		FileUtils.clearFile(fileName);
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));

		for (Product product : productList) {
			printWriter.write(product.toString() + '\n');
		}

		printWriter.close();
	}

	@Override
	public void saveProduct(Product product) throws IOException {
		List<Product> products = getAllProducts();
		products.add(product);
		saveProducts(products);
	}

	@Override
	public void removeProductById(Long productId) throws IOException {
		List<Product> productList = getAllProducts();

		for (Product product : productList) {
			if (product.getId().equals(productId)) {
				productList.remove(product);
				break;
			}
		}

		saveProducts(productList);
	}

	@Override
	public void removeProductByName(String productName) throws IOException {
		List<Product> productList = getAllProducts();

		for (Product product : productList) {
			if (product.getProductName().equalsIgnoreCase(productName)) {
				productList.remove(product);
				break;
			}
		}

		saveProducts(productList);
	}

	@Override
	public Product getProductById(Long productId) throws IOException {
		List<Product> productList = getAllProducts();

		for (Product product : productList) {
			if (product.getId().equals(productId)) {
				return product;
			}
		}

		return null;
	}

	@Override
	public Product getProductByName(String productName) throws IOException {
		List<Product> productList = getAllProducts();

		for (Product product : productList) {
			if (product.getProductName().equalsIgnoreCase(productName)) {
				return product;
			}
		}

		return null;
	}
}
