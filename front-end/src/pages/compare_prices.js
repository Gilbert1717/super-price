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
    <div className='content'>
      <h2>Compare Prices for <em>'{query}':</em></h2> 
      {data != null ? data.map((price_product_store, _) => (
          <button key={uuidv4()}>{
            <>
            {price_product_store["product"]["name"]} <br/>
            {price_product_store["store"]["name"]} <br/>
            {price_product_store["store"]["address"]} <br/>
            <p className='price'>{price_product_store["price"]["price"]}</p>
            </>
          }</button>
        )) : ""}
    </div>
  );
}

export default ComparePrices;
