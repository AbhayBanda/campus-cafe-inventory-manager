import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);   // reading input: provided for you

        Product[] products = new Product[10];  // an array with room for 10 products

        int count = 0;                         // how many products are stored so far

        int choice;

        do {

            System.out.println("\n--- Campus Cafe Inventory ---");

            System.out.println("1. Add product");

            System.out.println("2. Display all products");

            System.out.println("3. Total stock value");

            System.out.println("4. Average price");

            System.out.println("5. Restock a product");

            System.out.println("6. Duplicate a product");

            System.out.println("0. Exit");

            System.out.print("Choose: ");

            choice = sc.nextInt();

            sc.nextLine();   // clears the leftover newline after nextInt()

            if (choice < 0 || choice > 6) {

                System.out.println("Invalid choice, try again.");

            }

            switch (choice) {

                case 1:

                    System.out.print("Name: ");

                    String name = sc.nextLine();

                    System.out.print("Price: ");

                    double price = sc.nextDouble();

                    System.out.print("Quantity: ");

                    int quantity = sc.nextInt();

                    sc.nextLine();

                    if (count == products.length) {
                        System.out.println("Product list is full.");
                    }
                    else if (price <= 0 || quantity < 0) {
                        System.out.println("Price must be greater than 0 and quantity cannot be negative.");
                    } else {
                        Product newProduct = new Product(name, price, quantity);
                        products[count++] = newProduct;
                    }

                    break;

                case 2:

                    if (count == 0) {
                        System.out.println("No products to display!!");
                    } else {
                        for (int i = 0; i < count; ++i) {
                            System.out.print((i + 1) + ". ");
                            products[i].display();
                        }
                    }

                    break;

                case 3:

                    if (count == 0) {
                        System.out.println("No products in the inventory");
                    } else {
                        double totalStockValue = 0;
                        for (int i = 0; i < count; i++) {
                            totalStockValue += products[i].stockValue();
                        }
                        System.out.println("Total Stock Value : " + totalStockValue);
                    }

                    break;

                case 4:

                    if (count == 0) {
                        System.out.println("No products in the inventory");
                    } else {
                        double avgPrice = 0;
                        for (int i = 0; i < count; i++) {
                            avgPrice += products[i].price;
                        }
                        avgPrice /= count;

                        System.out.println("Average Cost : " + avgPrice);
                        System.out.println("Average Cost (rounded down) : " + (int) avgPrice);
                    }

                    break;

                case 5:

                    System.out.print("Product number: ");

                    int num = sc.nextInt();

                    System.out.print("Quantity to add: ");

                    int extra = sc.nextInt();

                    sc.nextLine();

                    if (num < 1 || num > count) {
                        System.out.println("Product number should be between 1 and " + count);
                    } else if (extra <= 0) {
                        System.out.println("Quantity should be greater than 0");
                    } else {
                        products[num - 1].quantity += extra;
                    }

                    break;

                case 6:

                    System.out.print("Product number: ");

                    int n = sc.nextInt();

                    sc.nextLine();

                    if (n < 1 || n > count) {
                        System.out.println("Product number should be between 1 and " + count);
                    } else if (count == products.length) {
                        System.out.println("Product list is full.");
                    } else {
                        Product copy = new Product(products[n - 1]);
                        copy.name += " (copy)";
                        products[count++] = copy;
                    }

                    break;

                case 0:

                    System.out.println("Goodbye!");

                    break;

            }

        } while (choice != 0);

        System.out.println("Products created in total: " + Product.totalProducts);

    }

}