import React from 'react'
import HotelOwnerLogin from '../components/HotelOwnerLogin';
import Base from "../components/Base";
import { ToastContainer } from "react-toastify";

function OwnerLogin() {
    return (
        <>
        <Base />
          <h3>Owner Login Page</h3>
          <HotelOwnerLogin/>
          <ToastContainer />
      </>
    )
}

export default OwnerLogin
