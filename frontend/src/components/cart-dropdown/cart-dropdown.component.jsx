import "./cart-dropdown.styles.scss";
import Button from "../button/button.component";
import { CartContext } from "../../contexts/cart.context";
import { useContext } from "react";
import CartItem from "../cart-item/cart-item.component";
import { useNavigate } from "react-router-dom";

const toggledStyles = {
  container: {
    visibility: "visible",
    width: "240px",
    height: "340px",
    transitionDuration: "0.5s",
  },
  items: {
    height: "240px",
    width: "auto",
  },
  button: {
    marginRight: "auto",
    height: "50px",
    fontSize: "15px",
  },
};

export default function CartDropdown() {
  const { isCartOpen, cartItems } = useContext(CartContext);
  const navigate = useNavigate();

  const goToCheckoutHandler = () => {
    navigate('/checkout');
  }

  return (
    <div
      className="cart-dropdown-container"
      style={isCartOpen ? toggledStyles.container : null}
    >
      <div
        className="cart-items"
        style={isCartOpen ? toggledStyles.items : null}
      >
        {cartItems
          ? cartItems.map((item) => <CartItem key={item.id} cartItem={item} />)
          : null}
      </div>
        <Button style={isCartOpen ? toggledStyles.button : null} onClick={goToCheckoutHandler}>
          GO TO CHECKOUT
        </Button>
    </div>
  );
}
