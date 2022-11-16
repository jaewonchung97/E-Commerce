import { Routes, Route } from "react-router-dom";

import Home from "./routes/home/home.component";
import Navigation from "./routes/navigation/navigation.component";
import Shop from "./routes/shop/shop.component";
import Checkout from "./routes/checkout/checkout.component";
import Add from "./routes/add/add.component";

function App() {
  return (
    <Routes>
      <Route path={"/"} element={<Navigation />}>
        <Route index={true} element={<Home />} />
        <Route path={"shop/:title"} element={<Shop />} />
        <Route path={"checkout"} element={<Checkout />} />
        <Route path={"add"} element={<Add />} />
      </Route>
    </Routes>
  );
}

export default App;
