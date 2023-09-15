import React from 'react';
import { useCart } from './CartContext'; // Import the CartContext

function CartPage() {
    const { cartState } = useCart();

    return (
        <div className="cart-page">
            <h2>Your Cart</h2>
            <ul>
                {cartState.items.map((item, index) => (
                    <li key={index}>
                        {item.name} - {item.store} - ${item.price}
                    </li>
                ))}
            </ul>
            {/* Add additional cart functionality, e.g., total price, checkout button, etc. */}
        </div>
    );
}

export default CartPage;