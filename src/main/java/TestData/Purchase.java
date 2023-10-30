package TestData;

public class Purchase {
    private String productName;
    private String expectedNumberOfItemsInCart;
    public Purchase(String productName, String expectedNumberOfItemsInCart){
        this.productName = productName;
        this.expectedNumberOfItemsInCart = expectedNumberOfItemsInCart;
    }

    public String getProductName() {
        return productName;
    }

    public String getExpectedNumberOfItemsInCart() {
        return expectedNumberOfItemsInCart;
    }
}
