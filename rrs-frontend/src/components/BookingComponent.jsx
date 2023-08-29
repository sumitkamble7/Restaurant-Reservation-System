
import React, { useState } from "react";
import { Container, Form, FormGroup, Label, Input, Button } from "reactstrap";
import { useLocation, Link, useNavigate } from "react-router-dom";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import { toast } from "react-toastify";

const BookingComponent = () => {
  const location = useLocation();
   
  const navigate = useNavigate();

  const { hotel } = location.state;

  const [bookingDate, setBookingDate] = useState("");
  const [bookingTime, setBookingTime] = useState("");

  const hotelId = hotel.hotel_id; // Directly use hotel_id

  const userData = JSON.parse(localStorage.getItem("userData"));
  console.log("cxczzxcxzcxzxccxcxzx");
  console.log(userData);
  const userId = userData.data.user_id;
  console.log("USER ID and Hotel ID ..............");
  console.log(userId);
  console.log(hotelId);

  const handleBookingSubmit = async (e) => {
    e.preventDefault();

    const bookingData = {
      booking_date: bookingDate, 
      booking_time: bookingTime,
      hotel: hotel,
      user: userData.data,
    };

    try {
      // Send the booking data to the backend
      console.log(bookingData);
      // console.log(bookingData.hotel_id);
      // console.log(bookingData.user_id);
      const response = await axios.post(
        "http://localhost:8080/api/bookings",
        bookingData
      );
      console.log("Booking successful:", response.data);
      // Redirect the user to the booking success page using Link
      // Redirect the user to the dashboard page after showing the toast
      navigate("/dashboard");
      // Assuming /booking-success is the correct route for the success page
      toast.success("Booking Successful!");
    } catch (error) {
      console.error("Error booking table:", error);
      // Handle booking error and provide feedback to the user
    }
  };

  return (
    <Container>
      <h2>Booking for {hotel.hotelName}</h2>
      <Form onSubmit={handleBookingSubmit}>
        <FormGroup>
          <Label>Booking Date:</Label>
          <Input
            type="date"
            value={bookingDate}
            onChange={(e) => setBookingDate(e.target.value)}
            required
          />
        </FormGroup>
        <FormGroup>
          <Label>Booking Time:</Label>
          <Input
            type="time"
            value={bookingTime}
            onChange={(e) => setBookingTime(e.target.value)}
            required
          />
        </FormGroup>
        <Button type="submit" color="primary">
          Book Table
        </Button>
      </Form>
      {/* Use Link to navigate to the booking success page */}
      <Link to="/booking-success">Go to Booking Success Page</Link>
    </Container>
  );
};

export default BookingComponent;
