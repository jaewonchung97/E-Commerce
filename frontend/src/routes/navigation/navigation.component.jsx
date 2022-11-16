import "./navigation.styles.scss";

import { useContext } from "react";
import { Outlet, Link } from "react-router-dom";

import { ReactComponent as CrwnLogo } from "../../assets/crown.svg";

import CartIcon from "../../components/cart-icon/cart-icon.component";
import CartDropdown from "../../components/cart-dropdown/cart-dropdown.component";

import { CartContext } from "../../contexts/cart.context";

export default function Navigation(params) {
  const { setIsCartOpen } = useContext(CartContext);

  return (
    <>
      <div className="navigation">
        <Link className="logo-container" to="/">
          <CrwnLogo className="logo" />
        </Link>
        <div className="nav-links-container">
          <Link className="nav-link" to="/shop/all">
            SHOP
          </Link>
          <CartIcon
y            onClick={() => {
              setIsCartOpen((prev) => !prev);
            }}
          />
        </div>
        <CartDropdown />
      </div>
      <Outlet />
    </>
  );
}
