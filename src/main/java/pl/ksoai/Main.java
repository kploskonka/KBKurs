package pl.ksoai;

import pl.ksoai.api.ProductService;
import pl.ksoai.api.UserLoginFacade;
import pl.ksoai.entity.Boots;
import pl.ksoai.entity.Cloth;
import pl.ksoai.entity.Product;
import pl.ksoai.entity.User;
import pl.ksoai.facade.UserLoginFacadeImpl;
import pl.ksoai.service.ProductServiceImpl;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);

	private static void startMenu() {
		System.out.println("MANAGEMENT MENU");
		System.out.println("1 - Zaloguj się");
		System.out.println("2 - Zarejestruj się");
		System.out.println("0 - Wyjdź");
	}

	private static void loggedMenu() {
		System.out.println("MANAGEMENT MENU");
		System.out.println("1 - Dodaj nowy product");
		System.out.println("0 - Wyloguj się");
	}

	public static void productTypeMenu() {
		System.out.println("1 - Dodaj buty");
		System.out.println("2 - Dodaj ubrania");
		System.out.println("3 - Inne");
	}

	private static Product createOtherProduct() {
		String productName, color;
		Float price, weight;
		Integer count;

		System.out.println("ProductName: ");
		productName = scanner.next();

		System.out.println("Price: ");
		price = scanner.nextFloat();

		System.out.println("Weight: ");
		weight = scanner.nextFloat();

		System.out.println("Color: ");
		color = scanner.next();

		System.out.println("Count: ");
		count = scanner.nextInt();

		return new Product(1L, productName, price, weight, color, count);
	}

	private static Product createBootsProduct() {
		String productName, color;
		Float price, weight;
		Integer count, size;
		Boolean isNaturalSkin;

		System.out.println("ProductName: ");
		productName = scanner.next();

		System.out.println("Price: ");
		price = scanner.nextFloat();

		System.out.println("Weight: ");
		weight = scanner.nextFloat();

		System.out.println("Color: ");
		color = scanner.next();

		System.out.println("Count: ");
		count = scanner.nextInt();

		System.out.println("Size: ");
		size = scanner.nextInt();

		System.out.println("Is natural skin: ");
		isNaturalSkin = scanner.nextBoolean();

		return new Boots(1L, productName, price, weight, color, count, size, isNaturalSkin);
	}

	private static Product createClothProduct() {
		String productName, color, size, material;
		Float price, weight;
		Integer count;

		System.out.println("ProductName: ");
		productName = scanner.next();

		System.out.println("Price: ");
		price = scanner.nextFloat();

		System.out.println("Weight: ");
		weight = scanner.nextFloat();

		System.out.println("Color: ");
		color = scanner.next();

		System.out.println("Count: ");
		count = scanner.nextInt();

		System.out.println("Size: ");
		size = scanner.next();

		System.out.println("Material: ");
		material = scanner.next();

		return new Cloth(1L, productName, price, weight, color, count, size, material);
	}

	public static void main(String[] args) {
		UserLoginFacade userLoginFacade = UserLoginFacadeImpl.getInstance();
		ProductService productService = ProductServiceImpl.getInstance();
		boolean appOn = true;
		boolean loggedIn = false;
		int read;

		while (appOn) {
			startMenu();
			read = scanner.nextInt();
			switch (read) {
				case 1:
					System.out.println("Podaj login:");
					String loginLog = scanner.next();
					System.out.println("Podaj hasło:");
					String passwordLog = scanner.next();
					if (userLoginFacade.loginUser(loginLog, passwordLog)) {
						loggedIn = true;
						System.out.println("Zalogowałeś się!");
					} else {
						System.out.println("Niepoprawne dane!");
					}
					break;
				case 2:
					System.out.println("Podaj login:");
					String loginReg = scanner.next();
					System.out.println("Podaj hasło:");
					String passwordReg = scanner.next();
					User user = new User(1L, loginReg, passwordReg);
					if (userLoginFacade.registerUser(user)) {
						System.out.println("Zarejestrowałeś się!");
					} else {
						System.out.println("Coś poszło nie tak!");
					}
					break;
				case 0:
					appOn = false;
					break;
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
						if (productService.saveProduct(product)) {
							System.out.println("Produkt został utworzony");
						} else {
							System.out.println("Produkt nie został utworzony.");
						}
						break;
					case 0:
						loggedIn = false;
						break;
				}
			}
		}
	}
}
