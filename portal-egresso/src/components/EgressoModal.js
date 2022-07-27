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
        <button onClick={closeModal} style={{alignSelf: "flex-end"}}>X</button>
        <div className="row w-100 h-100">
          <div className="col d-flex align-items-center">
            <img
              className="mx-auto d-block"
              src={logo}
              style={{ height: "250px" }}
              alt="..."
            />
          </div>
          <div className="col d-flex flex-column justify-content-center">
            <p
              className="text-uppercase text-white"
              style={{ fontSize: "1.5rem" }}
            >
              Sara Archidi
            </p>
            <p style={{ fontSize: "1.2rem", color: "#BDCDEC" }}>
              Marketing Coordinator
            </p>
            <p className="text-light" style={{ fontSize: "1rem" }}>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eaque
              similique temporibus unde aliquam voluptates, tempore nostrum.
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
              <p>email:sara@gmail.com</p>
            </div>
            <div className="w-25 m-3 d-flex justify-content-between">
              <div
                className="p-4 d-flex justify-content-center align-items-center rounded-circle"
                style={{ backgroundColor: "#706FE5" }}
              >
                <Instagram fill="white" />
              </div>
              <div
                className="p-4 d-flex justify-content-center align-items-center rounded-circle"
                style={{ backgroundColor: "#706FE5" }}
              >
                <Linkedin fill="white" />
              </div>
              <div
                className="p-4 d-flex justify-content-center align-items-center rounded-circle"
                style={{ backgroundColor: "#706FE5" }}
              >
                <Github fill="white" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}