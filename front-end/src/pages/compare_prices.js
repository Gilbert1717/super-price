import React, { useEffect, useState } from 'react';
import { v4 as uuidv4 } from 'uuid';
import { useParams } from 'react-router-dom';
import axios from "axios"
import { useCart, ADD_TO_CART } from './CartContext'; // Import the CartContext

function ComparePrices() {
  const { query } = useParams();
  const [data, setData] = useState(null);
  const { dispatch } = useCart(); // Access the cart context
  const [sortOrder, setSortOrder] = useState('lowToHigh'); // State for sorting order

  useEffect(() => {
    async function getSearch(product_name) {
        if (product_name){
          console.log(`${process.env.REACT_APP_API_URL}/price/storePrice/${query}`)
          const response = await axios.get(`${process.env.REACT_APP_API_URL}/price/storePrice/${query}`);
          if (!response.data) {
            setData(null);
          } else{
            setData(response.data);
          }
          setData(sortedData);
        }
      }
    }

    getSearch(query);
  }, [query, sortOrder])

  // Function to add an item to the cart
  function addToCart(item) {
    dispatch({ type: ADD_TO_CART, payload: item });
  }

  // Function to handle sorting order change
  function handleSortOrderChange(event) {
    setSortOrder(event.target.value);
  }

  return (
      <div className="compare-container">
        <div className="compare-header">
          <h2 className='compareHeading'>
            Compare Prices for <em>'{query}':</em>
          </h2>
          {/* Dropdown for sorting */}
          <select className="sorting-Feature" value={sortOrder} onChange={handleSortOrderChange}>
            <option value="lowToHigh">Low to High</option>
            <option value="highToLow">High to Low</option>
          </select>
        </div>
        {data != null
            ? data.map((price_product_store, _) => (
                <div className="compare-item" key={uuidv4()}>
                  <div className="product-name">
                    {price_product_store["product"]["name"]}
                  </div>
                  <div className="store-name">
                    {price_product_store["store"]["name"]}
                  </div>
                  <div className="store-address">
                    {price_product_store["store"]["address"]}
                  </div>
                  <p className='price'>{"$" + price_product_store["price"]["price"].toFixed(2)}</p>
                  <button className='AddToCart' onClick={() => addToCart({
                    name: price_product_store["product"]["name"],
                    store: price_product_store["store"]["name"],
                    address: price_product_store["store"]["address"],
                    price: price_product_store["price"]["price"],
                  })}>
                    Add to Cart
                  </button>
                </div>
            ))
            : ""}
      </div>
  );
}

export default ComparePrices;
 