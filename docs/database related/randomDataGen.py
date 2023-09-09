import string
import csv

# Function to generate a random barcode
def generate_barcode():
    return ''.join(random.choice(string.digits) for _ in range(10))

# List of categories for products
category_product_dict = {
    "Electronics": [
        "Laptop", "Headphones", "Smartphone", "Tablet",
        "Smart TV", "Digital Camera", "Wireless Mouse", "Gaming Console"
    ],
    "Clothing": [
        "T-shirt", "Jeans", "Jacket", "Dress",
        "Sneakers", "Hoodie", "Socks", "Skirt"
    ],
    "Appliances": [
        "Coffee Maker", "Blender", "Toaster", "Microwave",
        "Refrigerator", "Washing Machine", "Food Processor", "Air Fryer"
    ],
    "Sports": [
        "Basketball", "Running Shoes", "Soccer Ball", "Golf Clubs",
        "Yoga Mat", "Tennis Racket", "Cycling Helmet", "Fitness Tracker"
    ],
    "Accessories": [
        "Backpack", "Watch", "Sunglasses", "Bracelet",
        "Wallet", "Hat", "Necklace", "Handbag"
    ]
}

# Generate data for the Product table
product_data = []
unique_products = set()
for _ in range(200):
    barcode = generate_barcode()
    category = random.choice(list(category_product_dict.keys()))
    name = random.choice(category_product_dict[category])
    product = (barcode, name, category)
    
    # Check if the product is unique; if so, add it to the list
    if (name, category) not in unique_products:
        unique_products.add((name, category))
        product_data.append(product)

# Generate data for the Store table
store_data = [
    (101, "Electronics Store", "123 Main St", "12345"),
    (102, "Fashion Store", "456 Elm St", "54321"),
    (103, "Appliance Store", "789 Oak St", "98765"),
    (104, "Sports Store", "101 Maple St", "13579"),
    (105, "Accessories Store", "202 Cedar St", "24680"),
    (106, "Tech Gadgets Store", "345 Elm St", "67890"),  
    (107, "Home Decor Store", "567 Oak St", "54321"),     
    (108, "Outdoor Sports Store", "789 Pine St", "98765"),  
    (109, "Jewelry Store", "234 Maple St", "13579"),       
    (110, "Kitchen Appliances Store", "678 Birch St", "24680")
]

# List of sample Prices
prices = [round(random.uniform(10.0, 999.99), 2) for _ in range(200)]

# List of sample Status options
statuses = ["Special Offer", "Price Down", "MSRP"]

# Generate data for the Store Price table with foreign key constraints
store_price_data = []

for _ in range(200):
    product = random.choice(product_data)
    store = random.choice(store_data)
    barcode = product[0]
    store_id = store[0]
    price = random.choice(prices)
    status = random.choice(statuses)
    store_price_data.append((barcode, store_id, price, status))

with open("output.sql", "w") as sql_file:
    sql_file.write("-- Insert statements for the Product table\n")
    for insert_statement in product_insert_statements:
        sql_file.write(insert_statement + "\n")

    sql_file.write("\n-- Insert statements for the Store table\n")
    for insert_statement in store_insert_statements:
        sql_file.write(insert_statement + "\n")

    sql_file.write("\n-- Insert statements for the Store Price table\n")
    
    for insert_statement in store_price_insert_statements:
        sql_file.write(insert_statement + "\n")


store_price_insert_statement = f"INSERT INTO StorePrice (Barcode, StoreID, Price, Status) VALUES ('{barcode}', {store_id}, {price}, '{status}');"

    store_insert_statement = f"INSERT INTO Store (StoreID, Name, Address, Postcode) VALUES ({store_id}, '{store_name}', '{store_address}', '{store_postcode}');"
    store_insert_statements.append(store_insert_statement)
  
    product_insert_statement = f"INSERT INTO Product (Barcode, Name, Category) VALUES ('{barcode}', '{name}', '{category}');"

# Write data to CSV files
def write_to_csv(filename, data):
    with open(filename, 'w', newline='') as csvfile:
        writer = csv.writer(csvfile)
        for row in data:
            writer.writerow(row)

write_to_csv("product_data.csv", product_data)
write_to_csv("store_data.csv", store_data)
write_to_csv("store_price_data.csv", store_price_data)

print("Data has been written to CSV files.")