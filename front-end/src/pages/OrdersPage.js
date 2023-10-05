import React, { useState } from 'react';
import searchBtn from "../images/search.png";
import axios from "axios"
import { v4 as uuidv4 } from 'uuid';

function OrdersPage() {
    const [inputText, setInputText] = useState("")
    const [orderData, setOrderData] = useState(null)

    async function search(){
        if (inputText){
            const response = await axios.get(`http://localhost:8080/order/${inputText}`);
            console.log(response)
            if (!response.data) {
                setOrderData(null);
            } else{
                console.log(response.data)
                setOrderData(response.data)
            }
        } 
    }

    // async function getData(){
    //     console.log(process.env.REACT_APP_API_URL + '/fresh/hello')
    //     const apiUrl = process.env.REACT_APP_API_URL + '/fresh/hello';
    //     const response = await axios.get(apiUrl)
    //     setData(response.data)
    //   }

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

            <h3>Time Created: {orderData["order"]["creatingTime"].slice(0,10)}</h3><br />
            <h3>Delivery Time: {orderData["order"]["deliverTime"].slice(0,10)}</h3><br />
            <h3>Delivery Type: {orderData["order"]["deliveryType"]}</h3>
            {orderData["findItemResponse"] != null ? orderData["findItemResponse"].map((item, _) => (
                <div key={uuidv4()}>{
                    <>
                    <br/>
                    {item["product_name"]} x {item["quantity"]} <br/>
                    {item["storeName"]} 
                    <br/>
                    {item["price"]} <br/>
                    
                    <br/>
                    </>
                }</div>
                )) : ""}
            </>
            : <p style={{ color: 'white' }}>No Orders to Display. </p>}
        </div>
      </div>
    );
  }
  
  export default OrdersPage;
  