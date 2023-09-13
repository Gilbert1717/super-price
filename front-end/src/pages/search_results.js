import React, { useEffect, useState } from 'react';
import axios from "axios"
import { v4 as uuidv4 } from 'uuid';
import { useNavigate, useParams } from 'react-router-dom';


function SearchResults() {
  const navigate = useNavigate();
  const { query } = useParams();
  const [data, setData] = useState(null);

  
  useEffect(() => {
    async function getSearch(product_name) {
        if (product_name){
          const response = await axios.get(`http://localhost:8080/price/product/${query}`);
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
        <h1>Results for `<em>{query}</em>`</h1>
        {data != null ? data.map((item, _) => (
          <button onClick={()=>navigate(`/compare-prices/${item["barcode"]}`)} key={uuidv4()}>{
            <>
            <span></span>
            {item["name"]} <br/>
            {item["barcode"]} <br/>
            {item["category"]} 
            </>
          }</button>
        )) : ""}
        {data != null ? (data.length == 0 ? <><br /><h2>No Results Found.</h2></>:""):""}
      </div>
    );
  }
  
  export default SearchResults;
  