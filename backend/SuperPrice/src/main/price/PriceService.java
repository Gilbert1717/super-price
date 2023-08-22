interface PriceService {
    /**
     * return list of products which matches the input catergory
     */
    public List<Product> SearchByCatergory(String catergory);

    /**
     * return list of prices which matches the input product name
     */
    public List<Price> SearchByName(String name);

    /**
     * return list of prices which matches the input barcode
     */
    public List<Price> SearchByBarcode(int barcode);

    /**
     * return list of prices which matches the input status (such as price drop, special offer, on sale, MSRP)
     */
    public List<Price> SearchByStatus(String status);

    /**
     * return list of sorted prices based on the input sorting condition
     */
    public List<Price> SortPrice(String condition);
}