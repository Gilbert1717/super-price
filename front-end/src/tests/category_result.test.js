import React from 'react';
import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import CategoryResults from '../pages/category_result';

test('it displays the category heading', () => {
render(<BrowserRouter><CategoryResults /></BrowserRouter>);

// Check if the text "Products in Category:" is present
const categoryText = screen.getByText('Products in Category:');
expect(categoryText).toBeInTheDocument();
});