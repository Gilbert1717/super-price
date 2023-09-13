import React, { useEffect, useState } from 'react';
import axios from "axios"
import { useParams } from 'react-router-dom';

function SearchResults() {
  const { query } = useParams();
  const [data, setData] = useState(null);

  
  useEffect(() => {
    async function getSearch(product_name) {
        if (product_name){
          const response = await axios.get(`http://localhost:8080/api/price/name/${query}`);
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
        <h2>Results for <em>{query}</em></h2>
        {data}
      </div>
    );
  }
  
  export default SearchResults;
  