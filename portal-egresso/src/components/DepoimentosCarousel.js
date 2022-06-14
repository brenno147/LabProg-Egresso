import React from "react";
import depoimentoPreview from "./../imgs/clientReview.svg";

export default function DepoimentosCarousel() {
  return (
    <div
      id="carouselExampleControls"
      className="carousel slide"
      data-ride="carousel"
    >
      <div className="carousel-inner">
        <div className="carousel-item active">
          <img
            src={depoimentoPreview}
            className="d-block w-100"
            alt="depoimento"
          />
        </div>
        <div className="carousel-item">
          <img
            src={depoimentoPreview}
            className="d-block w-100"
            alt="depoimento"
          />
        </div>
        <div className="carousel-item">
          <img
            src={depoimentoPreview}
            className="d-block w-100"
            alt="depoimento"
          />
        </div>
      </div>
      <button
        className="carousel-control-prev"
        type="button"
        data-target="#carouselExampleControls"
        data-slide="prev"
      >
        <span className="carousel-control-prev-icon" aria-hidden="true" />
        <span className="sr-only">Previous</span>
      </button>
      <button
        className="carousel-control-next"
        type="button"
        data-target="#carouselExampleControls"
        data-slide="next"
      >
        <span className="carousel-control-next-icon" aria-hidden="true" />
        <span className="sr-only">Next</span>
      </button>
    </div>
  );
}
