import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import logo from "../images/logo.png";
import searchBtn from "../images/search.png";

function Header() {
  const navigate = useNavigate();
  const [inputText, setInputText] = useState('');

  return (
    <div className='background'>
      <div className='header'>
        <button onClick={()=>{navigate('/')}}><img src={logo} className= "logo" alt="super price logo"/></button>
        <div className='search-bar'>
          <input
            type="text"
            value={inputText}
            onChange={(event)=>{setInputText(event.target.value);}}
            placeholder="Enter product name..."
          />
          <button onClick={()=>{navigate('/search-results')}}><img src={searchBtn} alt="magnifying glass"/></button>
        </div>
      </div>
    </div>
  );
}

export default Header;
