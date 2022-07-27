import React from "react";
import logo from "./../imgs/thumbnail.svg";
import { ReactComponent as Linkedin } from "./../imgs/linkedin.svg";
import { ReactComponent as Instagram } from "./../imgs/instagram.svg";
import { ReactComponent as Github } from "./../imgs/github.svg";

export default function EgressoModal({egresso, closeModal}) {
  return (
    <div
      className="position-fixed d-flex align-items-center"
      style={{
        width: "100vw",
        height: "100vh",
        zIndex: 999,
        backgroundColor: "rgba(0, 0, 0, .5)",
      }}
    >
      <div
        className="container w-50 h-50 rounded d-flex flex-column align-items-center justify-content-center py-3"
        style={{ backgroundColor: "#2E3E5C" }}
      >
        <button onClick={closeModal} style={{ alignSelf: "flex-end" }}>
          X
        </button>
        <div className="row w-100 h-100">
          <div className="col d-flex justify-content-center align-items-center">
            <img className="h-100" src={logo} alt="..." />
          </div>
          <div className="col d-flex flex-column justify-content-center">
            <p
              className="text-uppercase text-white"
              style={{ fontSize: "1.5rem" }}
            >
              {egresso.nome}
            </p>
            <p style={{ fontSize: "1.2rem", color: "#BDCDEC" }}>
              {egresso.profissao[0].cargo.nome}
            </p>
            <p className="text-light" style={{ fontSize: "1rem" }}>
              {egresso.resumo}
            </p>
          </div>
        </div>
        <div className="row w-100">
          <div className="col d-flex flex-column align-items-center">
            <div
              className="text-white text-center"
              style={{ fontSize: "1.2rem", fontWeight: "700" }}
            >
              <p>Contatos:</p>
              <p>{egresso.email}</p>
            </div>
            <div className="w-25 m-3 gap-2 d-flex justify-content-between">
              <a
                className="p-4 d-flex justify-content-center align-items-center rounded-circle"
                style={{ backgroundColor: "#706FE5" }}
                href={
                  egresso.contatos[0].url_logo
                    ? egresso.contatos[0].url_logo
                    : "https://www.instagram.com"
                }
              >
                <Instagram fill="white" />
              </a>
              <a
                className="p-4 d-flex justify-content-center align-items-center rounded-circle"
                style={{ backgroundColor: "#706FE5" }}
                href={
                  egresso.contatos[1].url_logo
                    ? egresso.contatos[1].url_logo
                    : "https://www.linkedin.com"
                }
              >
                <Linkedin fill="white" />
              </a>
              <a
                className="p-4 d-flex justify-content-center align-items-center rounded-circle"
                style={{ backgroundColor: "#706FE5" }}
                href={
                  egresso.contatos[1].url_logo
                    ? egresso.contatos[1].url_logo
                    : "https://www.github.com"
                }
              >
                <Github fill="white" />
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}