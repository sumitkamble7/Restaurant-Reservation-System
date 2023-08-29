// import React, { useState, useEffect } from "react";
// import axios from "axios";
// import { useNavigate } from "react-router-dom";
// import {
//   Card,
//   CardBody,
//   CardTitle,
//   CardSubtitle,
//   Button,
//   Container,
//   Row,
//   Col,
// } from "reactstrap";

// const HotelComponent = () => {
//   const [hotels, setHotels] = useState([]);

//   useEffect(() => {
//     // Fetch hotels from the backend when the component mounts
//     // api/hotels
//     axios
//       .get("http://localhost:8080/api/hotels")
//       .then((response) => {
//         setHotels(response.data);
//         console.log(response);
//       })
//       .catch((error) => {
//         console.error("Error fetching hotels:", error);
//       });
//   }, []);
  
  
//   return (
//     <Container>
//       <Row>
//         {hotels.map((hotel) => (
//           <Col key={hotel.id} sm="3">
//             <Card>
//               <CardBody>
//                 <CardTitle tag="h5">{hotel.hotelName}</CardTitle>
//                 <CardSubtitle>{hotel.address}</CardSubtitle>
//                 <p>Ratings: {hotel.ratings}</p>
//               </CardBody>
              
//             </Card>
//           </Col>
//         ))}
//       </Row>
//     </Container>
//   );
// };

// export default HotelComponent;


import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import {
  Card,
  CardBody,
  CardTitle,
  CardSubtitle,
  Button,
  Container,
  Row,
  Col,
} from "reactstrap";

const HotelComponent = () => {
  const [hotels, setHotels] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/hotels")
      .then((response) => {
        setHotels(response.data);
        console.log(response);
      })
      .catch((error) => {
        console.error("Error fetching hotels:", error);
      });
  }, []);

  const handleMenuClick = (hotel) => {
    navigate("/menu", { state: { hotel } });
  };

  return (
    <Container>
      <Row>
        {hotels.map((hotel) => (
          <Col key={hotel.id} sm="3">
            <Card>
              <CardBody>
                {hotel.imageName && (
                  
                  <img
                          src={require(`../Images/${hotel.imageName}`)}
                          alt="Item"
                          style={{ height: "200px", maxWidth: "100%", objectFit: "cover" }}
                    />

                )}
                <CardTitle tag="h5">{hotel.hotelName}</CardTitle>
                <CardSubtitle>{hotel.address}</CardSubtitle>
                <p>Ratings: {hotel.ratings}</p>
              </CardBody>
              <Button
                color="primary"
                onClick={() => handleMenuClick(hotel)}
              >
                Click Here
              </Button>
            </Card>
          </Col>
        ))}
      </Row>
    </Container>
  );
};

export default HotelComponent;
