import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileWriterHelper{

  /** 
  *parameters all to help write product inventory to a file
  * @param filename The name of the output file (InventoryFile.txt).
  * @param productList The sorted list of products.
  * @param supplierList The list of suppliers.
  */

  public static void writeInventory (String filename, List<Product> productList, List<Supplier> supplierList){
    try (BufferedWriter bw= new BufferedWriter (new FileWriter(filename))) {

      //create hashmap to allow searching feature in SupplierN Names by ID
      Map<Integer, String> supplierMap = supplierList.stream()
        .collect(Collectors.toMap(Supplier::getSupplierID, Supplier::getSupplierName));

      //Header for output file
      bw.write(String.format("%-10s %-15s %-10s %-10s %-10s %-15s", 
                    "ProductID", "Product Name", "Quantity", "Price", "Status", "Supplier Name"));
      bw.newLine();
      bw.write("----------------------------------------------------------------------------------");
      bw.newLine();

      //Loop through sorted products and write it to a file
      for (Product product : productList){
        //get suppliername from supplierId
        String supplierName= supplierMap.getOrDefault(product.getSupplierID(), "Unknown Supplier");

        //format the output
        String formattedLine = String.format("%-10d %-15s %-10d $%-9.2f %-10s %-15s",
          product.getProductId(),
          product.getName(),
          product.getQuantity(),
          product.getPrice(),
          product.getStatus(),
          supplierName);

        //writing formatted line to file
        bw.write(formattedLine);
        bw.newLine();
      }
    System.out.println("File successfully created and written to: " + filename);}
catch (IOException e) {  
    System.out.println("Error writing to file: " + e.getMessage());
}
      
                                           
                                          
          
  
