public class main {
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
