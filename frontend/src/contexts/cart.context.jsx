import { createContext, useState, useEffect } from "react";

export const CartContext = createContext({
  isCartOpen: false,
  setIsCartOpen: () => {},
  cartItems: [],
  setCartItems: () => {},
  addItemToCart: () => {},
  removeItemFromCart: () => {},
  clearItemFromCart: () => {},
  cartCount: 0,
  cartTotal: 0,
});

const addCartItem = (cartItems, productToAdd) => {
  let isNew = true;
  const newCartItems = cartItems.map((cartItem) => {
    if (cartItem.id === productToAdd.id) {
      isNew = false;
      return { ...cartItem, quantity: cartItem.quantity + 1 };
    } else return cartItem;
  });
  if (isNew) newCartItems.push({ ...productToAdd, quantity: 1 });
  return newCartItems;
};

const removeCartItem = (cartItems, cartItemToRemove) => {
  const newCartItems = cartItems.filter((cartItem) => {
    if (cartItem.id === cartItemToRemove.id) {
      cartItemToRemove.quantity--;
      cartItem.quantity = cartItemToRemove.quantity;
    }
    return cartItem.quantity > 0;
  });
  return newCartItems;
};

export const CartProvider = ({ children }) => {
  const [isCartOpen, setIsCartOpen] = useState(false);
  const [cartItems, setCartItems] = useState([]);
  const [cartCount, setCartCount] = useState(0);
  const [cartTotal, setCartTotal] = useState(0);

  useEffect(() => {
    var count = 0;
    var cartTotal = 0;
    cartItems.map((item) => {
      const { quantity, price } = item;
      count += quantity;
      cartTotal += quantity * price;
    });
    setCartCount(count);
    setCartTotal(cartTotal);
  }, [cartItems]);

  const addItemToCart = (productToAdd) => {
    setCartItems(addCartItem(cartItems, productToAdd));
  };

  const removeItemFromCart = (cartItemToRemove) => {
    setCartItems(removeCartItem(cartItems, cartItemToRemove));
  };

  const clearItemFromCart = (cartItemToClear) => {
    setCartItems(
      removeCartItem(cartItems, { ...cartItemToClear, quantity: 1 })
    );
  };

  const value = {
    isCartOpen,
    setIsCartOpen,
    cartItems,
    setCartItems,
    addItemToCart,
    removeItemFromCart,
    clearItemFromCart,
    cartCount,
    cartTotal,
  };

  return <CartContext.Provider value={value}>{children}</CartContext.Provider>;
};
