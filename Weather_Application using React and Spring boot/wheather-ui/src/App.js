import React from 'react'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './Home';
import Weather from './Weather';


function App() {


  return (
    
      <BrowserRouter>
      <div className='App'>
      <Routes>
        <Route index element={<Home />} />
        <Route path='weather' element={<Weather />} />
      </Routes>
      </div>
    </BrowserRouter>
      
    
  )
}

export default App