import React, { useEffect, useState } from 'react';
import { v4 as uuidv4 } from 'uuid';
import { useParams } from 'react-router-dom';
import axios from "axios"
  
function ComparePrices() {
  const { query } = useParams();
  const [data, setData] = useState(null);
  
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
                  <p className='price'>{"$" + price_product_store["price"]["price"]}</p>
                  <button className='AddToCart'>add to cart</button>
                </div>
            ))
            : ""}
      </div>
  );
}

export default ComparePrices;
