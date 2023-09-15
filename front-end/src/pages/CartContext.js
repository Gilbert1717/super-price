// Create a CartContext.js file

import { createContext, useContext, useReducer } from 'react';

// Define an initial state for the cart
const initialState = {
    items: [],
};

// Create a context
const CartContext = createContext();

// Define actions for adding/removing items from the cart
const ADD_TO_CART = 'ADD_TO_CART';
const REMOVE_FROM_CART = 'REMOVE_FROM_CART';

// Reducer function to update the cart state
function cartReducer(state, action) {
    switch (action.type) {
        case ADD_TO_CART:
            return {
                ...state,
                items: [...state.items, action.payload],
            };
        case REMOVE_FROM_CART:
            // Implement remove logic if needed
            return state;
        default:
            return state;
    }
}

// CartProvider component to wrap your app
function CartProvider({ children }) {
    const [cartState, dispatch] = useReducer(cartReducer, initialState);

    return (
        <CartContext.Provider value={{ cartState, dispatch }}>
            {children}
        </CartContext.Provider>
    );
}

// Custom hook to access the cart context
function useCart() {
    const context = useContext(CartContext);
    if (!context) {
        throw new Error('useCart must be used within a CartProvider');
    }
    return context;
}

export { CartProvider, useCart, ADD_TO_CART };
