import React from 'react';
import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom'
import Categories from '../pages/categories';

test('it renders all categories', () => {
  render(<BrowserRouter><Categories /></BrowserRouter>);

  // Except all categories to show up
  expect(screen.getByText('Accessories')).toBeInTheDocument();
  expect(screen.getByText('Appliances')).toBeInTheDocument();
  expect(screen.getByText('Clothing')).toBeInTheDocument();
  expect(screen.getByText('Electronics')).toBeInTheDocument();
  expect(screen.getByText('Sports')).toBeInTheDocument();
  expect(screen.getByText('Dairy')).toBeInTheDocument();
  expect(screen.getByText('Meats')).toBeInTheDocument();
  expect(screen.getByText('Fish')).toBeInTheDocument();
  expect(screen.getByText('Fruit')).toBeInTheDocument();
  expect(screen.getByText('Bakery')).toBeInTheDocument();
  expect(screen.getByText('Vegetables')).toBeInTheDocument();
});