import java.util.ArrayList;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " — " + price + " руб.";
    }
}

class Cart {
    private ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Добавлен товар: " + p.getName());
    }

    public void removeProduct(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                System.out.println("\nУдаляем: " + name);
                products.remove(i);
                return;
            }
        }
        System.out.println("Товар '" + name + "' не найден");
    }

    public double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void printCart() {
        System.out.println("\n=== Корзина ===");
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }

        System.out.println("Итого: " + getTotal() + " руб.\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product("Iphone 17 pro", 165000.0);
        Product mouse = new Product("Ryzen g409", 5500.0);
        Product keyboard = new Product("HyperX mechanic", 7899.0);

        Cart myCart = new Cart();

        myCart.addProduct(laptop);
        myCart.addProduct(mouse);
        myCart.addProduct(keyboard);

        myCart.printCart();

        myCart.removeProduct("Ryzen g409");

        myCart.printCart();
    }
}