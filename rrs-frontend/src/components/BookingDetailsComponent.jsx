import {React, useState, useEffect} from 'react'
import { Location, useLocation } from 'react-router';
import { Col, Container, Row, Table } from 'reactstrap';
import axios from 'axios';
const BookingDetailsComponent = () => {
    const location = useLocation();
    const { hotels } = location.state;
    console.log(hotels)
    const hotel_id = hotels.hotel_id
    console.log(hotel_id)

    const [bookings, setBookings] = useState([]);

    let bookingNumber=1;
    useEffect(() => {
            // Fetch booking data using the hotel_id
            axios.get(`http://localhost:8080/api/bookings/${hotel_id}`)
              .then((response) => {
                setBookings(response.data);
                console.log(response);
              })
              .catch((error) => {
                console.error('Error fetching bookings:', error);
              });
          }, [hotel_id]);

  return (
   <>
 
    <Container className='text-center'>
    <h3>Booking Status</h3>
    <Row>
        <Col sm={{size:6, offset:3}}>
    <h3 className='text-warning'>Booking Details for {hotels.hotelName}</h3>

       <Table>
        <thead>
          <tr>
           <th>Booking ID</th>
            <th>Booking Date</th>
            <th>Booking Time</th>
            <th>Booking Name</th>
            {/* Add more table headers if needed */}
          </tr>
       </thead>
        <tbody>
          {bookings.map((booking) => (
            <tr key={booking.booking_id}>
              {/* <td>{booking.booking_id}</td> */}
              <td>{bookingNumber++}</td>
              <td>{booking.booking_date}</td>
              <td>{booking.booking_time}</td>
              <td>{booking.user.fname} {booking.user.lname}</td>

              {/* Add more table cells to display other booking details */}
            </tr>
          ))}
        </tbody>
      </Table>
      </Col>
      </Row>
      </Container>
   </>
  )
}

export default BookingDetailsComponent
