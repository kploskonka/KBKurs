package pl.ksoai.dao;

import pl.ksoai.api.ProductDao;
import pl.ksoai.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

	private final String fileName;

	public ProductDaoImpl(String fileName) {
		this.fileName = fileName;

	}

	public String getFileName() {
		return fileName;
	}

	@Override
	public void saveProduct(Product product) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
		PrintWriter printWriter = new PrintWriter(fileOutputStream);

		printWriter.write(product.toString() + '\n');
		printWriter.close();
	}

	@Override
	public void saveProducts(List<Product> productList) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
		PrintWriter printWriter = new PrintWriter(fileOutputStream);

		for (Product product : productList) {
			printWriter.write(product.toString() + '\n');
		}

		printWriter.close();
	}

	@Override
	public List<Product> getAllProducts() throws IOException {
		FileReader fileReader = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(fileReader);
		List<Product> productList = new ArrayList<Product>();

		String readLine = reader.readLine();
		while(readLine != null) {
			String [] values = readLine.split("#");
			Product product = new Product(Long.parseLong(values[0]), values[1], Float.parseFloat(values[2]), Float.parseFloat(values[3]), values[4], Integer.parseInt(values[5]));
			productList.add(product);
		}

		reader.close();
		return productList;
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

		PrintWriter writer = new PrintWriter(fileName);
		writer.print("");
		writer.close();

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

		PrintWriter writer = new PrintWriter(fileName);
		writer.print("");
		writer.close();

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
