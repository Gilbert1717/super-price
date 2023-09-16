// import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { v4 as uuidv4 } from 'uuid';

function Categories() {
  const navigate = useNavigate();

  const categories = ["Accessories", "Appliances", "Clothing", "Electronics", "Sports"];

  return (
    <div className='content'>
      <h1>Search category</h1>
      {categories.map((category, _) => (
          <button onClick={()=>navigate(`/category-results/${category}`)} key={uuidv4()}><span></span>{category}</button>
      ))}
    </div>
  );
}

export default Categories;
