// import React, { useState } from 'react';
import { v4 as uuidv4 } from 'uuid';

function Categories() {

  const categories = ["Electronics", "Appliances", "Beauty", "Furniture", "Accessories", "Grocery", "Stationery", "Fitness", "Footwear"];

  return (
    <div className='categories'>
      <h1>Search category</h1>
      {categories.map((category, _) => (
          <button key={uuidv4()}><span></span>{category}</button>
      ))}
    </div>
  );
}

export default Categories;
