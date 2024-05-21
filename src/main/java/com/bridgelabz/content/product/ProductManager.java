package com.bridgelabz.content.product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
        // Sample data for demonstration
        products.add(new Product(1, "Laptop", "Electronics", 1000, 10));
        products.add(new Product(2, "T-Shirt", "Clothing", 20, 50));
        products.add(new Product(3, "Smartphone", "Electronics", 800, 15));
        products.add(new Product(4, "Jeans", "Clothing", 40, 30));
        products.add(new Product(5, "Headphones", "Electronics", 100, 20));
        products.add(new Product(6, "Jacket", "Clothing", 60, 25));
    }

    public List<Product> filterByCategory(String category) {
        return products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Product> filterByPriceRange(double minPrice, double maxPrice) {
        return products.stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<String> mapProductNamesToUppercase() {
        return products.stream()
                .map(product -> product.getName().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<Product> applyDiscount(double discountPercent) {
        return products.stream()
                .map(product -> {
                    product.setPrice(product.getPrice() * (1 - discountPercent / 100));
                    return product;
                })
                .collect(Collectors.toList());
    }

    public List<Product> sortByPriceAscending() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }

    public List<Product> sortByQuantityDescending() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getQuantity).reversed())
                .collect(Collectors.toList());
    }

    public long getTotalNumberOfProducts() {
        return products.stream().count();
    }

    public double getTotalValueOfProducts() {
        return products.stream()
                .mapToDouble(product -> product.getPrice() * product.getQuantity())
                .sum();
    }

    public List<Product> limitProducts(int limit) {
        return products.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<Product> skipProducts(int skip) {
        return products.stream()
                .skip(skip)
                .collect(Collectors.toList());
    }

    public Optional<Product> searchProductByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public Optional<Product> searchProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }
}

