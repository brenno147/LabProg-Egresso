import "./dependencies";
import "bootstrap/dist/css/bootstrap.min.css";
import "./css/style.css";
import Home from "./pages/Home";
import Egresso from "./pages/Egresso";
// import Cadastro from "./pages/Cadastro";
import Login from "./pages/Login";

function App() {
  return (
    <div>
      {/* <Login /> */}
      {/* <Home /> */}
      {/* <Egresso /> */}
      <Egresso />
    </div>
    // <Cadastro/>
  );
}
export default App;
