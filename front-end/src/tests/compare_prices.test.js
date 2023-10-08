import React from 'react';
import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom'
import ComparePrices from '../pages/compare_prices';
import { CartProvider } from '../pages/CartContext';


test('it renders compare prices page', () => {
  render(<BrowserRouter><CartProvider><ComparePrices /></CartProvider></BrowserRouter>);

  expect(screen.getByText('Compare Prices for')).toBeInTheDocument();

});