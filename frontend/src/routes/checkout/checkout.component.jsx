import {CartContext} from "../../contexts/cart.context";
import {useContext} from "react";
import CheckoutItem from "../../components/checkout-item/checkout-item.component";
import "./checkout.styles.scss";
import Button from "../../components/button/button.component";

export default function Checkout() {
    const {cartItems, cartTotal} = useContext(CartContext);

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
                    <span>Qunatity</span>
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
                <form action={"/checkout.do"} method={"post"}>
                    <Button type={"submit"}>Pay Now</Button>
                    <input type={"hidden"} name={"id"} value={cartItems[0].id}/>
                    <input type={"hidden"} name={"quantity"} value={cartItems[0].quantity}/>
                </form>
            </div>
        </div>
    );
}
