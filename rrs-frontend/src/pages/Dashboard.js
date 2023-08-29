import React from 'react'
import Base from '../components/Base'
import HotelComponent from '../components/HotelComponent'
import { ToastContainer } from 'react-toastify'

const Dashboard = () => {
  return (
    <>
        <Base />
        <h3>Dashboard Page</h3>
        <HotelComponent />
        <ToastContainer />
    </>
  )
}

export default Dashboard