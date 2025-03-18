import java.util.Comparator;
import java.util.List;

public class ProductSorter {
    
    public static void sortByProductID(List<Product> products) {
	//Sorts the file in ascending order of ProductID
	products.sort(Comparator.comparingInt(Product::getProductID));
    }
}
