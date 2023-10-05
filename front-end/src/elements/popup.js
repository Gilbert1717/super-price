import React, { useEffect, useState } from 'react';
import axios from "axios"
import { v4 as uuidv4 } from 'uuid';
import { useNavigate } from 'react-router-dom';



function Popup() {
  const navigate = useNavigate();
  const [showPopup, setShowPopup] = useState(true);
  const [data, setData] = useState(null);

  if (localStorage.getItem("lastTimePopup") === null){
    localStorage.setItem("lastTimePopup", Date.now())
  }

  useEffect(() => {
    async function getSpecials(){
      const response = await axios.get(process.env.REACT_APP_API_URL + "/price/ten");
      console.log(response.data)
      setData(response.data)
    }

    getSpecials() 
    localStorage.setItem('lastTimePopup', Date.now())    
  }, [])

  function handleClick(barcode){
    setShowPopup(false)
    navigate(`/compare-prices/${barcode}`)
  }

  return (
    <>
      { showPopup ?
      <div className='popup'>
          <div style={{  display: "flex" }}>
          <h1 style={{  flex: "20" }}>Special Offers!</h1>
          <button  style={{  flex: "1" }} onClick={()=> setShowPopup(false)}> x </button>
          </div>
          <br />
          <h3>View our latest products on special:</h3>
          <br />
          <div>{
            data!=null ? data.map((item, _) => (
            <button className='product-btn' onClick={()=>handleClick(item["product"]["barcode"])} key={uuidv4()}>
              <h3>{item["product"]["name"]}</h3>
              <p>{item["product"]["category"]}</p>    
              <p>{item["store"]["name"]}</p>  
              <h2>{item["price"]["price"]}</h2>
            </button>))
            
            : <p>No Specials Found.</p>
          }</div>
          <br />
          <button onClick={()=> setShowPopup(false)}> Close </button>
      </div>
      : ""}
    </>
  );
  }
  
  export default Popup;
  