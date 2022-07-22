import React, { useState, useEffect } from "react";
import CardEgresso from "../components/CardEgresso";
import NavbarComponent from "../components/NavbarComponent";
import Footer from "../components/Footer";
import Pagination from "../components/Pagination";

function Egresso() {

  const [egressos, setEgressos] = useState([])
  const [loading, setLoading] = useState(false)
  const [currentPage, setCurrentPage] = useState(1);
  const [egressosPerPage, setEgressosPerPage] = useState(6);

  useEffect(() => {
    const fetchEgressos = async () => {
      setLoading(true)
      const res = [{"id": 1, "nome":"SARAH ARCHARDI1", "cargo":"dsfsfdsfsfsfefse"}, 
      {"id":2, "nome":"SARAH ARCHARDI2", "cargo":"dsfsfdsfsfsfefse"}, 
      {"id":3, "nome":"dssfdfsf", "cargo":"dsfsfdsfsfsfefse"},
      {"id":4, "nome":"dssfdfsf", "cargo":"dsfsfdsfsfsfefse"},
      {"id":5, "nome":"SARAH ARCHARDI5", "cargo":"dsfsfdsfsfsfefse"},
      {"id":6, "nome":"dssfdfsf", "cargo":"dsfsfdsfsfsfefse"},
      {"id":7, "nome":"dssfdfsf", "cargo":"dsfsfdsfsfsfefse"},
      {"id":8, "nome":"dssfdfsf", "cargo":"dsfsfdsfsfsfefse"}]//get
      setEgressos(res)
      setLoading(false)
    }

    fetchEgressos()
  }, [])

  const indexEgressoFim = currentPage * egressosPerPage
  const indexEgressoInicio = indexEgressoFim - egressosPerPage
  const egressosAtuaisTop = egressos.slice(indexEgressoInicio, (indexEgressoFim - (egressosPerPage/2)))
  const egressosAtuaisBot = egressos.slice((indexEgressoInicio + (egressosPerPage/2)), indexEgressoFim)

  const paginate = pageNumber => setCurrentPage(pageNumber)

  return (
    <div>
      <NavbarComponent />
      <div
        className="d-flex flex-column align-items-center pt-3 pb-5"
        style={{ backgroundColor: "rgba(189, 205, 236, 1)" }}
      >
        <p className="h1" style={{ marginTop: "30px", marginBottom: "50px" }}>
          Egressos
        </p>

        {!loading && (
          <div>
            <div className="d-flex justify-content-between mt-3 mb-2">
              <ul className="list-inline mb-4">
                {egressosAtuaisTop.map((egresso) => (
                  <li key={egresso.id} className="list-inline-item">
                    <CardEgresso nome={egresso.nome} cargo={egresso.cargo}/>
                  </li>
                ))}
              </ul>
            </div>
            <div className="d-flex justify-content-between mb-4 mt-3">
              <ul className="list-inline mb-4">
                {egressosAtuaisBot.map((egresso) => (
                  <li key={egresso.id} className="list-inline-item">
                    <CardEgresso nome={egresso.nome} cargo={egresso.cargo}/>
                  </li>
                ))}
              </ul>
            </div>
          </div>
        )}

        <div className="m-5">
          <Pagination itensPerPage={egressosPerPage} totalItens={egressos.length} paginate={paginate}/>
        </div>

        {/*{<ul>
          <div className="d-flex w-75 justify-content-between mt-3 mb-2">
            <li><CardEgresso /></li>
            <li><CardEgresso /></li>
            <li><CardEgresso /></li>
          </div>
          <div className="d-flex w-75 justify-content-between mb-4 mt-3">
            <li><CardEgresso /></li>
            <li><CardEgresso /></li>
            <li><CardEgresso /></li>
          </div>
        </ul>}
        {/* <EgressoPage /> */}
      </div>
      <Footer />
    </div>
  );
}

export default Egresso;
