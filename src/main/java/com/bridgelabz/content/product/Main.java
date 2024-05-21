package com.bridgelabz.content.product;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        System.out.println("Filter by category 'Electronics':");
        manager.filterByCategory("Electronics").forEach(System.out::println);

        System.out.println("\nFilter by price range $20 to $50:");
        manager.filterByPriceRange(20, 50).forEach(System.out::println);

        System.out.println("\nMap product names to uppercase:");
        manager.mapProductNamesToUppercase().forEach(System.out::println);

        System.out.println("\nApply 10% discount:");
        manager.applyDiscount(10).forEach(System.out::println);

        System.out.println("\nSort by price ascending:");
        manager.sortByPriceAscending().forEach(System.out::println);

        System.out.println("\nSort by quantity descending:");
        manager.sortByQuantityDescending().forEach(System.out::println);

        System.out.println("\nTotal number of products:");
        System.out.println(manager.getTotalNumberOfProducts());

        System.out.println("\nTotal value of products:");
        System.out.println(manager.getTotalValueOfProducts());

        System.out.println("\nLimit to top 3 products by price:");
        manager.limitProducts(3).forEach(System.out::println);

        System.out.println("\nSkip the first 2 products:");
        manager.skipProducts(2).forEach(System.out::println);

        System.out.println("\nSearch product by name 'Laptop':");
        manager.searchProductByName("Laptop").ifPresent(System.out::println);

        System.out.println("\nSearch product by id 3:");
        manager.searchProductById(3).ifPresent(System.out::println);
    }
}

