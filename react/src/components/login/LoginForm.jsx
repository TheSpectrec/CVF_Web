import { useState } from 'react';
import axios from 'axios';
import PasswordInput from './PasswordInput';

const LoginForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [isAdmin, setIsAdmin] = useState(false);

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (password.length < 8) {
      alert('La contraseña debe tener al menos 8 caracteres.');
      return;
    }
    try {
      const response = await axios.post('http://localhost:3000/users/login', { username, password });
      localStorage.setItem('token', response.data.token);
      setIsAdmin(response.data.isAdmin);
      alert('Inicio de sesión exitoso');
    } catch (error) {
      alert('Error en el inicio de sesión');
    }
  };

  return (
    <div className='col-md-4'>
      <div className='card card-login shadow-lg'>
        <div className='card-body'>
          <form onSubmit={handleSubmit}>
            <div className='mb-3'>
              <label htmlFor='username' className='form-label'>Usuario</label>
              <input type='text' className='form-control' id='username' placeholder='Username' required value={username} onChange={(e) => setUsername(e.target.value)} />
            </div>
            <PasswordInput password={password} setPassword={setPassword} />
            <button type='submit' className='btn btn-ingresar w-100'>
              Ingresar
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default LoginForm;
