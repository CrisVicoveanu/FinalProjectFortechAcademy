package TestData;

public class Purchase {
    private String firstProduct;
    private String expectedNumberOfItemsAddedToCart;

    public Purchase(String firstProductName, int i) {
        this.firstProduct = firstProduct;
        this.expectedNumberOfItemsAddedToCart = expectedNumberOfItemsAddedToCart;
    }

    public String getFirstProductName() {
        return firstProduct;
    }
    public String getExpectedNumberOfItemsAddedToCart() {
        return expectedNumberOfItemsAddedToCart;
    }
}

