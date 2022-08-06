import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from '../node_modules/react-router-dom/index';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>,
);