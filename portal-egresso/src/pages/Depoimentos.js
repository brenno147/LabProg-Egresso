import React, {useState, useEffect} from "react";
import Depoimento from "../components/Depoimento";
import NavbarComponent from '../components/NavbarComponent';
import Footer from '../components/Footer';
import Pagination from "../components/Pagination";

function Depoimentos(){

    const [depoimentos, setDepoimentos] = useState([])
    const [loading, setLoading] = useState(false)
    const [currentPage, setCurrentPage] = useState(1);
    const [depoimentosPerPage, setDepoimentosPerPage] = useState(5);

    useEffect(() => {
        const fetchDepoimentos = async () => {
            setLoading(true)
            const res = [{"id": 1, "nome":"dssfdfsf", "depo":"dsfsfdsfsfsfefse"}, 
            {"id":2, "nome":"dssfdfsf", "depo":"dsfsfdsfsfsfefse"}, 
            {"id":3, "nome":"dssfdfsf", "depo":"dsfsfdsfsfsfefse"},
            {"id":4, "nome":"dssfdfsf", "depo":"dsfsfdsfsfsfefse"},
            {"id":5, "nome":"dssfdfsf", "depo":"dsfsfdsfsfsfefse"},
            {"id":6, "nome":"dssfdfsf", "depo":"dsfsfdsfsfsfefse"},
            {"id":7, "nome":"dssfdfsf", "depo":"dsfsfdsfsfsfefse"}]//get
            setDepoimentos(res)
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
                                <Depoimento nomeEgresso={depoimento.nome} depoimento={depoimento.depo}/>
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