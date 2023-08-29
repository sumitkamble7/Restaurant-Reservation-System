import React, { useState } from 'react';
import axios from 'axios';
import { Form, Label, Input, Button, Container, Row, Col } from 'reactstrap';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router';
const HotelOwnerLogin = () => {

  const navigate = useNavigate();

  const initialLoginForm = {
    email: '',
    password: '',
  };

  const [loginForm, setLoginForm] = useState(initialLoginForm);
  const [errorMessage, setErrorMessage] = useState('');

  const handleChange = (event) => {
    const { name, value } = event.target;
    setLoginForm((prevForm) => ({
      ...prevForm,
      [name]: value,
    }));
  };

  const handleLogin = (event) => {
    event.preventDefault();

    // Send login data to the backend
    ///users/login
    axios.post('http://localhost:8080/api/owners/login', loginForm)
      .then((response) => {
        toast.success("Login successful!")
        console.log('Login successful!', response.data);
       
        localStorage.setItem('OwnerData', JSON.stringify(response));
        
        
        // navigate("/ownerdashboard")
        navigate("/ownerdashboard", { state: { ownerData: response.data } });
        // You might want to perForm additional actions after successful login
      })
      .catch((error) => {
        // Handle login error
        toast.error("Login failed!")
        console.error('Login failed!', error);
        // setErrorMessage('Invalid email or password.');
      });
  };

  const reset = ()=>{
    setLoginForm(initialLoginForm)
  }

  return (
    <Container>
      <Row>
        <Col sm={{size:6,offset:3}}>
        <div>
      <h2>Login to Restaurant Reservation</h2>
      <Form onSubmit={handleLogin}>
        <div>
          <Label>Email:</Label>
          <Input
            type="email"
            name="email"
            value={loginForm.email}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <Label>Password:</Label>
          <Input
            type="password"
            name="password"
            value={loginForm.password}
            onChange={handleChange}
            required
          />
        </div>
        <Button type="submit" className='m-3'>Login</Button>
        {errorMessage && <p className="error">{errorMessage}</p>}
        <Button onClick={reset} className='m-3'>Reset</Button>
      </Form>
    </div>
        </Col>
      </Row>
    </Container>
  );
}

export default HotelOwnerLogin;
