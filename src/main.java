import java.util.List;

public class main {
    public static void main(String[] args) {
        String productFile = "data\\ProductFile.txt";
        String supplierFile = "data\\SupplierFile.txt";

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
}
