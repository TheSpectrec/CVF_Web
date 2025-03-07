import { useState } from 'react';
import styles from '../styles/Login.module.css';
import PasswordInput from '../components/PasswordInput';
import Header from '../components/Header';

const Login = () => {
    const [password, setPassword] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        if (password.length < 8) {
          alert("La contraseña debe tener al menos 8 caracteres.");
          return;
        }
        alert("Inicio de sesión exitoso");
      };

    return (
        <>
        <div className="container-fluid min-vh-100 d-flex flex-column">
        <Header />
        <div className={`row ${styles.background} flex-grow-1 d-flex justify-content-center align-items-center`}>
        <div className="col-md-4">
      <div className={`card ${styles.cardLogin} shadow-l`}>
        <div className="card-body">
          <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <label htmlFor="email" className="form-label">Correo</label>
              <input type="email" className="form-control" id="email" placeholder="ejemplo@gmail.com" required />
            </div>
            <PasswordInput password={password} setPassword={setPassword} />
            <button type="submit" className={`btn ${styles.botonIngresar} w-100`}>
              Ingresar
            </button>
          </form>
        </div>
      </div>
    </div>
    </div>
    </div>
        </>
        
    );

    }

    export default Login;