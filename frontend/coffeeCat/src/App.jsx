import "bootstrap/dist/css/bootstrap.min.css";
import { Routes, Route } from "react-router-dom";
import "./App.css";
import "react-toastify/dist/ReactToastify.css";
import Login from "./pages/Login/Login";
import Register from "./pages/Register/Register";
import Layout from "./layouts/Layout";
import HomePage from "./pages/HomePage/HomePage";
import PickupPoints from "./pages/PickupPoints/PickupPoints";
import { useAuth } from "./hooks/useAuth";
import ProtectedRoute from "./components/ProtectedRoute/ProtectedRoute";
import Cart from "./pages/Cart/Cart";
import Orders from "./pages/Orders/Orders";
import NotFound from "./pages/NotFound/NotFound";


function App() {
  const { auth } = useAuth()

  return (
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />

      <Route element={<ProtectedRoute redirectPath="/login" isAllowed={!!auth.isAuthenticated} />}>
        <Route path="/" element={<Layout />}>
          <Route index element={<HomePage />} />
          <Route path="/home" element={<HomePage />} />
          <Route path="/pickupPoints" element={<PickupPoints />} />
          <Route path="/orders" element={<Orders />} />
          <Route path="/cart" element={<Cart />} />
        </Route>
      </Route>

      <Route path="*" element={<NotFound />} />
    </Routes>
  )
}

export default App
