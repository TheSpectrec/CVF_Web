import Header from "./components/Header";
import LoginForm from "./components/LoginForm";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Login.css";

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
