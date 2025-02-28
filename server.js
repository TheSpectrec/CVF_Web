const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
require('dotenv').config();

const app = express();
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));

// Middlewares
app.use(bodyParser.json());
app.use(cors({
    origin: '*'
}));


// Database Connection
const db = require('./config/db');

// Import Routes
const userRoutes = require('./routes/user.routes');

// Use Routes
app.use('/users', userRoutes);

// Start Server
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
