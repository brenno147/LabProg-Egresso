import React from "react";
import logo from "./../imgs/thumbnail.svg";
// import "admin-lte/plugins/flot/jquery.flot.js";
// import "admin-lte/plugins/flot/plugins/jquery.flot.resize.js";

export default function CardEgresso() {
  return (
    <div className="card pt-4 pb-1 pr-5 pl-5" style={{ borderRadius: "7%" }}>
      <img src={logo} style={{ height: "50%", width: "60%" }} alt="..." />
      <div className="card-body d-flex flex-column align-items-center">
        <h2 className="card-title mb-2 mt-2">
          <b>SARA ARCHIDI</b>
        </h2>
        <p className="card-text">Marketing Coordinator</p>
      </div>
    </div>
  );
}
