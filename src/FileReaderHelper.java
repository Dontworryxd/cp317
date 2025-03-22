//imports
import java.io.*;
import java.util.*;

abstract class FileRead<T> {
  public abstract List<T> readFile(String filename);
}

class ProductFileParser extends FileRead<Product> {
  @Override
  public List<Product> readFile(String filename) {
      List<Product> productList = new ArrayList<>();
      String validTextRegex = "^[a-zA-Z0-9 .,-]+$";

      try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
          String line;
          while ((line = br.readLine()) != null) {
              if (line.trim().isEmpty() || line.startsWith("Product ID")) continue;

              String[] data = line.split(",\\s+");

              if (data.length != 7) {
                  System.err.println("Invalid product format (expected 7 fields): " + line);
                  continue;
              }

              try {
                  int productID = Integer.parseInt(data[0]);
                  String name = data[1];
                  String description = data[2];
                  String price = data[3];

                  if (!name.matches(validTextRegex)) {
                      System.err.println("Invalid characters in product name: " + name);
                      continue;
                  }
                  if (!description.matches(validTextRegex)) {
                      System.err.println("Invalid characters in product description: " + description);
                      continue;
                  }

                  if (!price.matches("\\$?\\d+(\\.\\d{1,2})?")) {
                      System.err.println("Invalid price format: " + price);
                      continue;
                  }
                  int quantity = Integer.parseInt(data[4]);
                  if (quantity < 0) {
                      System.err.println("Negative quantity in product: " + line);
                      continue;
                  }
                  String status = data[5];
                  int supplierID = Integer.parseInt(data[6]);

                  productList.add(new Product(productID, name, description, price, quantity, status, supplierID));
              } catch (NumberFormatException e) {
                  System.err.println("Number format error in product line: " + line);
              }
          }
      } catch (IOException e) {
          System.err.println("FATAL ERROR: Could not read product file '" + filename + "'. File may not exist or is unreadable.");
          e.printStackTrace();
      }

      System.out.println("Products successfully loaded: " + productList.size());
      return productList;
  }
}

class SupplierFileParser extends FileRead<Supplier> {
  @Override
  public List<Supplier> readFile(String filename) {
      List<Supplier> supplierList = new ArrayList<>();
      String validTextRegex = "^[a-zA-Z0-9 .,-]+$";

      try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
          String line;
          while ((line = br.readLine()) != null) {
              if (line.trim().isEmpty() || line.startsWith("Supplier ID")) continue;

              String[] data = line.split(",\\s+");

              if (data.length != 5) {
                  System.err.println("Invalid supplier format (expected 5 fields): " + line);
                  continue;
              }

              try {
                  int supplierID = Integer.parseInt(data[0]);
                  String name = data[1];
                  String address = data[2];
                  String phone = data[3];
                  String email = data[4];

                  if (!name.matches(validTextRegex)) {
                      System.err.println("Invalid characters in supplier name: " + name);
                      continue;
                  }
                  if (!address.matches(validTextRegex)) {
                      System.err.println("Invalid characters in supplier address: " + address);
                      continue;
                  }

                  supplierList.add(new Supplier(supplierID, name, address, phone, email));
              } catch (NumberFormatException e) {
                  System.err.println("Number format error in supplier line: " + line);
              }
          }
      } catch (IOException e) {
          System.err.println("FATAL ERROR: Could not read supplier file '" + filename + "'. File may not exist or is unreadable.");
          e.printStackTrace();
      }

      System.out.println("Suppliers successfully loaded: " + supplierList.size());
      return supplierList;
  }
}

              
