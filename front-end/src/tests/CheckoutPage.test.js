import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom'
import CheckoutPage from '../pages/CheckoutPage';
import { CartProvider } from '../pages/CartContext';

test('it renders a payment form', () => {
  render(<BrowserRouter><CartProvider><CheckoutPage /></CartProvider></BrowserRouter>);

  // Find form elements by their labels and test their existence
  const fullNameInput = screen.getByText('Full Name:');
  const emailInput = screen.getByText('Email:');
  const cardNumberInput = screen.getByText("Credit Card Number:");
  const expiryDateInput = screen.getByText('Exp Year:');
  const cvvInput = screen.getByText('CVV:');
  const submitButton = screen.getByText('Place Order');

  expect(fullNameInput).toBeInTheDocument();
  expect(emailInput).toBeInTheDocument();
  expect(cardNumberInput).toBeInTheDocument();
  expect(expiryDateInput).toBeInTheDocument();
  expect(cvvInput).toBeInTheDocument();
  expect(submitButton).toBeInTheDocument();
});

test('it allows users to enter payment information', () => {
    render(<BrowserRouter><CartProvider><CheckoutPage /></CartProvider></BrowserRouter>);

    // Find form elements by their labels
    const cardNumberInput = screen.getByPlaceholderText('1111-2222-3333-4444');
    const expiryMonthInput = screen.getByPlaceholderText('January');
    const cvvInput = screen.getByPlaceholderText('123');
    const cityInput = screen.getByPlaceholderText('Melbourne');

    // Simulate user input
    fireEvent.change(cardNumberInput, { target: { value: '1234567890123456' } });
    fireEvent.change(expiryMonthInput, { target: { value: 'Febuary' } });
    fireEvent.change(cvvInput, { target: { value: '547' } });
    fireEvent.change(cityInput, { target: { value: 'Townsville' } });
    expect(cardNumberInput.value).toBe('1234567890123456');
    expect(expiryMonthInput.value).toBe('Febuary');
    expect(cvvInput.value).toBe('547');
    expect(cityInput.value).toBe('Townsville');
});

test('error message if empty field', () => {
    render(<BrowserRouter><CartProvider><CheckoutPage /></CartProvider></BrowserRouter>);

    // Find form elements by their labels
    const cardNumberInput = screen.getByPlaceholderText('1111-2222-3333-4444');
    const expiryMonthInput = screen.getByPlaceholderText('January');
    const cvvInput = screen.getByPlaceholderText('123');
    const cityInput = screen.getByPlaceholderText('Melbourne');
    const submitButton = screen.getByText('Place Order');

    // Simulate user input
    fireEvent.change(cardNumberInput, { target: { value: '1234567890123456' } });
    fireEvent.change(expiryMonthInput, { target: { value: 'Febuary' } });
    fireEvent.change(cvvInput, { target: { value: '547' } });
    fireEvent.change(cityInput, { target: { value: 'Townsville' } });
    fireEvent.click(submitButton);

    expect(screen.getByText("name on card is required")).toBeInTheDocument();
    expect(screen.getByText("exp year is required")).toBeInTheDocument();
});
