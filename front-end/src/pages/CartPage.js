import React from 'react';
import { useCart, REMOVE_FROM_CART } from './CartContext';
import {Link} from "react-router-dom";

function CartPage() {
    const { cartState, dispatch } = useCart();

    // Function to remove an item from the cart
    function removeFromCart(index) {
        dispatch({ type: REMOVE_FROM_CART, payload: index });
    }

    // Calculate the total price of items in the cart
    const total = cartState.items.reduce((acc, item) => acc + item.price, 0);

    return (
        <div className="cart-page">
            <h2>Your Cart</h2>
            <ul>
                {cartState.items.map((item, index) => (
                    <li key={index}>
                        {item.name} - {item.store} - ${item.price}
                        <button onClick={() => removeFromCart(index)}>Remove</button>
                    </li>
                ))}
            </ul>
            <p>Total Price: ${total.toFixed(2)}</p> {/* Display the total price */}
            <Link to="/checkout"> {/* Use Link for navigation */}
                <button>Checkout</button>
            </Link>
        </div>
    );
}

export default CartPage;
