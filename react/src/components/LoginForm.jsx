import { useState } from "react";
import PasswordInput from "./PasswordInput";

const LoginForm = () => {
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
    <div className="col-md-4">
      <div className="card card-login shadow-lg">
        <div className="card-body">
          <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <label htmlFor="email" className="form-label">Usuario</label>
              <input type="email" className="form-control" id="email" placeholder="Username" required />
            </div>
            <PasswordInput password={password} setPassword={setPassword} />
            <button type="submit" className="btn btn-ingresar w-100">
              Ingresar
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default LoginForm;
