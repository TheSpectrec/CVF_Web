import Header from "../login/Header";
import Sidebar from "./Sidebar";
import UserTable from "./UserTable";
import "./Dashboard.css";

const Dashboard = () => {
  return (
    <div className="dashboard-container">
      <Header />
      <div className="dashboard-content">
        <Sidebar />
        <div className="dashboard-main">
          <h3 className="dashboard-title">Gestión de Usuarios</h3>
          <UserTable />
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
