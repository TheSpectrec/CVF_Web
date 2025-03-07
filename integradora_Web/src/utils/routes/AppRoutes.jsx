
// Bootstrap
import 'bootstrap/dist/css/bootstrap.min.css'

// Pages
import Login from '../../pages/Login';
import { Routes, Route } from 'react-router-dom';


const AppRoutes = () => {
    return (
        <Routes>
                <Route path="/" index element={<Login />} />
        </Routes>
    );
}

export default AppRoutes;