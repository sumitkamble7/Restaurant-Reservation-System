import React from "react";
import Base from "../components/Base";
import UserLogin from "../components/UserLogin";
import { ToastContainer } from "react-toastify";

const Login = () => {
  return (
    <>
      <Base />
        <h3> User Login Page</h3>
        <UserLogin />
        <ToastContainer />
    </>
  );
};

export default Login;
