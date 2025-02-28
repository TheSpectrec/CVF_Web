const db = require('../config/db');
const jwt = require('jsonwebtoken');

exports.loginUser = async (req, res) => {
    try {
        const { username, password } = req.body;
        db.query('SELECT * FROM users WHERE username = ? AND password = ?', [username, password], (err, results) => {
            if (err) {
                return res.status(500).json({ message: 'Error en el servidor' });
            }
            if (results.length === 0) {
                return res.status(401).json({ message: 'Usuario o contraseña incorrectos' });
            }
            const user = results[0];
            const isAdmin = user.role === 'Admin';
            const token = jwt.sign({ userId: user.user_id, isAdmin }, process.env.JWT_SECRET, { expiresIn: '1h' });
            res.json({ token, isAdmin });
        });
    } catch (err) {
        res.status(500).json({ message: 'Error en el servidor' });
    }
};
