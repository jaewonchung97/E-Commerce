import {CartContext} from "../../contexts/cart.context";
import {useContext} from "react";
import CheckoutItem from "../../components/checkout-item/checkout-item.component";
import "./checkout.styles.scss";
import Button from "../../components/button/button.component";
import axios from "axios";
import {useNavigate} from "react-router-dom";

export default function Checkout() {
    const {cartItems, cartTotal} = useContext(CartContext);
    const navigate = useNavigate();

    const checkoutHandler = () => {
        axios.post(
            "/checkout.do",
            cartItems
        ).catch(e => console.log(e));
        navigate('/');
        window.location.reload();
    }

    return (
        <div className="checkout-container">
            <div className="checkout-header">
                <div className="header-block">
                    <span>Product</span>
                </div>
                <div className="header-block">
                    <span>Description</span>
                </div>
                <div className="header-block">
                    <span>Quantity</span>
                </div>
                <div className="header-block">
                    <span>Price</span>
                </div>
                <div className="header-block">
                    <span>Remove</span>
                </div>
            </div>

            {cartItems.map((cartItem) => {
                return (<CheckoutItem key={cartItem.id} cartItem={cartItem}/>)
            })}
            <div className={"checkout-footer"}>
                <span className="total">Total: ${cartTotal}</span>
                <Button onClick={checkoutHandler}>Pay Now</Button>
            </div>
        </div>
    );
}
