
import React from "react";
import { Navbar, NavbarBrand, Nav, NavItem, NavLink } from "reactstrap";
import { NavLink as ReactLink } from "react-router-dom";

const CustomizedNavBar = () => {
  // Check if the user is authenticated (you can adjust this condition as per your data structure)
  const isAuthenticated = localStorage.getItem('userData') !== null;
  const Authenticated = localStorage.getItem('OwnerData') !== null;
  
   const handleOwnerLogout=()=>{
    localStorage.removeItem('OwnerData');
    window.location.href = "/ownerlogin";
   };
  const handleLogout = () => {
    // Clear user data from local storage and perform the logout action
    localStorage.removeItem('userData');
    // You can add more logout-related logic here if needed

    // Redirect to the login page or any other appropriate action
    window.location.href = "/login"; // Redirect to the login page
  };

  return (
    <Navbar color="dark" dark expand="md">
      <NavbarBrand tag={ReactLink} to="/">Restaurant Management</NavbarBrand>
      <Nav className="ml-auto" navbar>
        <NavItem>
          <NavLink tag={ReactLink} to="/">Home</NavLink>
        </NavItem>
        <NavItem>
          <NavLink tag={ReactLink} to="/about">About</NavLink>
        </NavItem>
 {!Authenticated ? (
   !isAuthenticated ? (
       <>
      <NavItem>
        <NavLink tag={ReactLink} to="/login">Login</NavLink>
      </NavItem>
      <NavItem>
        <NavLink tag={ReactLink} to="/ownerlogin">HotelOwnerLogin</NavLink>
      </NavItem>
      <NavItem>
        <NavLink tag={ReactLink} to="/signup">Signup</NavLink>
      </NavItem>
    </>
  ) : (
    <>
    <NavItem>
      <NavLink onClick={handleLogout}>Logout</NavLink>
    </NavItem>
  
      <NavItem>
        <NavLink tag={ReactLink} to="/dashboard">dashboard</NavLink>
      </NavItem>
      </>
    
  )
) : (
  <NavItem>
    <NavLink onClick={handleOwnerLogout}>Logout</NavLink>
  </NavItem>
)}

          
        {/* <NavItem>
          <NavLink tag={ReactLink} to="/contact">Contact Us</NavLink>
        </NavItem> */}
      </Nav>
    </Navbar>
  );
};

export default CustomizedNavBar;


