import React, { useState } from 'react';
import { useCart, REMOVE_FROM_CART } from './CartContext';
import CheckoutPage from './CheckoutPage'; 


function CartPage() {
    const { cartState, dispatch } = useCart();
    const [deliveryType, setDeliveryType] = useState('Regular');
    const [userTime, setUserTime] = useState("");
    const [userDate, setUserDate] = useState("");
    const [showPayment, setShowPayment] = useState(false);
    const [showCart, setShowCart] = useState(true);

    // Function to remove an item from the cart
    function removeFromCart(productId, store) {
        dispatch({ type: REMOVE_FROM_CART, payload: {barcode: productId, store: store}});
    }

    // Group items by name, store, address, and price, and calculate quantity for each group
    const groupedItems = cartState.items.reduce((groups, item) => {
        const key = item.name + item.store + item.address + item.price;
        if (!groups[key]) {
            groups[key] = { ...item, quantity: 0 };
        }
        groups[key].quantity += 1;
        return groups;
    }, {});


    // Calculate the total price of items in the cart
    const baseTotal = Object.values(groupedItems).reduce((acc, item) => acc + item.price * item.quantity, 0);

    // Calculate the shipping cost based on the delivery type
    const shippingCost = deliveryType === 'Express' ? 30 : 10;

    // Calculate the subtotal (total price of items) and the final total (subtotal + shipping)
    const subtotal = baseTotal;
    const total = subtotal + shippingCost;

    // Handle the change in delivery type
    function handleDeliveryTypeChange(event) {
        setDeliveryType(event.target.value);
    }

    // Handle the change in delivery time
    function handleUserTimeChange(event) {
        setUserTime(event.target.value);
    }

    // Handle the change in delivery date
    function handleUserDateChange(event) {
        setUserDate(event.target.value);
    }

    function checkOut(){
        setShowPayment(true);
        setShowCart(false);
    }

    // Check if the cart is empty
    const isCartEmpty = Object.keys(groupedItems).length === 0;

    return (
        <>
        <div className="cartPage-container">
            {isCartEmpty ? ( <>
                <h2 className="cartPage-Heading">Your Cart</h2>
                <p className="cart-checkout-error">Your cart is empty.</p>
            </>
            ) : !showCart ? "" :(
                <>  <h2 className="cartPage-Heading">Your Cart</h2>
                    <div className="cart-items">
                        {Object.values(groupedItems).map((item, index) => (
                            <div className="cart-item" key={index}>
                                <div className="cart-product-name">{item.name}</div>
                                <div className="cart-store-name">{item.store}</div>
                                <div className="cart-store-address">{item.address}</div>
                                <p className="cart-price">
                                    ${item.price.toFixed(2)} <br /> x {item.quantity}
                                </p>
                                <button className="cart-remove-button" onClick={() => removeFromCart(item.barcode, item.store)}>
                                    Remove All
                                </button>
                            </div>
                        ))}
                    </div>
                    <div className="delivery-and-price">
                        <label htmlFor="userTime" className="delivery-label">
                            Enter a delivery time:
                        </label>
                        <input
                            type="time"
                            id="userTime"
                            name="userTime"
                            min="00:00"
                            max="23:55"
                            step="300"
                            className="delivery-input"
                            value={userTime}
                            onChange={handleUserTimeChange}
                        />

                        <label htmlFor="userDate" className="delivery-label">
                            Enter a delivery date:
                        </label>
                        <input
                            type="date"
                            id="userDate"
                            className="delivery-input"
                            value={userDate}
                            onChange={handleUserDateChange}
                            placeholder="Select a date" 
                        />

                        <label htmlFor="deliveryType" className="delivery-label">
                            Choose a Delivery Type:
                        </label>
                        <select
                            name="deliveryType"
                            id="dType"
                            className="delivery-input"
                            value={deliveryType}
                            onChange={handleDeliveryTypeChange}
                        >
                            <option value="Regular">Regular</option>
                            <option value="Express">Express</option>
                        </select>

                        <p className="cart-total-price">Subtotal: ${subtotal.toFixed(2)}</p>
                        <p className="cart-total-price">Shipping: ${shippingCost.toFixed(2)}</p>
                        <p className="cart-total-price">Total: ${total.toFixed(2)}</p>
                    </div>
                    {userTime && userDate ? (
                        <button className="cart-checkout-button" onClick={checkOut}>Checkout</button>
                    ) : (
                        <p className="cart-checkout-error">Please enter delivery details.</p>
                    )}
                
                </>
            )}
        {showPayment ? <CheckoutPage 
                            deliveryType={deliveryType} 
                            deliverTime={userDate + " " + userTime}
                        /> : ""}
        </div>
        </>
    );
}

export default CartPage;
