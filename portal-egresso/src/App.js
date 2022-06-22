import Home from "./pages/Home";
import EgressoModal from "./components/EgressoModal";
import "./dependencies";
import "bootstrap/dist/css/bootstrap.min.css";
import "./css/style.css";
import Cadastro from "./pages/Cadastro";
import Login from "./pages/Login";
import Perfil from "./pages/Perfil";
import Egresso from './pages/Egresso';
import Estatisticas from "./pages/Estatisticas";
import Depoimentos from "./pages/Depoimentos"

function App() {
  return (
    <div>
      {/* <Home /> */}
      {/* <EgressoModal /> */}
      {/* <Cadastro/> */}
      {/* <Login/> */}
      {/* <Perfil/> */}
      {/* <Egresso/> */}
      {/* <Estatisticas/> */}
      <Depoimentos/>
    </div>
  );
}
export default App;
