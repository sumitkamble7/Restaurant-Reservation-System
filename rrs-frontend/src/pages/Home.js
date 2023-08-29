import React from 'react'
import Base from '../components/Base';
import "../CSS/Cssstyle.css";
import backgroundImg from "../Images/tablewallpaper.jpg";
const Home = () => {
  
    const sectionStyle = {
      backgroundImage: `url(${backgroundImg})`,
      backgroundSize: "cover",
      backgroundPosition: "center",
      height: "100vh",
      display: "flex",
      alignItems: "center",
      justifyContent: "center",
      color: "#000000", // Change text color to dark (#000000 is black)
    };
  
    return (
      <div>
        <Base />
        <section id="header" style={sectionStyle}>
          <div className="container">
            <div className="row">
              <div className="col-md-6">
                <h1 id="rss">
                  Restaurant Reservation System<br />
                  <strong style={{ color: "skyblue" }}>Cdac-Project</strong>
                </h1>
                <h2 id="rss2" className="my-3 text-white">
                "Dine with Elegance and Flavor, Book Your Table Today!"
                </h2>
            
              </div>
              <div className="col-md-6">
                {/* Leave this empty or add content if needed */}
              </div>
            </div>
          </div>
        </section>
      </div>
    );
}

export default Home