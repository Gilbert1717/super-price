import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import logo from "../images/logo.png";
import searchBtn from "../images/search.png";

function Header() {
  const navigate = useNavigate();
  const [inputText, setInputText] = useState('');

  function search() {
    if (inputText) {
      navigate(`/search-results/${inputText}`)
    } 
  }

  

  function handleKeyDown(e) {
    if (e.key === 'Enter') {
      // The 'Enter' key was pressed
      search()
    }
  };
  
  return (
      <div className='header'>
        <button className ="logo-button"  onClick={()=>{navigate('/')}}><img src={logo} className= "logo" alt="super price logo"/></button>
        <div className='search-bar'>
          <input
            type="text"
            value={inputText}
            onChange={(event)=>{setInputText(event.target.value)}}
            onKeyDown={handleKeyDown}
            placeholder="Enter product name..."
          />
          <button onClick={search}><img src={searchBtn} alt="magnifying glass"/></button>
        </div>

        <div>
          <button className="OrdersBtn" onClick={()=>navigate("/orders")}>View Orders</button>
      </div>
      </div>
  );
}

export default Header;
