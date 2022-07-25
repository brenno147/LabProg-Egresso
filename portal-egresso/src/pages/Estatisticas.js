import React, { useEffect, useState } from "react";
import Charts from "../components/Charts";
import Footer from "../components/Footer";
import NavbarComponent from "../components/NavbarComponent";

import faixaSalarioService from "../services/FaixaSalarioService";
import cursoService from "../services/CursoService";
import cargoService from "../services/CargoService";

function Estatisticas(){
    const fsService = new faixaSalarioService()
    const crsService = new cursoService()
    const crgService = new cargoService()

    let [faixaSalarioData, setFaixaSalarioData] = useState([])
    let [cursoData, setCursoData] = useState([])
    let [cargoData, setCargoData] = useState([])
    let [fsArrayLabels, setFsArrayLabels] = useState();
    let [crsArrayLabels, setCrsArrayLabels] = useState();
    let [crgArrayLabels, setCrgArrayLabels] = useState();
    let fsDataAux, crsDataAux, crgDataAux
    

    useEffect( () => {
      async function fectchData() {
        fsDataAux = await fsService.quantEgressosPorFaixaSalario();
        crsDataAux = await crsService.quantEgressosPorCurso()
        crgDataAux = await crgService.quantEgressosPorCargo()



        setFsArrayLabels(fsDataAux.data.map((item) => item.faixaSalario))
        setCrsArrayLabels(crsDataAux.data.map((item) => item.curso));
        setCrgArrayLabels(crgDataAux.data.map((item) => item.cargo));


        setFaixaSalarioData(fsDataAux.data.map((item) => item.numEgresso))
        setCursoData(crsDataAux.data.map((item) => item.numEgresso));
        setCargoData(crgDataAux.data.map((item) => item.numEgresso));

        //ADICIONANDO DADOS ESTÁTICOS
        setFsArrayLabels((prevState) => [...prevState, 3, 4])
        setCrgArrayLabels((prevState) => [...prevState, 3, 4, 5, 6]);
    
      }
      fectchData()
    }, [])

    return (
      <div>
        <NavbarComponent />
        <div
          className="p-5 d-flex flex-column align-items-center w-100"
          style={{ backgroundColor: "rgba(189, 205, 236, 1)" }}
        >
          <p className="h1 mb-4">Estatísticas</p>
          <Charts 
            chartData={faixaSalarioData} 
            labels={fsArrayLabels} 
            description="Egressos por Faixa Salarial"
            text="Faixas Salariais"
            />

          <Charts 
            chartData={cursoData} 
            labels={crsArrayLabels} 
            description="Egressos por Curso" 
            text="Cursos"
            />

          <Charts 
            chartData={cargoData} 
            labels={crgArrayLabels} 
            description="Egressos por Cargo"
            text="Cargos"
          />
        </div>
        <Footer />
      </div>
    );
}

export default  Estatisticas;