//imports
import java.io.*;
import java.util.*;

abstract class FileRead<T>{
  // patrick - this to read files but will be overeriden based on which file
  public abstract List<T> readFile(String filename);
}

class ProductFileParser extends FileRead<Product> {
  @Override
  public List<Product> readFile(String filename) {
      List<Product> productList = new ArrayList<>();
      
      try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
          String line;
          while ((line = br.readLine()) != null) {
              // Skip empty lines or headers
              if (line.trim().isEmpty() || line.startsWith("Product ID")) continue;
              
              // Split line by spaces/tabs
              String[] data = line.split(",\\s+");

              if (data.length < 7) {
                  System.out.println("Ignoring invalid product line: " + line);
                  continue;
              }

              try {
                  int productID = Integer.parseInt(data[0]);
                  String name = data[1];
                  String description = data[2];
                  String price = data[3];
                  int quantity = Integer.parseInt(data[4]);
                  String status = data[5];
                  int supplierID = Integer.parseInt(data[6]);

                  productList.add(new Product(productID, name, description, price, quantity, status, supplierID));
              } catch (NumberFormatException e) {
                  System.out.println("Error: Invalid number format in line: " + line);
              }
          }
      } catch (IOException e) {
          System.out.println("Error: Unable to read product file. " + e.getMessage());
      }

      System.out.println("Products successfully loaded: " + productList.size());
      return productList;
  }
}

  /**Read, parse, and store supplier list
  * @param filename The name of the supplier file to read.
  * @return A list of Supplier objects.
  */
class SupplierFileParser extends FileRead<Supplier> {
  //read prod file, return list of objects
  @Override
  public List<Supplier> readFile(String filename) {
      List<Supplier> supplierList = new ArrayList<>();

      try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
          String line;
          while ((line = br.readLine()) != null) {
              // Skip empty lines or headers
              if (line.trim().isEmpty() || line.startsWith("Supplier ID")) continue;

              // Split line by spaces/tabs
              String[] data = line.split(",\\s+");

              if (data.length < 5) {
                  System.out.println("Ignoring invalid supplier line: " + line);
                  continue;
              }

              try {
                  int supplierID = Integer.parseInt(data[0]);
                  String name = data[1];
                  String address = data[2];
                  String phone = data[3];
                  String email = data[4];

                  supplierList.add(new Supplier(supplierID, name, address, phone, email));
              } catch (NumberFormatException e) {
                  System.out.println("Error: Invalid number format in line: " + line);
              }
          }
      } catch (IOException e) {
          System.out.println("Error: Unable to read supplier file. " + e.getMessage());
      }

      System.out.println("Suppliers successfully loaded: " + supplierList.size());
      return supplierList;
  }
}
              
