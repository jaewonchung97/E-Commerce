import categories from "../../categories.json";
import Directory from "../../components/directory/directory.component";
import {Link, Outlet} from "react-router-dom";
import Button from "../../components/button/button.component";
import './home.styles.scss';

function Home() {
    return (
        <div>
            <Outlet/>
            <Directory categories={categories}/>
            <div className={"button-container-pay"}>
                <Link to={"/add"}>
                    <Button>Product Add</Button>
                </Link>
            </div>
        </div>
    );
}

export default Home;
