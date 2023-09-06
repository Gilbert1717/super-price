import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Footer from './elements/footer';
import Categories from './pages/categories';
import SearchResults from './pages/search_results';

import Header from './elements/header';
import './App.css';

function App() {
  return (
    <div className="App">
      <div className="background">
          <BrowserRouter>
          <Header />
            <Routes>
              <Route path="/" element={<Categories />} />
              <Route path="/search-results" element={<SearchResults />} />
            </Routes>
          </BrowserRouter>
      </div>
      <Footer />
    </div>
  );
}

export default App;
