const Header = () => {
  return (
    <div className="row header shadow-lg align-items-center">
      <div className="col-md-3 d-flex justify-content-start">
        <img src="./src/resources/LOGOTIPO.png" alt="Logo" className="logo" />
      </div>
      <div className="col-md-6 text-center">
        <h2 className="fw-bold text-uppercase mb-0">Control de Visitas</h2>
        <h4 className="fw-bold text-uppercase mb-0">A Fraccionamiento</h4>
      </div>
    </div>
  );
};

export default Header;
