import React from "react";
import Charts from "../components/Charts";
import Footer from "../components/Footer";
import NavbarComponent from "../components/NavbarComponent";

import faixaSalarioService from "../services/FaixaSalarioService";
import cursoService from "../services/CursoService";
import cargoService from "../services/CargoService";

function Estatisticas(){
    const fsService= new faixaSalarioService()
    const crsService = new cursoService()
    const crgService = new cargoService()

    console.log(fsService.quantEgressosPorFaixaSalario())
    console.log(crsService.quantEgressosPorCurso());
    console.log(crgService.quantEgressosPorCargo());

    return (
      <div>
        <NavbarComponent />
        <div
          className="p-5 d-flex flex-column align-items-center w-100"
          style={{ backgroundColor: "rgba(189, 205, 236, 1)" }}
        >
          <p className="h1 mb-4">Estatísticas</p>
          <Charts description="Egressos por Faixa Salarial" />

          <Charts description="Egressos por Curso" />

          <Charts description="Egressos por Cargo" />
        </div>
        <Footer />
      </div>
    );
}

export default  Estatisticas;