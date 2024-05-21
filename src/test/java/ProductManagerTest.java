import com.bridgelabz.content.product.Product;
import com.bridgelabz.content.product.ProductManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {

    private ProductManager manager;

    @BeforeEach
    public void setUp() {
        manager = new ProductManager();
    }

    @Test
    public void testFilterByCategory() {
        List<Product> electronics = manager.filterByCategory("Electronics");
        assertEquals(3, electronics.size());
    }

    @Test
    public void testFilterByPriceRange() {
        List<Product> priceRange = manager.filterByPriceRange(20, 50);
        assertEquals(2, priceRange.size());
    }

    @Test
    public void testMapProductNamesToUppercase() {
        List<String> uppercaseNames = manager.mapProductNamesToUppercase();
        assertTrue(uppercaseNames.contains("LAPTOP"));
    }

    @Test
    public void testApplyDiscount() {
        List<Product> discountedProducts = manager.applyDiscount(10);
        assertEquals(900, discountedProducts.get(0).getPrice(), 0.01);
    }

    @Test
    public void testSortByPriceAscending() {
        List<Product> sortedByPrice = manager.sortByPriceAscending();
        assertEquals(20, sortedByPrice.get(0).getPrice());
    }

    @Test
    public void testSortByQuantityDescending() {
        List<Product> sortedByQuantity = manager.sortByQuantityDescending();
        assertEquals(50, sortedByQuantity.get(0).getQuantity());
    }

    @Test
    public void testTotalNumberOfProducts() {
        assertEquals(6, manager.getTotalNumberOfProducts());
    }

    @Test
    public void testTotalValueOfProducts() {
        assertEquals(27700, manager.getTotalValueOfProducts(), 0.01);
    }

    @Test
    public void testLimitProducts() {
        List<Product> limitedProducts = manager.limitProducts(3);
        assertEquals(3, limitedProducts.size());
    }

    @Test
    public void testSkipProducts() {
        List<Product> skippedProducts = manager.skipProducts(2);
        assertEquals(4, skippedProducts.size());
    }

    @Test
    public void testSearchProductByName() {
        assertTrue(manager.searchProductByName("Laptop").isPresent());
    }

    @Test
    public void testSearchProductById() {
        assertTrue(manager.searchProductById(3).isPresent());
    }
}
