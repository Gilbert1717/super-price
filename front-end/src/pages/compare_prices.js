import React, { useEffect, useState } from 'react';
import { v4 as uuidv4 } from 'uuid';
import { useParams } from 'react-router-dom';
import axios from "axios"
import { useCart, ADD_TO_CART } from './CartContext'; // Import the CartContext
  
function ComparePrices() {
  const { query } = useParams();
  const [data, setData] = useState(null);
  const { dispatch } = useCart(); // Access the cart context
  
  useEffect(() => {
    async function getSearch(product_name) {
        if (product_name){
          const response = await axios.get(`http://localhost:8080/price/storePrice/${query}`);
          console.log(response)
          if (!response.data) {
            setData(null);
          } else{
            setData(response.data);
          }
        } 
    }

    getSearch(query);
  }, [query])

  // Function to add an item to the cart
  function addToCart(item) {
    dispatch({ type: ADD_TO_CART, payload: item });
  }

  return (
      <div className="compare-container">
        <h2 className='compareHeading'>Compare Prices for <em>'{query}':</em></h2>
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
