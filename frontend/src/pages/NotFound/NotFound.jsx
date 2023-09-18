import { Form, Button } from "react-bootstrap";
import styles from "./NotFound.module.css";
import logoPng from "../../assets/coffeeCat.png";

export default function NotFound() {
	const navigate = useNavigate();

	return (
		<div className={styles.login_page}>
			<div className={styles.login_logo_wrapper}>
				{logoPng ? <img src={logoPng} alt={logoPng}/> : "failed to load this image"}
			</div>
			<Form
				className={styles.login_wrapper}
				onSubmit={(e) => handleSubmitLogin(e)}
			>
				<div className={styles.login_upper_section}>Erro 404</div>

				<Form.Group className={styles.login_form_field_bottom_section}>
					<Form.Label>Retorne a página inicial</Form.Label>
					<Button
					className={styles.login_form_login_button}
						variant="secondary"
						type="submit"
					>
						Voltar
					</Button>
				</Form.Group>
			</Form>
		</div>
	);
}
