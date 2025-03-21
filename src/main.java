import java.util.List;

public class Main {
/*public static void main(String[] args) {
        // patrick showing usage of how to create supply objects the same will go for product
        Supplier supply = new Supplier(1234, "microsoft", "3852 althorpe circle", "6479372135", "ikoiwoh");
        String productFile = "data//ProductFile.txt";
        String supplierFile = "data//SupplierFile.txt";

        // Use polymorphism to read both files
        FileRead<Product> productParser = new ProductFileParser();
        FileRead<Supplier> supplierParser = new SupplierFileParser();

        List<Product> products = productParser.readFile(productFile);
        List<Supplier> suppliers = supplierParser.readFile(supplierFile);

        // Print products
        System.out.println("\nProducts:");
        for (Product p : products) {
            System.out.println(p);
        }


        // Print suppliers
        System.out.println("\nSuppliers:");
        for (Supplier s : suppliers) {
            System.out.println(s);
        }
    }
*/

public static void main(String[] args) {
    // Create instances of the parser classes
    FileRead<Product> productParser = new ProductFileParser();
    FileRead<Supplier> supplierParser = new SupplierFileParser();

    // Read products and suppliers from files using the parser classes
    List<Product> products = productParser.readFile("data//ProductFile.txt");
    List<Supplier> suppliers = supplierParser.readFile("data//SupplierFile.txt");

    // Sort products by ProductID
    ProductSorter.sortByProductID(products);

    // Write to inventory.txt
    ProductInventory.writeInventoryToFile(products, suppliers);
}
}
