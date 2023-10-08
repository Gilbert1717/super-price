import React from 'react';
import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import OrderConfirmation from '../pages/OrderConfirmation';
import { CartProvider } from '../pages/CartContext';

test('it renders order confirmation page', () => {
    render(<BrowserRouter><CartProvider><OrderConfirmation /></CartProvider></BrowserRouter>);
    expect(screen.getByText('Order Confirmed!')).toBeInTheDocument();
    expect(screen.getByText('Return to Homepage')).toBeInTheDocument();
});