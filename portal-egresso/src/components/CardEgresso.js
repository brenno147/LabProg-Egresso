import React from "react";
import logo from "./../imgs/thumbnail.svg";
// import "admin-lte/plugins/flot/jquery.flot.js";
// import "admin-lte/plugins/flot/plugins/jquery.flot.resize.js";

const CardEgresso = ({nome, cargo, onClick, clickable}) => {

  if(cargo === "undefined"){
    this.cargo = ""
  }

  return (
    <div
      className="col-3 card rounded card pt-4 pb-1 pr-5 pl-5"
      onClick={onClick}
      style={clickable && {cursor: "pointer"}}
    >
      <img src={logo} alt="..." />
      <div className="card-body d-flex flex-column align-items-center">
        <h2 className="card-title mb-2 mt-2">
          <b>{nome}</b>
        </h2>
        <p className="card-text">{cargo}</p>
      </div>
    </div>
  );
}
export default CardEgresso;
