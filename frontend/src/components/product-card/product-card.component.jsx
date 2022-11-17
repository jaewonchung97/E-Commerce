import {useContext} from "react";
import {CartContext} from "../../contexts/cart.context";
import Button from "../button/button.component";
import "./product-card.styles.scss";

export default function ProductCard({product}) {
    const {name, imageUrl, price, quantity} = product;
    const {addItemToCart} = useContext(CartContext);
    const addProductToCart = () => addItemToCart(product);

    return (
        <div className={`product-card-container ${quantity ? null : "disabled"}`}>
            <img src={imageUrl} alt={name}/>
            <div className="footer">
                <span className="name">{name}</span>
                <span className="price">${price}</span>
            </div>
            <Button buttonType={"inverted"} onClick={addProductToCart}>
                {quantity ? "Add to Cart" : "Out of Stock"}
            </Button>
        </div>
    );
}
