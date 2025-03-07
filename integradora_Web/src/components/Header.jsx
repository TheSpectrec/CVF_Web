import { Link } from "react-router-dom";
import styles from '../styles/Header.module.css'

const Header = () => {
    return (
      <div className={`${styles.header} shadow-lg d-flex align-items-center justify-content-between px-4`}>
        <div className="d-flex align-items-center">
          <img src="./src/resources/LOGOTIPO.png" alt="Logo" className="logo" />
          <h2 className="ms-3 fw-bold">CVF</h2>
        </div>
        <Link to="/" className="btn btn-cerrar-sesion">
          Cerrar Sesión <i className="fas fa-sign-out-alt"></i>
        </Link>
      </div>
    );
  };
  
  export default Header;
  