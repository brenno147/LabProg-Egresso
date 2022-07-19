import "./dependencies";
import "bootstrap/dist/css/bootstrap.min.css";
import "./css/style.css";
import Rotas from "./Rotas";
import Constantes from "./Constantes";

function App() {
  const constantes = new Constantes();
  return (
    <>
      <Rotas/>
    </>
  );
}
export default App;
