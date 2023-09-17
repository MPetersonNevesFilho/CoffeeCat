import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import logoPng from "../../assets/coffeeCatHorizontal.png";
import styles from "./Menubar.module.css";
import { Buildings, HouseSimple, Package, ShoppingCartSimple } from "phosphor-react";
import { useNavigate } from "react-router-dom";

export default function Menubar() {
	const navigate = useNavigate();
	return (
		<Navbar className={styles.navbar_background} bg="#00000" expand="md">
			<Container>
				<Navbar.Brand href="/home">
					<div className={styles.menubar_logo_wrapper}>
						{logoPng ? (
							<img src={logoPng} alt={logoPng} />
						) : (
							"failed to load this image"
						)}
					</div>
				</Navbar.Brand>
				<Navbar.Toggle aria-controls="basic-navbar-nav" />
				<Navbar.Collapse id="basic-navbar-nav">
					<Nav className="justify-content-end" style={{ width: "100%" }}>
						<Nav.Link onClick={() => navigate("/home")} className={styles.links}>
							<HouseSimple size={32} /> Home
						</Nav.Link>
						<Nav.Link onClick={() => navigate("/pickup-points")} className={styles.links}>
							<Buildings size={32} /> Pickup Points
						</Nav.Link>
						<Nav.Link onClick={() => navigate("/orders")} className={styles.links}>
							<Package size={32} /> My Orders
						</Nav.Link>
						<Nav.Link onClick={() => navigate("/cart")} className={styles.links}>
							<ShoppingCartSimple size={32} /> Cart
						</Nav.Link>
					</Nav>
				</Navbar.Collapse>
			</Container>
		</Navbar>
	);
}
