import { BrowserRouter, Routes, Route } from 'react-router-dom'

import Footer from './elements/footer';
import Popup from './elements/popup';
import Header from './elements/header';

import Categories from './pages/categories';
import SearchResults from './pages/search_results';
import CategoryResults from './pages/category_result';
import ComparePrices from './pages/compare_prices';


import OrdersPage from './pages/OrdersPage';

import CartPage from './pages/CartPage'; // Import the CartPage component
import { CartProvider } from './pages/CartContext'; // Import the CartProvider
import CheckoutPage from './pages/CheckoutPage'; // Import the CheckoutPage component

import './App.css';

function App() {

  const popUpTimer = 6 // in seconds

  return (
    <div className="App">
      <div className="background">
          <CartProvider>
              <BrowserRouter>
              {/* only show popup if x seconds passed */}
              {(Date.now() - localStorage.getItem('lastTimePopup') > popUpTimer * 1000) ? <Popup /> :""}
              <Header />
                <Routes>
                  <Route path="/" element={<Categories />} />
                  <Route path="/search-results/:query" element={<SearchResults />} />
                  <Route path="/category-results/:query" element={<CategoryResults />} />
                  <Route path="/compare-prices/:query" element={<ComparePrices />} />

                  <Route path="/orders" element={<OrdersPage />} />

                  <Route path="/cart" element={<CartPage />} /> {/* Add the route for the cart page */}
                  <Route path="/checkout" element={<CheckoutPage />} /> {/* Add the route for the checkout page */}

                </Routes>
              </BrowserRouter>
          </CartProvider>
      </div>
      <Footer />
    </div>
  );
}

export default App;
 