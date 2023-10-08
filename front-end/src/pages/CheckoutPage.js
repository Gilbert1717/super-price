import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useCart, CLEAR_CART } from './CartContext';
import creditCard from "../images/CreditCard.png";
import axios from "axios";

function CheckoutPage(props) {
  const { cartState, dispatch } = useCart();
  const navigate = useNavigate();
  const [errorMsg, setErrorMsg] = useState(null);


  const [formData, setFormData] = useState({
    fullName: '',
    email: '',
    address: '',
    city: '',
    state: '',
    zipCode: '',
    nameOnCard: '',
    cardNumber: '',
    expMonth: '',
    expYear: '',
    cvv: '',
  });

  const [errors, setErrors] = useState({});

  async function makeOrder() {

    let noDupsList = [] // tracks duplicates

    const cartOrderItems = [];
    for (const item of cartState.items) {
      let duplicate = false;
      // check if already added this item to orderItems
      for (const exisiting_item of noDupsList) {
        if (exisiting_item.barcode === item.barcode && exisiting_item.storeId === item.storeId) {
          duplicate = true;
        }
      }

      if (!duplicate){
        // find quantity
        let qty = 0;
        for (const item2 of cartState.items) {
          if (item2.barcode === item.barcode && item2.storeId === item.storeId) {
            qty += 1;
          }
        }

        cartOrderItems.push(
          {
            barcode: item.barcode,    
            storeId: item.storeId,        
            quantity: qty          
          })

        noDupsList.push({barcode: item.barcode, storeId: item.storeId})
        
      } 
    }

    const requestBody = {
      deliveryType: props.deliveryType,
      orderItems: cartOrderItems,
      deliverTime: props.deliverTime + ":00", // need ...:00 for formatting... "yyyy-MM-dd HH:mm:ss"
      deliveryAddress: formData['address']
    };
   
    try {
      const response = await axios.post(`${process.env.REACT_APP_API_URL}/order`, requestBody);

      // clear cart
      dispatch({ type: CLEAR_CART });

      // navigate to order confirmation page, giving order id
      navigate(`/order-confirmation/${response.data['order']['id']}`);

    } catch (error) {
      // set error message
      setErrorMsg(error.response.data["message"]);
    }
  }

  const handleInputChange = (e) => {
    const { name, value } = e.target;

    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const newErrors = {};

    // Check if any field is empty or contains only whitespace
    for (const key in formData) {
      if (formData[key].trim() === '') {
        newErrors[key] = `${key.replace(/([A-Z])/g, ' $1').toLowerCase()} is required`;
      }
    }

    // Update the errors state
    setErrors(newErrors);

    // If there are errors, prevent form submission
    if (Object.keys(newErrors).length === 0) {
      // Form is valid, clear the errors and proceed
      setErrors({});

      makeOrder();
    }
  };

  return ( <>
    <div className="CheckOutContainer">
      <form onSubmit={handleSubmit}>
        <div className="row">
          <div className="col">
            <h3 className="title">Personal Details</h3>

            <div className="inputBox">
              <span>Full Name:</span>
              <input
                type="text"
                name="fullName"
                placeholder="Steve Smith"
                value={formData.fullName}
                onChange={handleInputChange}
              />
              {errors.fullName && <p className="error red-text">{errors.fullName}</p>}
            </div>

            <div className="inputBox">
              <span>Email:</span>
              <input
                type="text"
                name="email"
                placeholder="stevesmith@gmail.com"
                value={formData.email}
                onChange={handleInputChange}
              />
              {errors.email && <p className="error red-text">{errors.email}</p>}
            </div>

            <div className="inputBox">
              <span>Address:</span>
              <input
                type="text"
                name="address"
                placeholder="Number - Street Name"
                value={formData.address}
                onChange={handleInputChange}
              />
              {errors.address && <p className="error red-text">{errors.address}</p>}
            </div>

            <div className="inputBox">
              <span>City:</span>
              <input
                type="text"
                name="city"
                placeholder="Melbourne"
                value={formData.city}
                onChange={handleInputChange}
              />
              {errors.city && <p className="error red-text">{errors.city}</p>}
            </div>

            <div className="flex">
              <div className="inputBox">
                <span>State:</span>
                <input
                  type="text"
                  name="state"
                  placeholder="VIC"
                  value={formData.state}
                  onChange={handleInputChange}
                />
                {errors.state && <p className="error red-text">{errors.state}</p>}
              </div>
              <div className="inputBox">
                <span>Zip Code:</span>
                <input
                  type="text"
                  name="zipCode"
                  placeholder="1234"
                  value={formData.zipCode}
                  onChange={handleInputChange}
                />
                {errors.zipCode && <p className="error red-text">{errors.zipCode}</p>}
              </div>
            </div>
          </div>

          <div className="col">
            <h3 className="title">Payment</h3>

            <div className='inputBox'>
              <span>Accepted Cards :</span>
              <img src={creditCard} alt="credit cards" className='creditCardImg'/>
            </div>

            <div className="inputBox">
              <span>Name on Card:</span>
              <input
                type="text"
                name="nameOnCard"
                placeholder="Mr. Steve Smith"
                value={formData.nameOnCard}
                onChange={handleInputChange}
              />
              {errors.nameOnCard && <p className="error red-text">{errors.nameOnCard}</p>}
            </div>

            <div className="inputBox">
              <span>Credit Card Number:</span>
              <input
                type="number"
                name="cardNumber"
                placeholder="1111-2222-3333-4444"
                value={formData.cardNumber}
                onChange={handleInputChange}
              />
              {errors.cardNumber && <p className="error red-text">{errors.cardNumber}</p>}
            </div>

            <div className="inputBox">
              <span>Exp Month:</span>
              <input
                type="text"
                name="expMonth"
                placeholder="January"
                value={formData.expMonth}
                onChange={handleInputChange}
              />
              {errors.expMonth && <p className="error red-text">{errors.expMonth}</p>}
            </div>

            <div className="flex">
              <div className="inputBox">
                <span>Exp Year:</span>
                <input
                  type="number"
                  name="expYear"
                  placeholder="2022"
                  value={formData.expYear}
                  onChange={handleInputChange}
                />
                {errors.expYear && <p className="error red-text">{errors.expYear}</p>}
              </div>
              <div className="inputBox">
                <span>CVV:</span>
                <input
                  type="text"
                  name="cvv"
                  placeholder="123"
                  value={formData.cvv}
                  onChange={handleInputChange}
                />
                {errors.cvv && <p className="error red-text">{errors.cvv}</p>}
              </div>
            </div>
          </div>
          {/* errors for formatting for api post */}
          {errorMsg != null ?  <p className="error red-text"> {errorMsg}</p> : "" }
        </div>
        <input type="submit" value="Place Order" className="submit-btn" />
      </form>
    </div>
    </>
  );
  
}

export default CheckoutPage;
