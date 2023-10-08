import React from 'react';
import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import CartPage from '../pages/CartPage';
import { CartProvider } from '../pages/CartContext';

test('it displays the cart page', () => {
    render(<BrowserRouter><CartProvider><CartPage /></CartProvider></BrowserRouter>);
    expect(screen.getByText('Your Cart')).toBeInTheDocument();
    expect(screen.getByText('Your cart is empty.')).toBeInTheDocument();
});