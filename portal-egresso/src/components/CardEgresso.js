import React from "react";
import logo from "./../imgs/thumbnail.svg";
// import "admin-lte/plugins/flot/jquery.flot.js";
// import "admin-lte/plugins/flot/plugins/jquery.flot.resize.js";

export default function CardEgresso() {
  function toggleModal() {
    let modal = document.getElementById("modal");
    console.log(modal);
  }

  return (
    <div
      className="d-flex justify-content-center card pt-4 pb-1 pr-5 pl-5"
      style={{ borderRadius: "7%", cursor: "pointer" }}
      onClick={toggleModal}
    >
      <img src={logo} alt="..." />
      <div className="card-body d-flex flex-column align-items-center">
        <h2 className="card-title mb-2 mt-2">
          <b>SARA ARCHIDI</b>
        </h2>
        <p className="card-text">Marketing Coordinator</p>
      </div>
    </div>
  );
}
