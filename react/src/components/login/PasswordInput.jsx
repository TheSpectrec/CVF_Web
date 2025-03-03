import { useState } from "react";

const PasswordInput = ({ password, setPassword }) => {
  const [showPassword, setShowPassword] = useState(false);
  const [passwordError, setPasswordError] = useState(false);

  const handlePasswordToggle = () => {
    setShowPassword(!showPassword);
  };

  return (
    <div className="mb-3">
      <label htmlFor="password" className="form-label">Contraseña</label>
      <div className="input-group">
        <input
          type={showPassword ? "text" : "password"}
          className={`form-control ${passwordError ? "border-danger" : ""}`}
          id="password"
          placeholder="Contraseña"
          value={password}
          onChange={(e) => {
            setPassword(e.target.value);
            setPasswordError(e.target.value.length < 8);
          }}
          required
        />
        <button type="button" className="btn btn-mostrar" onClick={handlePasswordToggle}>
          {showPassword ? "Ocultar" : "Mostrar"}
        </button>
      </div>
      {passwordError && <small className="text-danger">La contraseña debe tener al menos 8 caracteres.</small>}
    </div>
  );
};

export default PasswordInput;
