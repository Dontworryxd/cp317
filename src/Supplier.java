// patrick - class for each individual item in the supply file
public class Supplier {
    private int supplierID;
    private String name;
    private String address;
    private String phone;
    private String email;

    // patrick - constructor for each item
    public Supplier(int supplierID, String name, String address, String phone, String email) {
        this.supplierID = supplierID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
}

    // patrick - dont need setters here so these are the getters fufils encapsulation keeping the originals private
    public int getSupplierID() { return supplierID; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    // patrick - for testing this will print out the following when used in a print statement
    @Override
    public String toString() {
        return "Supplier ID: " + supplierID + 
               " Name: " + name + 
               " Address: " + address + 
               " Phone: " + phone + 
               " Email: " + email;
    }

}


