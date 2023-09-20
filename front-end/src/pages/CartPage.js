import React, { useState } from 'react';
import { useCart, REMOVE_FROM_CART } from './CartContext';
import { Link } from 'react-router-dom';

function CartPage() {
    const { cartState, dispatch } = useCart();
    const [deliveryType, setDeliveryType] = useState('Regular'); // Default delivery type is 'Regular'

    // Function to remove an item from the cart
    function removeFromCart(index) {
        dispatch({ type: REMOVE_FROM_CART, payload: index });
    }

    // Calculate the total price of items in the cart
    const baseTotal = cartState.items.reduce((acc, item) => acc + item.price, 0);

    // Calculate the total price with the delivery cost
    const total = deliveryType === 'Express' ? baseTotal + 10 : baseTotal;

    // Handle the change in delivery type
    function handleDeliveryTypeChange(event) {
        setDeliveryType(event.target.value);
    }

    return (
        <div className="cartPage-container">
            <h2 className="cartPage-Heading">Your Cart</h2>
            <div className="cart-items">
                {cartState.items.map((item, index) => (
                    <div className="cart-item" key={index}>
                        <div className="cart-product-name">{item.name}</div>
                        <div className="cart-store-name">{item.store}</div>
                        <div className="cart-store-address">{item.address}</div>
                        <p className="cart-price">{"$" + item.price.toFixed(2)}</p>
                        <button className="cart-remove-button" onClick={() => removeFromCart(index)}>
                            Remove
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
                />

                <label htmlFor="userDate" className="delivery-label">
                    Enter a delivery date:
                </label>
                <input type="date" id="userDate" className="delivery-input" />

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

                <p className="cart-total-price">Total Price: ${total.toFixed(2)}</p>
            </div>
            <Link to="/checkout">
                <button className="cart-checkout-button">Checkout</button>
            </Link>
        </div>
    );
}

export default CartPage;
