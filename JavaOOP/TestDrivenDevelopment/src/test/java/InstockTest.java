import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private static final String LABEL = "test_label";
    private static final Double PRICE = 9.99;
    private static final int QUANTITY = 1;

    private ProductStock stock;
    private Product defaultProduct;

    @Before
    public void setUp() {
        this.stock = new Instock();
        this.defaultProduct = new Product(LABEL, PRICE, QUANTITY);
    }

    @Test
    public void testAddShouldAddProductInTheStock() {
        stock.add(defaultProduct);
        assertTrue(stock.contains(defaultProduct));
    }

    @Test
    public void testAddShouldNotAddTheSameProductSecondTime() {
        stock.add(defaultProduct);
        stock.add(defaultProduct);

        assertEquals(1, stock.getCount());
    }

    @Test
    public void testContainsReturnsFalseIfNoSuchProductInStockAndTrueAfterAdded() {
        assertFalse(stock.contains(defaultProduct));
        stock.add(defaultProduct);
        assertTrue(stock.contains(defaultProduct));
    }

    @Test
    public void testCountShouldReturnCorrectProductCount() {
        assertEquals(0, stock.getCount());
        stock.add(defaultProduct);
        assertEquals(1, stock.getCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexThrowWhenNoSuchIndex() {
        stubProducts();
        stock.find(stock.getCount() + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexThrowWhenIndexIsNegative() {
        stubProducts();
        stock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexThrowWhenStockIsEmpty() {
        stock.find(0);
    }

    @Test
    public void testFindByIndexReturnCorrectProductWhenOnlyOnePresent() {
        stock.add(defaultProduct);
        Product product = stock.find(0);
        assertNotNull(product);
        assertEquals(product.label, defaultProduct.label);
    }

    @Test
    public void testFindByIndexReturnCorrectProductWhenTheProductIsBetweenOtherProducts() {
        stubProducts();
        Product product = stock.find(4);
        assertNotNull(product);
        assertEquals("test_label_5", product.getLabel());
    }

    @Test
    public void testFindByIndexReturnCorrectProductWhenTheProductIsTheLastOne() {
        stubProducts();
        Product product = stock.find(9);
        assertNotNull(product);
        assertEquals("test_label_10", product.getLabel());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityThrowWhenTheGivenProductIsAbsent() {
        stubProducts();
        stock.changeQuantity(LABEL, 3);
    }

    @Test
    public void testChangeQuantityShouldUpdateTheCorrectProductWithCorrectAmount() {
        stock.add(defaultProduct);
        stock.changeQuantity(LABEL, 2);
        assertEquals(2, defaultProduct.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelThrowWhenNoSuchProductInStock() {
        stubProducts();
        stock.findByLabel(LABEL);
    }

    @Test
    public void testFindByLabelReturnCorrectProduct() {
        stock.add(defaultProduct);
        Product byLabel = stock.findByLabel(LABEL);
        assertNotNull(byLabel);
        assertEquals(defaultProduct.label, byLabel.label);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsEmptyCollectionWhenStockIsZero() {
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(0);
        List<Product> products = createListFromIterable(iterable);
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsEmptyCollectionWhenArgumentIsTooLarge() {
        stubProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(11);
        List<Product> products = createListFromIterable(iterable);
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsCorrectCountOfProducts() {
        stubProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(5);
        List<Product> products = createListFromIterable(iterable);
        assertEquals(5, products.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsTheProductsOrderedAlphabetically() {
        stubProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(5);
        List<Product> products = createListFromIterable(iterable);

        Set<String> expectedLabels = products.stream()
                .map(Product::getLabel)
                .collect(Collectors.toCollection(TreeSet::new));

        int i = 0;
        for (String label : expectedLabels) {
            assertEquals(label, products.get(i++).getLabel());
        }
    }

    @Test
    public void testFindAllInPriceRangeReturnsEmptyCollectionIfNoSuchRangePresent() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllInRange(9999, 99999));
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllInPriceRangeReturnsCorrectRange() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllInRange(10, 30));
        assertEquals(5, products.size());
        for (Product product : products) {
            assertTrue(product.price > 10 && product.price <= 30);
        }
    }

    @Test
    public void testFindAllInPriceRangeReturnsProductsInDescendingOrderByPrice() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllInRange(10, 30));

        List<Product> expected = products.stream()
                .sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice()))
                .collect(Collectors.toList());

        assertEquals(expected, products);
    }

    @Test
    public void testFindAllByPriceReturnEmptyCollectionWhenNoProductsWithGivenPrice() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllByPrice(0));
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllByPriceReturnCorrectCountOfProducts() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllByPrice(10));
        assertEquals(5, products.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsThrowWhenTheGivenCountIsMoreThanTheProducts() {
        stubProducts();
        stock.findFirstMostExpensiveProducts(11);
    }

    @Test
    public void testFindFirstMostExpensiveProductsReturnCorrectCountOfProducts() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findFirstMostExpensiveProducts(5));
        assertEquals(5, products.size());
    }

    @Test
    public void testFindFirstMostExpensiveProductsReturnCorrectProductsByHighestPrice() {
        List<Product> expected = stubProducts().stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(5)
                .collect(Collectors.toList());
        List<Product> products = createListFromIterable(stock.findFirstMostExpensiveProducts(5));

        assertEquals(expected, products);
    }

    @Test
    public void testFindAllByQuantityReturnEmptyCollectionWhenThereIsNoProductWithTheGivenQuantity() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllByQuantity(0));
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllByQuantityReturnOnlyProductsWithMatchingQuantity() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllByQuantity(5));
        assertEquals(3, products.size());
        for (Product product : products) {
            assertEquals(5, product.getQuantity());
        }
    }

    @Test
    public void testIteratorShouldReturnAllProductsInStock() {
        List<Product> expected = stubProducts();

        Iterator<Product> iterator = stock.iterator();

        int index = 0;
        while(iterator.hasNext()) {
            Product product = iterator.next();
            assertEquals(expected.get(index++).getLabel(), product.getLabel());
        }

    }

    private List<Product> createListFromIterable(Iterable<Product> iterable) {
        assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        return products;
    }

    private List<Product> stubProducts() {
        List<Product> products = Arrays.asList(
                new Product("test_label_1", 10, 2),
                new Product("test_label_2", 10.01, 5),
                new Product("test_label_3", 15, 2),
                new Product("test_label_4", 17, 2),
                new Product("test_label_5", 10, 2),
                new Product("test_label_6", 10, 5),
                new Product("test_label_7", 30, 2),
                new Product("test_label_8", 10, 2),
                new Product("test_label_9", 20, 5),
                new Product("test_label_10", 10, 2)
        );

        for (Product product : products) {
            stock.add(product);
        }

        return products;
    }

}