import React from "react";
import logo from "./../imgs/thumbnail.svg";
// import "admin-lte/plugins/flot/jquery.flot.js";
// import "admin-lte/plugins/flot/plugins/jquery.flot.resize.js";

export default function CardEgresso() {
  return (
    <div className="card p-2" style={{ width: "18rem" }}>
      <img src={logo} className="card-img-top" alt="..." />
      <div className="card-body d-flex flex-column align-items-center">
        <h2 className="card-title mb-2">
          <b>SARA ARCHIDI</b>
        </h2>
        <p className="card-text">Marketing Coordinator</p>
      </div>
    </div>
  );
}
