import Header from "./components/login/Header";
import LoginForm from "./components/login/LoginForm";
import "bootstrap/dist/css/bootstrap.min.css";
import "./components/login/Login.css";

function App() {
  return (
    <div className="container-fluid min-vh-100 d-flex flex-column">
      <Header />
      <div className="row background flex-grow-1 d-flex justify-content-center align-items-center">
        <LoginForm />
      </div>
    </div>
  );
}

export default App;
