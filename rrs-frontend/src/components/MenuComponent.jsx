

import React, { useState, useEffect } from "react";
import { Container, Table, FormGroup, Label, Input, Button } from "reactstrap";
import { useLocation, Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";

const MenuComponent = () => {
  const location = useLocation();
  const { hotel } = location.state;
  const [menuItems, setMenuItems] = useState([]);
  const category_id = hotel.category.cat_id;
  const navigate = useNavigate(); // Initialize useNavigate
  const [selectedItems, setSelectedItems] = useState([]);
  const [subTotalPrice, setSubTotalPrice] = useState(0);

  const GST_RATE = 0.18; // 18% GST rate

  const handleCheckboxChange = (itemId, price) => {
    if (selectedItems.includes(itemId)) {
      setSelectedItems(selectedItems.filter((item) => item !== itemId));
    } else {
      setSelectedItems([...selectedItems, itemId]);
    }
  };

  useEffect(() => {
    // Fetch menu items based on the hotel's category_id
    if (category_id === 1) {
      // Assuming 1 is the category ID for veg menu
      axios
        .post("http://localhost:8080/api/veg-menu", hotel)
        .then((response) => {
          setMenuItems(response.data);
        })
        .catch((error) => {
          console.error("Error fetching menu items:", error);
        });
    } else if (category_id === 2) {
      // Assuming 2 is the category ID for non-veg menu
      axios
        .post("http://localhost:8080/api/non-veg-menu", hotel)
        .then((response) => {
          setMenuItems(response.data);
        })
        .catch((error) => {
          console.error("Error fetching menu items:", error);
        });
    }
  }, [category_id, hotel]);

  useEffect(() => {
    // Calculate subtotal price based on selected items
    let subtotal = selectedItems.reduce((acc, itemId) => {
      const selectedItem = menuItems.find((item) => item.m_id === itemId);
      return acc + selectedItem.price;
    }, 0);
    setSubTotalPrice(subtotal);
  }, [selectedItems, menuItems]);

  const calculateGST = (subTotal) => {
    return subTotal * GST_RATE;
  };

  const calculateTotalPrice = (subTotal) => {
    return subTotal + calculateGST(subTotal);
  };

  const handleMenuClick = (hotel) => {
    // Navigate to the MenuComponent and pass the hotel data
    navigate("/booking", { state: { hotel } });
  };

  console.log("Hotel Data Check")
  console.log(hotel);
  return (
    <Container>
      <Button
                color="primary"
                onClick={() => handleMenuClick(hotel)} // Pass the hotel data
              >
                Book Table
              </Button>
      <h2>Menu for {hotel.hotelName}</h2>
      {/* Instead of using history, use a Link or Button */}

      <Table>
        <thead>
          <tr>
            <th>Item Name</th>
            <th>Price</th>
            <th>Select</th>
          </tr>
        </thead>
        <tbody>
          {menuItems.map((menuItem) => (
            <tr key={menuItem.m_id}>
              <td>{menuItem.item}</td>
              <td>{menuItem.price}</td>
              <td>
                <input
                  type="checkbox"
                  onChange={() =>
                    handleCheckboxChange(menuItem.m_id, menuItem.price)
                  }
                  checked={selectedItems.includes(menuItem.m_id)}
                />
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
      <FormGroup>
        <Label>Subtotal:</Label>
        <Input type="text" value={subTotalPrice.toFixed(2)} disabled />
      </FormGroup>
      <FormGroup>
        <Label>18% GST:</Label>
        <Input
          type="text"
          value={calculateGST(subTotalPrice).toFixed(2)}
          disabled
        />
      </FormGroup>
      <FormGroup>
        <Label>Total Price (including GST):</Label>
        <Input
          type="text"
          value={calculateTotalPrice(subTotalPrice).toFixed(2)}
          disabled
        />
      </FormGroup>
    </Container>
  );
};

export default MenuComponent;
