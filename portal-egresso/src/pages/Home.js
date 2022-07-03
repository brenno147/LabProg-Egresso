import React from "react";
// import Header from "./../components/Header";
import CardEgresso from "./../components/CardEgresso";
import DepoimentosCarousel from "./../components/DepoimentosCarousel";
import Charts from "./../components/Charts";
import Footer from "./../components/Footer";
import NavbarComponent from "../components/NavbarComponent";
import {useNavigate} from 'react-router-dom'



export default function Home() {
  const navigate = useNavigate();
  const styles = {
    button: {
      border: "none",
      backgroundColor: "rgba(46, 62, 92, 1)",
      borderRadius: "5%",
    },
  };

  return (
    <div>
      <NavbarComponent />
      <div
        className="d-flex flex-column align-items-center pt-3 pb-5"
        style={{ backgroundColor: "rgba(189, 205, 236, 1)" }}
      >
        <p className="h1" style={{marginTop:"30px",marginBottom:"50px"}}>Egressos</p>
        <div className="d-flex w-75 justify-content-between mt-3 mb-2">
          <CardEgresso />
          <CardEgresso />
          <CardEgresso />
        </div>
        <div className="d-flex w-75 justify-content-between mb-4 mt-3">
          <CardEgresso />
          <CardEgresso />
          <CardEgresso />
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
        <DepoimentosCarousel />
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
        <Charts />
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
