import React from 'react';
import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import SearchResults from '../pages/search_results';

test('it displays the search heading', () => {
  render(<BrowserRouter><SearchResults /></BrowserRouter>);

  // Check if the text "Products in Category:" is present
  const categoryText = screen.getByText('Results for', { exact: false });
  expect(categoryText).toBeInTheDocument();
});