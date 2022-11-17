import {useState, useEffect} from "react";
import ProductCard from "../../components/product-card/product-card.component";
import './shop.styles.scss';
import {useParams} from "react-router-dom";

export default function Shop() {
    const [products, setProducts] = useState([]);
    const {title} = useParams();
    useEffect(
        () => {
            fetch(`/shop/${title}.do`)
                .then(data => data.json())
                .then(json => setProducts(json));
        }, [title]
    );

    return (
        <>
            <div className="products-container">
                {products.map((product) => {
                    return (<ProductCard key={product.id} product={product}/>);
                })}
            </div>
        </>
    );
}
