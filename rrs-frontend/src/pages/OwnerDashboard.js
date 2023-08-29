import React from "react";
import {useNavigate } from "react-router-dom";
import Base from "../components/Base";
import { useState, useEffect } from "react";
import { Button } from "reactstrap";
import axios from "axios";
const OwnerDashboard = () => {
const navigate = useNavigate();
  console.log(localStorage);
  const ownerData = JSON.parse(localStorage.getItem("OwnerData"));
  console.log("Data......");
  console.log(ownerData);
  const owner_id = ownerData.data.owner_id;
  console.log(owner_id);

  // ...

  const [hotels, setHotels] = useState([]);
  console.log("hotels available", hotels)
  const hotel_id=hotels.hotel_id
  
  console.log(hotel_id)

  useEffect(() => {
    // Fetch data using the owner_id
    axios.get(`http://localhost:8080/api/hotels/${owner_id}`)
      .then((response) => {
        setHotels(response.data);
        
        // console.log("response...........",response.data);
      })
      .catch((error) => {
        console.error('Error fetching hotels:', error);
      });
  }, [owner_id]);

  const handleMenuClick = (hotel) => {
    // Navigate to the MenuComponent and pass the hotel data
    navigate("/bookingdetails", { state: { hotels } });
  };
  
  return (
    <>
     
      
     <Base />
      <h3>Welcome : {hotels.hotelName}</h3>
      <Button
                color="primary"
                onClick={() => handleMenuClick(hotels)} // Pass the hotel data
              >
                Check Bookings
              </Button>
    </>
  );
};

export default OwnerDashboard;
