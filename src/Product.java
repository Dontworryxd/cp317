// patrick - class for each individual item in the product file
public class Product {
    private int productID;
    private String name;
    private String description;
    private String price;
    private int quantity;
    private String status;
    private int supplierID;

    // patrick - constructor for each item
    public Product(int productID, String name, String description, String price, int quantity, String status, int supplierID) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.supplierID = supplierID;
    }

    // patrick - dont need setters here so these are the getters fufils encapsulation keeping the originals private
    public int getProductID() {return productID;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getPrice() {return price;}
    public int getQuantity() {return quantity;}
    public String getStatus() {return status;}
    public int getSupplierID() {return supplierID;}

    // patrick - for testing this will print out the following when used in a print statement
    @Override
    public String toString() {
        return "Product ID: " + productID + 
               " Name: " + name + 
               " Description: " + description + 
               " Price: " + price + 
               " Quantity: " + quantity + 
               " Status: " + status + 
               " Supplier ID: " + supplierID;
    }

}
