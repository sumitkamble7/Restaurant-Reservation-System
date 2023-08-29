import React from "react";
import Registration from "../components/Registration";
import { ToastContainer } from "react-toastify";
import Base from "../components/Base";

const Signup = () => {
  return (
    <>
    <Base />
      <h3>Signup page</h3>
      <Registration />
      <ToastContainer/>
      </>
  );
};

export default Signup;
