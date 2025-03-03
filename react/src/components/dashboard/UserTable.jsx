import { useState } from "react";

const UserTable = () => {
  const [users, setUsers] = useState([
    { id: 1, name: "Nombre de Usuario", lastName: "Apellidos de Usuario", email: "correo@utez.edu.mx" },
  ]);

  return (
    <div className="user-table-container">
      <div className="d-flex justify-content-between align-items-center px-3 py-2">
        <button className="btn btn-crear">
          <i className="fas fa-plus"></i> CREAR NUEVO
        </button>
        <select className="form-select dropdown">
          <option>Residentes</option>
        </select>
      </div>
      <table className="table">
        <thead>
          <tr>
            <th>NOMBRE</th>
            <th>APELLIDOS</th>
            <th>CORREO</th>
            <th>OPERACIONES</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.id}>
              <td>{user.name}</td>
              <td>{user.lastName}</td>
              <td>{user.email}</td>
              <td>
                <button className="btn btn-icon">
                  <i className="fas fa-edit"></i>
                </button>
                <button className="btn btn-icon">
                  <i className="fas fa-ban"></i>
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default UserTable;
