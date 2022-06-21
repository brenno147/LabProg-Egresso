import React from 'react';
import EgressoPage from '../components/EgressoPage';
import CardEgresso from '../components/CardEgresso';
import NavbarComponent from '../components/NavbarComponent';
import Footer from "../components/Footer";

function Egresso(){
    return(
        <div>
            <NavbarComponent />
        <div
            className="d-flex flex-column align-items-center pt-3 pb-5"
            style={{ backgroundColor: "rgba(189, 205, 236, 1)" }}>
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
            <EgressoPage/>
        </div>
        <Footer />
    </div>
    );
}

export default Egresso