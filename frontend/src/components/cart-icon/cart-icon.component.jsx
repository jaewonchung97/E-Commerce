import "./cart-icon.styles.scss";
import { ReactComponent as ShoppingIcon } from "../../assets/shopping-bag.svg";
import { CartContext } from "../../contexts/cart.context";
import { useContext } from "react";

export default function CartIcon({ ...otherprops }) {
  const { cartCount } = useContext(CartContext);
  return (
    <div className="cart-icon-container" {...otherprops}>
      <ShoppingIcon className="shopping-icon" />
      <span className="item-count">{cartCount}</span>
    </div>
  );
}
