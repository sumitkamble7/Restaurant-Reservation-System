import React from "react";
import Base from "../components/Base";
import "../CSS/Cssstyle.css";
import aboutImage from "../Images/AboutUsBackground.jpg"; // Same image as the homepage
import smallImage from "../Images/AboutusTable.jpg"; // Different small image
const About = () => {
  const sectionStyle = {
    backgroundImage: `url(${aboutImage})`,
    backgroundSize: "cover",
    backgroundPosition: "center",
    height: "100vh", // Fullscreen height
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    color: "#fff", // Text color on top of the image
  };

  const smallImageWrapperStyle = {
    display: "inline-block",
    animation: "bounce 2s infinite", // Added animation property
  };

  const smallImageStyle = {
    maxWidth: "100%", // Make sure the image fits within its container
    height: "auto", // Maintain aspect ratio
    borderRadius: "10px",
    objectFit: "cover",
  };
  return (
    <div>
      <Base />
      <section id="about" style={sectionStyle}>
        <div className="container">
          <div className="row">
            <div className="col-md-6">
              <div style={smallImageWrapperStyle}>
                <img
                  src={smallImage} // Corrected the image source
                  alt="About Us"
                  style={smallImageStyle}
                />
              </div>
            </div>
            <div className="col-md-6">
              <h2 id="rss2" className="text-center mb-4">About Us</h2>
              <p id="para1">
                At Restorent Reservation System, we believe that dining is more than just food –
                it's an experience. Our passion for culinary excellence drives us to
                craft dishes that ignite your senses and create unforgettable memories.
                With a dedication to quality and innovation, we invite you to join us
                on a journey of flavors and stories.
              </p>
              <p id="para2">
                Whether you're looking for an intimate dinner or a celebration with
                friends, our team is committed to providing you with exceptional
                service and an unparalleled dining experience. Discover the art of
                taste at Restorent Reservation System.
              </p>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}



export default About;
