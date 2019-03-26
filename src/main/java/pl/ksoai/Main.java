package pl.ksoai;

import pl.ksoai.api.ProductFacade;
import pl.ksoai.api.UserLoginFacade;
import pl.ksoai.entity.Boots;
import pl.ksoai.entity.Cloth;
import pl.ksoai.entity.Product;
import pl.ksoai.entity.User;
import pl.ksoai.entity.enums.Color;
import pl.ksoai.entity.enums.Material;
import pl.ksoai.entity.enums.SkinType;
import pl.ksoai.entity.parser.ColorParser;
import pl.ksoai.entity.parser.MaterialParser;
import pl.ksoai.entity.parser.SkinParser;
import pl.ksoai.facade.ProductFacadeImpl;
import pl.ksoai.facade.UserLoginFacadeImpl;
import pl.ksoai.service.UserServiceImpl;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	private static void startMenu() {
		System.out.println("MANAGEMENT MENU");
		System.out.println("1 - Log in");
		System.out.println("2 - Sign up");
		System.out.println("0 - Exit");
	}

	private static void loggedMenu() {
		System.out.println("MANAGEMENT MENU");
		System.out.println("1 - Add a new product");
		System.out.println("2 - Remove a product");
		System.out.println("3 - Show available products");
		System.out.println("0 - Log out");
	}

	private static void productTypeMenu() {
		System.out.println("1 - Add boots");
		System.out.println("2 - Add cloth");
		System.out.println("3 - Other");
	}

	private static Product createOtherProduct() {
		String productName;
		Color color;
		Float price, weight;
		Integer count;
		scanner.useLocale(Locale.US);

		System.out.println("Product name: ");
		productName = scanner.next();

		System.out.println("Price: ");
		price = scanner.nextFloat();

		System.out.println("Weight: ");
		weight = scanner.nextFloat();

		System.out.println("Choose one of the colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW: ");
		color = ColorParser.parseStringToColor(scanner.next());

		System.out.println("Count: ");
		count = scanner.nextInt();

		return new Product(ProductFacadeImpl.getInstance().countProducts() + 1L, productName, price, weight, color, count);
	}

	private static Product createBootsProduct() {
		String productName;
		Color color;
		Float price, weight;
		Integer count, size;
		SkinType skinType;

		scanner.useLocale(Locale.US);

		System.out.println("Boots name: ");
		productName = scanner.next();

		System.out.println("Price: ");
		price = scanner.nextFloat();

		System.out.println("Weight: ");
		weight = scanner.nextFloat();

		System.out.println("Choose one of the colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW: ");
		color = ColorParser.parseStringToColor(scanner.next());

		System.out.println("Count: ");
		count = scanner.nextInt();

		System.out.println("Size: ");
		size = scanner.nextInt();

		System.out.println("Choose one of the skin types: NATURAL, ARTIFICIAL: ");
		skinType = SkinParser.parseStringToSkin(scanner.next());

		return new Boots(ProductFacadeImpl.getInstance().countProducts() + 1L, productName, price, weight, color, count, size, skinType);
	}

	private static Product createClothProduct() {
		String productName, size;
		Float price, weight;
		Integer count;
		Color color;
		Material material;

		scanner.useLocale(Locale.US);

		System.out.println("Cloth name: ");
		productName = scanner.next();

		System.out.println("Price: ");
		price = scanner.nextFloat();

		System.out.println("Weight: ");
		weight = scanner.nextFloat();

		System.out.println("Choose one of the colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW: ");
		color = ColorParser.parseStringToColor(scanner.next());

		System.out.println("Count: ");
		count = scanner.nextInt();

		System.out.println("Size: ");
		size = scanner.next();

		System.out.println("Choose one of the materials: LEATHER, FUR, COTTON, WOOL, POLYESTERS");
		material = MaterialParser.parseStringToMaterial(scanner.next());

		return new Cloth(ProductFacadeImpl.getInstance().countProducts() + 1L, productName, price, weight, color, count, size, material);
	}

	public static void main(String[] args) {
		UserLoginFacade userLoginFacade = UserLoginFacadeImpl.getInstance();
		ProductFacade productFacade = ProductFacadeImpl.getInstance();
		boolean appOn = true;
		boolean loggedIn = false;
		int read;

		while (appOn) {
			startMenu();
			try {
				read = scanner.nextInt();
				switch (read) {
					case 1:
						System.out.println("Enter login:");
						String loginLog = scanner.next();
						System.out.println("Enter password:");
						String passwordLog = scanner.next();
						if (userLoginFacade.loginUser(loginLog, passwordLog)) {
							loggedIn = true;
							System.out.println("Successfully logged in!");
						} else {
							System.out.println("Incorrect login or password!");
						}
						break;
					case 2:
						System.out.println("Enter login:");
						String loginReg = scanner.next();
						System.out.println("Enter password:");
						String passwordReg = scanner.next();
						User user = new User(UserServiceImpl.getInstance().getAllUsers().size() + 1, loginReg, passwordReg);
						System.out.println(userLoginFacade.registerUser(user));
						break;
					case 0:
						appOn = false;
						break;
					default:
						startMenu();
				}

				while (loggedIn) {
					loggedMenu();

					read = scanner.nextInt();
					switch (read) {
						case 1:
							productTypeMenu();
							read = scanner.nextInt();
							Product product = null;

							switch (read) {
								case 1:
									product = createBootsProduct();
									break;
								case 2:
									product = createClothProduct();
									break;
								case 3:
									product = createOtherProduct();
									break;
							}

							System.out.println(productFacade.createProduct(product));
							break;
						case 2:
							System.out.println("Available products: " + productFacade.getAllProducts());
							System.out.println("Enter product's name: ");
							String productName = scanner.next();
							System.out.println(productFacade.removeProduct(productName));
							break;
						case 3:
							System.out.println(productFacade.getAllProducts());
							break;
						case 0:
							loggedIn = false;
							break;
						default:
							loggedMenu();
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Shutting down the program.");
				appOn = false;
				System.exit(0);
			}
		}
	}
}
