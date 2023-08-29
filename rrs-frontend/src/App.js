import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-toastify/dist/ReactToastify.css';
import { BrowserRouter } from 'react-router-dom';
import Base from './components/Base';
import Signup from './pages/Signup';
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';
import Menu from './pages/Menu';
import { Route, Router, Routes } from 'react-router';
import Booking from './pages/Booking';
import { ToastContainer } from 'react-toastify';
import Home from './pages/Home'
import About from './pages/About';
import OwnerLogin from './pages/OwnerLogin';
import OwnerDashboard from './pages/OwnerDashboard';
import Contact from './pages/Contact';
import BookingDetails from './pages/BookingDetails';
function App() {
  return (
    <>
    
  
  <BrowserRouter>
  <ToastContainer />
    <Routes>
      <Route path="/" element={<Home />}></Route>
      <Route path="/about" element={<About />}></Route>
      <Route path="/signup" element={<Signup />}></Route>
      <Route path="/login" element={<Login />}></Route>
      <Route path="/dashboard" element={<Dashboard />}></Route>
      <Route path="/menu" element={<Menu />}></Route>
      <Route path="/booking" element={<Booking />}></Route>
      <Route path="/ownerlogin" element={<OwnerLogin/>}></Route>
      <Route path="/ownerdashboard" element={<OwnerDashboard/>}></Route>
      <Route path="/contact" element={<Contact/>}></Route>
      <Route path="/bookingdetails" element={<BookingDetails />}/>

     
    </Routes>
  </BrowserRouter>
    </>
  );
}

export default App;
