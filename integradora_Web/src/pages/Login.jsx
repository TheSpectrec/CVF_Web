import { useState } from "react";

import Header from "../components/Header";

const Login = () => {
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const [passwordError, setPasswordError] = useState(false);

  const handlePasswordToggle = () => {
    setShowPassword(!showPassword);
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    if (password.length < 8) {
      setPasswordError(true);
      return;
    }

    setPasswordError(false);
    alert("Inicio de sesión exitoso");
  };
  return (
    <div className="w-100 min-vh-100 d-flex flex-column">
      {/* Encabezado */}
      <Header />

      {/* Fondo animado */}
      <div
        className="flex-grow-1 w-100 d-flex justify-content-center align-items-center"
        style={{
          background: "linear-gradient(to right, #7A4A32, #BBA996)",
          backgroundSize: "200% 200%",
          animation: "moverFondo 8s infinite alternate ease-in-out",
        }}
      >
        {/* Tarjeta de inicio de sesión */}
        <div
          className="card shadow-lg border-0"
          style={{
            width: "400px",
            backgroundColor: "#CBCABE",
            boxShadow: "0px 15px 30px rgba(0, 0, 0, 0.6)",
          }}
        >
          <div className="card-body">
            <form onSubmit={handleSubmit}>
              <div className="mb-3">
                <label htmlFor="email" className="form-label">Correo</label>
                <input type="email" className="form-control border" id="email" placeholder="ejemplo@gmail.com" required />
              </div>
              <div className="mb-3">
                <label htmlFor="password" className="form-label">Contraseña</label>
                <div className="input-group">
                  <input
                    type={showPassword ? "text" : "password"}
                    className={`form-control border ${passwordError ? "border-danger" : ""}`}
                    id="password"
                    placeholder="Contraseña"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                  />
                  <button type="button" className="btn btn-secondary" onClick={handlePasswordToggle}>
                    {showPassword ? "Ocultar" : "Mostrar"}
                  </button>
                </div>
                {passwordError && <small className="text-danger">La contraseña debe tener al menos 8 caracteres.</small>}
              </div>
              <button type="submit" className="btn w-100" style={{ backgroundColor: "#71795B", color: "white" }}>
                Ingresar
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
