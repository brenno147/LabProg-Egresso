import React from "react";
import Charts from "../components/Charts";
import Footer from "../components/Footer";
import NavbarComponent from "../components/NavbarComponent";
function Estatisticas(){
    return(
        <div>
            <NavbarComponent/>
            <div
        className="p-5 d-flex flex-column align-items-center w-100"
        style={{ backgroundColor: "rgba(189, 205, 236, 1)" }}
      >
                <p className="h1 mb-4">Estatísticas</p>
                <Charts/>
                <Charts/>
                <Charts />
            </div>
            <Footer />
        </div>
    );
}

export default  Estatisticas;