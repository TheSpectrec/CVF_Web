import { useState } from 'react'
import AppRoutes from './utils/routes/AppRoutes'
import { BrowserRouter } from 'react-router-dom';
import './App.css'

const App = () => {
  return (
    <BrowserRouter>
    <AppRoutes />
    </BrowserRouter>
    
  )
};

export default App;
