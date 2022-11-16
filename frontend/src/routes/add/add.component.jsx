import FormInput from "../../components/form-input/form-input.component";
import Button from "../../components/button/button.component";
import "./add.styles.scss";
import {useState} from "react";

export default function Add() {

    const [formField, setFormField] = useState({
        name: '',
        imageUrl: '',
        price: '',
        quantity: '',
    })

    const {name, imageUrl, price, quantity} = formField;

    const onChangeHandler = (event) => {

        const {name, value} = event.target;
        setFormField(
            {
                ...formField,
                [name]: value,
            });
    }

    return (
        <div className={"form-container"}>
            <form action={"/add.do"} method={"POST"}>
                <select className={"select-container"} name={"category"}>
                    <option value={"Hats"}>Hats</option>
                    <option value={"Jackets"}>Jackets</option>
                    <option value={"Sneakers"}>Sneakers</option>
                    <option value={"Womens"}>Womens</option>
                    <option value={"Mens"}>Mens</option>
                </select>
                <FormInput name={"name"} type={"text"} label={"Name"} value={name}
                           onChange={onChangeHandler}/>
                <FormInput name={"imageUrl"} type={"url"} label={"Image URL"} value={imageUrl}
                           onChange={onChangeHandler}/>
                <FormInput name={"price"} type={"number"} label={"Price"} value={price}
                           onChange={onChangeHandler}/>
                <FormInput name={"quantity"} type={"number"} label={"Quantity"} value={quantity}
                           onChange={onChangeHandler}/>
                <Button type={"submit"} buttonType={"google"}>Add</Button>
            </form>
        </div>
    )
}