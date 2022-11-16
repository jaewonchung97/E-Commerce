import "./category-item.styles.scss";
import {Link} from "react-router-dom";

export default function CategoryItem({category}) {
    const {imageUrl, title} = category;
    return (
        <Link to={`/shop/${title.toString()}`} className={"category-container"}>
                <div
                    className="background-image"
                    style={{
                        backgroundImage: `url(${imageUrl})`,
                    }}
                />
                <div className="category-body-container">
                    <h2>{title}</h2>
                    <p>Shop Now</p>
                </div>
        </Link>
    );
}
