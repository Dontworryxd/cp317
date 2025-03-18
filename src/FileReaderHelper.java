//imports
import java.io.*;
import java.util.*;

public class FileReaderHelper {
  //read prod file, return list of objects
  public static List<Product>readProducts(String filename) {
    List<product> ProductList=new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new Filereader(filename))){
      String line;
      while ((line=br.readLine())!=null){
        String[] data=line.split("\\s+")


        //is line format valid 
          if (data.length<7){
            System.out.println("Ignore invalid product line" + line);
            continue;}
          try{
            int ProductId=Integer.parseInt(data[0]);
            String name =data[1]
            String description =data[2]
            double price= Double.parseDouble(data[3]);
            int quantity=Integer.parseInt(data[4]);
            Supplier status =data[5]
            int Supplier ID=Integer.parseInt(data[6]);

            productList.add(new Product(productID,description, price, quantity,status,supplierID));
          }catch(IOException e){
            System.out.println("Error: Unable to read product file." +e.getMessage());

             System.out.println("Products successfully generated" +productList.size() + "products.")
               return productList;}

            
  /**Read, parse, and store supplier list
  * @param filename The name of the supplier file to read.
  * @return A list of Supplier objects.
  */
  public static List<Supplier> readSuppliers (String filename) {
    List<Supplier> supplierList= new ArrayList<>();

  try( br BufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;

    //TBA FINISH READING LINE BY LINE
              
