package sample;

public class Product {
    private int productID;
    private String productName;
    private String quantity;
    private float newPrice;
    private float oldPrice;
    private static String description = "you wont get any description because im lazy";
    private String imgName;

    private static int productCount = 0;
    private static String imagePath = "Resources/";
    public Product(){
        this.productID = productCount;

        productCount++;
    }

    public Product(String productName, String quantity, float newPrice, float oldPrice, String imgName) {
        this.productName = productName;
        this.quantity = quantity;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.imgName = imgName;
        this.productID = productCount;

        productCount++;
    }

    public Product(String productName, String quantity, float newPrice, float oldPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.productID = productCount;

        productCount++;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public float getNewPrice() {
        return newPrice;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public void setNewPrice(float newPrice) {
        this.newPrice = newPrice;
    }

    public void setOldPrice(float oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String toString(){
        return productName + " from " + oldPrice + "€ to " + newPrice +"€";
    }

    public String toJSON(){
        return "{ 'productID':" +productID +"";
    }

    public String getImgPath(){
        return imagePath + imgName;
    }

    public static String getDescription(){
        return description;
    }
}
