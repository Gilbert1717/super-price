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

    // Calculate the shipping cost based on the delivery type
    const shippingCost = deliveryType === 'Express' ? 30 : 10;

    // Calculate the subtotal (total price of items) and the final total (subtotal + shipping)
    const subtotal = baseTotal;
    const total = subtotal + shippingCost;

    // Handle the change in delivery type
    function handleDeliveryTypeChange(event) {
        setDeliveryType(event.target.value);
    }

    // Check if the cart is empty
    const isCartEmpty = cartState.items.length === 0;

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

                <p className="cart-total-price">Subtotal: ${subtotal.toFixed(2)}</p>
                <p className="cart-total-price">Shipping: ${shippingCost.toFixed(2)}</p>
                <p className="cart-total-price">Total: ${total.toFixed(2)}</p>
            </div>
            {!isCartEmpty && (
                <Link to="/checkout">
                    <button className="cart-checkout-button">Checkout</button>
                </Link>
            )}
            {isCartEmpty && <p className="cart-checkout-error">Your cart is currently empty.</p>}
        </div>
    );
}

export default CartPage;
