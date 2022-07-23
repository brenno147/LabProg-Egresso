import React, {useEffect, useState} from "react";
import CardEgresso from "../components/CardEgresso";
import NavbarComponent from "../components/NavbarComponent";
import PageComponent from "../components/PageComponent";
import Footer from "../components/Footer";

function EgressoPage() {

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
      {"id":6, "nome":"dssfdfsf", "cargo":"dsfsfdsfsfsfefse"}]//get
      setEgressos(res)
      setLoading(false)
    }

    fetchEgressos()
  }, [])

  const indexEgressoFim = currentPage * egressosPerPage
  const indexEgressoInicio = indexEgressoFim - egressosPerPage
  const egressosAtuais = egressos.slice(indexEgressoInicio, indexEgressoFim)
  const paginate = pageNumber => setCurrentPage(pageNumber)

  return (
    <>
      <NavbarComponent />
      <div className="container mt-5 mb-5">
        <p className="h1 mt-5 mb-5 text-center">Egressos</p>
        {loading &&(
          <div className="row mt-1">
            {egressosAtuais.map((egresso) => (
              <ul className="list-group mb-4">
                <li key={egresso.id} className="list-group-item">
                  <div className="col-md-4">
                    <CardEgresso nome={egresso.nome} cargo={egresso.cargo}/>
                  </div>
                </li>
              </ul>
            ))}
          </div>)}
        <PageComponent/>
      </div>
      <Footer/>
    </>
  );
};

export default EgressoPage;
