import React from 'react';
import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import OrdersPage from '../pages/OrdersPage';
import { CartProvider } from '../pages/CartContext';

test('it renders orders page', () => {
    render(<BrowserRouter><CartProvider><OrdersPage /></CartProvider></BrowserRouter>);
    expect(screen.getByText('No Orders to Display.')).toBeInTheDocument();
});