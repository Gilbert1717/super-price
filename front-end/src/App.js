import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Footer from './elements/footer';
import Categories from './pages/categories';
import SearchResults from './pages/search_results';
import CategoryResults from './pages/category_result';
import ComparePrices from './pages/compare_prices';
import Header from './elements/header';
import CartPage from './pages/CartPage'; // Import the CartPage component
import { CartProvider } from './pages/CartContext'; // Import the CartProvider
import './App.css';

function App() {
  return (
    <div className="App">
      <div className="background">
          <CartProvider>
              <BrowserRouter>
              <Header />
                <Routes>
                  <Route path="/" element={<Categories />} />
                  <Route path="/search-results/:query" element={<SearchResults />} />
                  <Route path="/category-results/:query" element={<CategoryResults />} />
                  <Route path="/compare-prices/:query" element={<ComparePrices />} />
                    <Route path="/cart" element={<CartPage />} /> {/* Add the route for the cart page */}
                </Routes>
              </BrowserRouter>
          </CartProvider>
      </div>
      <Footer />
    </div>
  );
}

export default App;
