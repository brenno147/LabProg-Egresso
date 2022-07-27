import React, { useEffect, useState } from "react";
import CardEgresso from "./../components/CardEgresso";
import DepoimentosCarousel from "./../components/DepoimentosCarousel";
import Charts from "./../components/Charts";
import Footer from "./../components/Footer";
import NavbarComponent from "../components/NavbarComponent";
import {useNavigate} from "react-router-dom";
import dpService from "./../services/DepoimentoService"
import egService from "./../services/EgressoService"
import fsService from "./../services/FaixaSalarioService"

export default function Home() {
  const navigate = useNavigate();
  const styles = {
    button: {
      border: "none",
      backgroundColor: "rgba(46, 62, 92, 1)",
      borderRadius: "5%",
    },
  };

  const [depoimentos, setDepoimentos] = useState();
  const [egressos, setEgressos] = useState();
  const [faixaSalario, setFaixaSalario] = useState();

  const depoimentoService = new dpService();
  const egressoService = new egService();
  const faixaSalarioService = new fsService();

  useEffect( () => {
    (async function fetchAllData () {
      const depoimentosResponse = await depoimentoService.getDepoimentos()
      const egressosResponse = await egressoService.listEgresso()
      const faixaSalarioResponse =
        await faixaSalarioService.quantEgressosPorFaixaSalario();
      setDepoimentos(depoimentosResponse.data)
      setEgressos(egressosResponse.data);
      setFaixaSalario(faixaSalarioResponse.data);
      console.log(egressosResponse.data)
      
    })()
  }, [])

  return (
    <div>
      <NavbarComponent/>
      <div
        className="d-flex flex-column align-items-center pt-3 pb-5"
        style={{ backgroundColor: "rgba(189, 205, 236, 1)" }}
      >
        <p className="h1" style={{marginTop:"30px",marginBottom:"50px"}}>Egressos</p>
        <div className="d-flex gap-3 justify-content-center row">
          {egressos.slice(0,6).map(egresso => {
            return (
              <CardEgresso 
                key={egresso.idEgresso} 
                nome={egresso.nome} 
                cargo={
                  egresso.profissao.length > 0 ? 
                  egresso.profissao[egresso.profissao.length - 1].cargo.nome 
                  : "Sem cargo"
                }
              />
            )
          })}
        </div>
        <button
          type="button"
          className="pr-3 pl-3 pt-1 pb-1 text-light"
          style={styles.button}
          onClick={() => navigate("/egresso")}
        >
          Ver mais
        </button>
      </div>

      <div className="p-5 d-flex flex-column align-items-center w-100">
        <p className="h1 mb-4">Depoimentos</p>
        <DepoimentosCarousel depoimentos={depoimentos} />
        <button
          type="button"
          className="pr-3 pl-3 pt-1 pb-1 text-light mt-4"
          style={styles.button}
          onClick={() => navigate("/depoimento")}
        >
          Ver mais
        </button>
      </div>

      <div
        className="p-5 d-flex flex-column align-items-center w-100"
        style={{ backgroundColor: "rgba(189, 205, 236, 1)" }}
      >
        <p className="h1 mb-4">Estatísticas</p>
        <Charts 
          chartData={faixaSalario.map(item => item.numEgresso)}
          labels={faixaSalario.map(item => item.faixaSalario)}
          description="Egressos por Faixa Salarial"
          text="Faixas Salariais"
        />
        <button
          type="button"
          className="pr-3 pl-3 pt-1 pb-1 text-light mt-4"
          style={styles.button}
          onClick={() => navigate("/estatisticas")}
        >
          Ver mais
        </button>
      </div>

      <Footer />
    </div>
  );
}
