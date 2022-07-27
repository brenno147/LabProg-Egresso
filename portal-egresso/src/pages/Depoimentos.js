import React, {useState, useEffect} from "react";
import Depoimento from "../components/Depoimento";
import NavbarComponent from '../components/NavbarComponent';
import DepoimentoService from "../services/DepoimentoService";
import Footer from '../components/Footer';
import Pagination from "../components/Pagination";

function Depoimentos(){

    const depService = new DepoimentoService();

    const [depoimentos, setDepoimentos] = useState([])
    const [loading, setLoading] = useState(false)
    const [currentPage, setCurrentPage] = useState(1);
    const [depoimentosPerPage, setDepoimentosPerPage] = useState(5);

    useEffect(() => {
        const fetchDepoimentos = async () => {
            setLoading(true)
            const res = await depService.getDepoimentos()
            console.log(res.data)
            setDepoimentos(res.data)
            setLoading(false)
        }

        fetchDepoimentos()
    }, [])

    const indexDepoimentoFim = currentPage * depoimentosPerPage
    const indexDepoimentoInicio = indexDepoimentoFim - depoimentosPerPage
    const depoimentosAtuais = depoimentos.slice(indexDepoimentoInicio, indexDepoimentoFim)

    const paginate = pageNumber => setCurrentPage(pageNumber)

    return (
        <div>
             <NavbarComponent />
            <div className="d-flex flex-column align-items-center w-100">
                <p className="h1 mt-5 mb-5" >Depoimentos</p>
                {!loading && (
                    <ul className="list-group mb-4">
                        {depoimentosAtuais.map((depoimento) => (
                            <li key={depoimento.id} className="list-group-item">
                                <Depoimento nomeEgresso={depoimento.egresso} depoimento={depoimento.texto} data={depoimento.data}/>
                            </li>
                        ))}
                    </ul>
                )}
                
            </div>
            <div className="m-5">
                <Pagination itensPerPage={depoimentosPerPage} totalItens={depoimentos.length} paginate={paginate}/>
            </div>
            
            <Footer />
        </div>
    );
}

export default Depoimentos