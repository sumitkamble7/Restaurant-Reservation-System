import React, { useState } from "react";
import axios from "axios";
import { Button, Col, Container, Form, Input, Label, Row } from "reactstrap";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";


const Registration = () => {
  const navigate = useNavigate(); // Initialize useNavigate
  const initialFormData = {
    fname: "",
    lname: "",
    email: "",
    password: "",
    phoneNumber: "",
  };

  const [formData, setFormData] = useState(initialFormData);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  // const handleSubmit = (event) => {
  //   event.preventDefault();

  //   // Send registration data to the backend
  //   axios
  //     .post("http://localhost:8080/api/users/register", formData)
  //     .then((response) => {
  //       toast.success("URegistration successful! ");
  //       console.log("Registration successful!", response.data);
  //       setFormData(initialFormData);
  //     })
  //     .catch((error) => {
  //       // Handle error or display an error message
  //       toast.error("Registration failed!");
  //       console.error("Registration failed!", error);
  //     });
  // };
  const handleSubmit = (event) => {
    event.preventDefault();
  
    // Send registration data to the backend
    axios
      .post("http://localhost:8080/api/users/register", formData)
      .then((response) => {
        toast.success("Registration successful!");
        console.log("Registration successful!", response.data);
        setFormData(initialFormData);
  
        // Navigate to the login page
       
        navigate("/login"); // Replace "/login" with the actual path to your login page
      })
      .catch((error) => {
        // Handle error or display an error message
        toast.error("Registration failed!");
        console.error("Registration failed!", error);
      });
  };
  

  const reset = () => {
    setFormData(initialFormData);
  };

  return (
    <Container>
      <Row>
        <Col sm={{ size: 6, offset: 3 }}>
          <div>
            <h2>Register for Restaurant Reservation</h2>
            <Form onSubmit={handleSubmit}>
              <div>
                <Label>First Name:</Label>
                <Input
                  type="text"
                  name="fname"
                  value={formData.fname}
                  onChange={handleChange}
                  required
                />
              </div>
              <div>
                <Label>Last Name:</Label>
                <Input
                  type="text"
                  name="lname"
                  value={formData.lname}
                  onChange={handleChange}
                  required
                />
              </div>
              <div>
                <Label>Email:</Label>
                <Input
                  type="email"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                  required
                />
              </div>
              <div>
                <Label>Password:</Label>
                <Input
                  type="password"
                  name="password"
                  value={formData.password}
                  onChange={handleChange}
                  required
                />
              </div>
              <div>
                <Label>Phone Number:</Label>
                <Input
                  type="tel"
                  name="phoneNumber"
                  value={formData.phoneNumber}
                  onChange={handleChange}
                  required
                />
              </div>
              <Button type="submit">Register</Button>
              <Button className="m-3" onClick={reset}>
                Reset
              </Button>
            </Form>
          </div>
        </Col>
      </Row>
    </Container>
  );
}

export default Registration;
