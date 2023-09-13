import React, { useEffect, useState } from 'react';
import axios from "axios"
import { v4 as uuidv4 } from 'uuid';
import { useParams, useNavigate } from 'react-router-dom';

function CategoryResults() {
  const navigate = useNavigate();
  const { query } = useParams();
  const [data, setData] = useState(null);

  
  useEffect(() => {
    async function getSearch(product_name) {
        if (product_name){
          const response = await axios.get(`http://localhost:8080/price/product/category:${query}`);
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
        <h1>Products in Category: <em>{query}</em></h1>
        {data != null ? data.map((item, _) => (
          <button onClick={()=>navigate(`/compare-prices/${item["barcode"]}`)} key={uuidv4()}>{
            <>
            <span></span>
            {item["name"]} <br/>
            {item["category"]} <br/>
            {item["barcode"]}
            </>
          }</button>
        )) : ""}
      </div>
    );
  }
  
  export default CategoryResults;
  