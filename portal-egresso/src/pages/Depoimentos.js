import React from "react";
import Depoimento from "../components/Depoimento";
import NavbarComponent from '../components/NavbarComponent';
import Footer from '../components/Footer';
import PageComponent from "../components/PageComponent";

function Depoimentos(){
    return (
        <div>
             <NavbarComponent />
            <div className="d-flex flex-column align-items-center w-100">
                <p className="h1 mt-5 mb-5" >Depoimentos</p>
                <Depoimento/>
                <Depoimento/>
                <Depoimento/>
                <Depoimento/>
                <Depoimento/>
            </div>
            <div className="m-5">
                <PageComponent/>
            </div>
            
            <Footer />
        </div>
    );
}

export default Depoimentos