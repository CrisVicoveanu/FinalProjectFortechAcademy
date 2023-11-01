package TestData;

public class Purchase {
    private String firstProductName;
    private String expectedNumberOfItemsAddedToCart;

    public Purchase(String firstProductName, int i) {
        this.firstProductName = firstProductName;
        this.expectedNumberOfItemsAddedToCart = expectedNumberOfItemsAddedToCart;
    }

    public String getFirstProductName() {
        return firstProductName;
    }
    public String getExpectedNumberOfItemsAddedToCart() {
        return expectedNumberOfItemsAddedToCart;
    }
}

