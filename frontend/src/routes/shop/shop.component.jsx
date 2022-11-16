import {useState, useEffect} from "react";
import ProductCard from "../../components/product-card/product-card.component";
import './shop.styles.scss';
import {useParams} from "react-router-dom";

export default function Shop() {
    const [products, setProducts] = useState([]);
    const [category, setCategory] = useState('');
    const {title} = useParams();
    useEffect(
        () => {
            console.log(title);
            setCategory(title);
            fetch(`/shop/${title}`)
                .then(data => data.json())
                .then(json => setProducts(json));
        }, [title]
    );

    return (
        <>
            <div className="products-container">
                {products ? products.map((product) => {
                        return (
                            <ProductCard key={product.id} product={product}/>
                        );
                    })
                    : <h1>No Items</h1>}
            </div>
        </>
    );
}
