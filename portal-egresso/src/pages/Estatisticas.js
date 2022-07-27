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
    let fsDataAux, crsDataAux, crgDataAux
    

    useEffect( () => {
      async function fectchData() {
        fsDataAux = await fsService.quantEgressosPorFaixaSalario();
        crsDataAux = await crsService.quantEgressosPorCurso()
        crgDataAux = await crgService.quantEgressosPorCargo()


        fsDataAux.data.forEach((item) => {
          setFaixaSalarioData((prevState) => {
            let newValues = [...prevState]
            newValues[item.faixaSalario - 1] = item.numEgresso
            return newValues
          })
        })
        crsDataAux.data.forEach((item) => {
          setCursoData((prevState) => {
            let newValues = [...prevState]
            newValues[item.curso - 1] = item.numEgresso
            return newValues
          })
        });
        crgDataAux.data.forEach((item) => {
          setCargoData((prevState) => {
            let newValues = [...prevState]
            newValues[item.cargo - 1] = item.numEgresso
            return newValues
          })
        })
    
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
            labels={[
              "1.000-5.000",
              "6.000-12.000",
              "13.000-26.000",
              "Maior que 26.000",
            ]}
            description="Egressos por Faixa Salarial"
            text="Faixas Salariais"
          />

          <Charts
            chartData={cursoData}
            labels={[
              "Engenharia da Computação",
              "Ciência da Computação",
              "Sistemas de Informação",
            ]}
            description="Egressos por Curso"
            text="Cursos"
          />

          <Charts
            chartData={cargoData}
            labels={[
              "Analista de Sistemas",
              "Engenheiro de Software",
              "DBA",
              "Cientista de Dados",
              "Professor na área de TI",
              "Outro"
            ]}
            description="Egressos por Cargo"
            text="Cargos"
          />
        </div>
        <Footer />
      </div>
    );
}

export default  Estatisticas;