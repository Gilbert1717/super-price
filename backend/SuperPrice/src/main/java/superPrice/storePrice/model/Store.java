package superPrice.storePrice.model;

public class Store {

    private int storeId;
    private String name;
    private String address;
    private int postcode;

    public Store(int storeId, String name, String address, int postcode) {
        this.storeId = storeId;
        this.name = name;
        this.address = address;
        this.postcode = postcode;
    }

    public Store() {
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}