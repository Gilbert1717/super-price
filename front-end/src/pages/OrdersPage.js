import React, { useState } from 'react';
import searchBtn from "../images/search.png";
import axios from "axios"
import { v4 as uuidv4 } from 'uuid';

function OrdersPage() {
    const [inputText, setInputText] = useState("")
    const [orderData, setOrderData] = useState(null)
    const [foundMessage, setFoundMessage] = useState("")

    async function search(){
        if (inputText){
            const response = await axios.get(`http://localhost:8080/order/${inputText}`);
            if (!response.data) {
                setOrderData(null);
                setFoundMessage(`Could Not Find Order "${inputText}"` );
            } else{
                setOrderData(response.data);
                console.log(response.data)
                setFoundMessage("");
            }
        } 
    }

    return (
      <div>
        <div className="search-bar-box">
            <div className='search-bar order-search'>
            <input
                type="text"
                value={inputText}
                onChange={(event)=>{setInputText(event.target.value);}}
                placeholder="Enter order ID..."
            />
            <button onClick={search}><img src={searchBtn} alt="magnifying glass"/></button>
            </div>
        </div>
        <div className='order-result'>
            {orderData!=null ? <>
            <h3 style={{ color: 'white' }}>Details for Order:</h3>
            <h3 className="box">Date Created: {orderData["order"]["creatingTime"].slice(0,10)}</h3><br />
            <h3 className="box">Delivery Time: {orderData["order"]["deliverTime"].slice(0,10)}</h3><br />
            <h3 className="box">Delivery Type: {orderData["order"]["deliveryType"]}</h3>
            <br />
            <h3 style={{ color: 'white' }}>Items Ordered:</h3>
            {orderData["findItemResponse"] != null ? orderData["findItemResponse"].map((item, _) => (
                <div className="box" key={uuidv4()}>{
                    <>
                    <br/>
                    {item["product_name"]} x {item["quantity"]} <br/>
                    {item["storeName"]} 
                    <br/><br/>
                    <p className='price'>${item["price"]}</p>                    
                    <br/>
                    </>
                }</div>
                )) : ""}
            </>
            : <>
            <p style={{ color: 'white' }}>No Orders to Display. </p>
            <br />
            <p style={{ color: 'white' }}>{foundMessage}</p>
            </>}
        </div>
      </div>
    );
  }
  
  export default OrdersPage;
  