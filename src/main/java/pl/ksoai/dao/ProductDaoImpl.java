package pl.ksoai.dao;

import pl.ksoai.api.ProductDao;
import pl.ksoai.entity.Product;
import pl.ksoai.entity.parser.ProductParser;
import pl.ksoai.utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

	private static ProductDaoImpl instance = null;
	private static final String fileName = "products.data";

	public static ProductDaoImpl getInstance() {
		if (instance == null) {
			instance = new ProductDaoImpl();
		}
		return instance;
	}

	private ProductDaoImpl() {
		try {
			FileUtils.createNewFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getAllProducts() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		List<Product> productList = new ArrayList<>();

		String readLine = reader.readLine();
		while(readLine != null) {
			Product product = ProductParser.stringToProduct(readLine);
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
	public boolean removeProductByName(String productName) throws IOException {
		List<Product> productList = getAllProducts();
		boolean isProductRemoved = false;

		for (Product product : productList) {
			if (product.getProductName().equalsIgnoreCase(productName)) {
				productList.remove(product);
				isProductRemoved = true;
				break;
			}
		}
		saveProducts(productList);

		return isProductRemoved;
	}
}
