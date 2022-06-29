import React from "react";
import CardEgresso from "../components/CardEgresso";
import NavbarComponent from "../components/NavbarComponent";
import PageComponent from "../components/PageComponent";
import Footer from "../components/Footer";

const egressoPage = () => {
  return (
    <>
      <NavbarComponent />
      <div className="container mt-5 mb-5">
        <p className="h1 mt-5 mb-5 text-center" >Egressos</p>
        <div className="row mt-1">
          <div className="col-md-4">
            <CardEgresso></CardEgresso>
          </div>
          <div className="col-md-4">
            <CardEgresso></CardEgresso>
          </div>
          <div className="col-md-4">
            <CardEgresso></CardEgresso>
          </div>
          <div className="col-md-4">
            <CardEgresso></CardEgresso>
          </div>
          <div className="col-md-4">
            <CardEgresso></CardEgresso>
          </div>
          <div className="col-md-4">
            <CardEgresso></CardEgresso>
          </div>
        </div>
        <PageComponent/>
      </div>
      <Footer/>
    </>
  );
};

export default egressoPage;
