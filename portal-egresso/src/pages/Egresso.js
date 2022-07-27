import React, { useState, useEffect } from "react";
import CardEgresso from "../components/CardEgresso";
import EgressoModal from "../components/EgressoModal";
import NavbarComponent from "../components/NavbarComponent";
import EgressoService from "../services/EgressoService";
import Footer from "../components/Footer";
import Pagination from "../components/Pagination";
import egService from "../services/EgressoService"

function Egresso() {
  const egressoService = new egService();
  
  const [egressoModal, setEgressoModal] = useState()

  const [egressos, setEgressos] = useState([])
  const [loading, setLoading] = useState(false)
  const [currentPage, setCurrentPage] = useState(1);
  const [egressosPerPage, setEgressosPerPage] = useState(6);

  useEffect(() => {
    const fetchEgressos = async () => {
      setLoading(true)
      const res = await egressoService.listEgresso()
      console.log(res.data)
      setEgressos(res.data)
      setLoading(false)
    }

    fetchEgressos()
  }, [])

  const indexEgressoFim = currentPage * egressosPerPage
  const indexEgressoInicio = indexEgressoFim - egressosPerPage
  const egressosAtuais = egressos.slice(indexEgressoInicio, indexEgressoFim);

  const paginate = pageNumber => setCurrentPage(pageNumber)

  return (
    <div>
      {egressoModal && (
        <EgressoModal
          egresso={egressoModal}
          closeModal={() => setEgressoModal()}
        />
      )}

      <NavbarComponent />
      <div
        className="d-flex flex-column align-items-center pt-3 pb-5"
        style={{ backgroundColor: "rgba(189, 205, 236, 1)" }}
      >
        <p className="h1" style={{ marginTop: "30px", marginBottom: "50px" }}>
          Egressos
        </p>

        {!loading && (
          <div className="d-flex w-100 gap-3 justify-content-center row">
              {egressosAtuais.map((egresso) => (
                  <CardEgresso
                    clickable
                    key={egresso.idEgresso}
                    nome={egresso.nome}
                    cargo={
                      egresso.profissao.length > 0
                        ? egresso.profissao[0].cargo.nome
                        : "Sem cargo"
                    }
                    onClick={() => setEgressoModal(egresso)}
                  />
              ))}
          </div>
        )}

        <div className="m-5">
          <Pagination
            itensPerPage={egressosPerPage}
            totalItens={egressos.length}
            paginate={paginate}
          />
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default Egresso;
