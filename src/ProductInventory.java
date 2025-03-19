import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductInventory {
    
    public static void main(String[] args) {
        // Create instances of the parser classes
        ProductFileParser productParser = new ProductFileParser();
        SupplierFileParser supplierParser = new SupplierFileParser();

        // Read products and suppliers from files using the parser classes
        List<Product> products = productParser.readFile("ProductFile.txt");
        List<Supplier> suppliers = supplierParser.readFile("SupplierFile.txt");

        // Sort products by ProductID
        ProductSorter.sortByProductID(products);

        // Write to inventory.txt
        writeInventoryToFile(products, suppliers);
    }

    public static void writeInventoryToFile(List<Product> products, List<Supplier> suppliers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.txt"))) {
            // Header for the file
            writer.write("Product ID | Product Name | Quantity | Price | Status | Supplier Name\n");

            // Iterate over products
            for (Product product : products) {
                Supplier supplier = findSupplierByID(product.getSupplierID(), suppliers);
                if (supplier != null) {
                    // Write product details along with the supplier name
                    writer.write(String.format("%d | %s | %d | $%.2f | %s | %s\n", 
                        product.getProductID(), 
                        product.getName(), 
                        product.getQuantity(), 
                        product.getPrice(), 
                        product.getStatus(), 
                        supplier.getName()));
                }
            }
            System.out.println("Inventory has been written to inventory.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Supplier findSupplierByID(int supplierID, List<Supplier> suppliers) {
        for (Supplier supplier : suppliers) {
            if (supplier.getSupplierID() == supplierID) {
                return supplier;
            }
        }
        return null;  // Return null if no supplier is found
    }
}
