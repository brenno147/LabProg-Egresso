import React from "react";
import CardEgresso from "./CardEgresso";
import Header from "./Header";

const egressoPage = () => {
  return (
    <>
      <Header />
      <div className="container mt-5 mb-5">
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
        <div className="d-flex justify-content-end text-right mt-2">
          <nav>
            <ul className="pagination">
              <li className="page-item">
                <a className="page-link" href="#" aria-label="Previous">
                  <span aria-hidden="true">«</span>
                </a>
              </li>
              <li className="page-item">
                <a className="page-link" href="#">
                  1
                </a>
              </li>
              <li className="page-item">
                <a className="page-link" href="#">
                  2
                </a>
              </li>
              <li className="page-item">
                <a className="page-link" href="#">
                  3
                </a>
              </li>
              <li className="page-item">
                <a className="page-link" href="#">
                  4
                </a>
              </li>
              <li className="page-item">
                <a className="page-link" href="#">
                  5
                </a>
              </li>
              <li className="page-item">
                <a className="page-link" href="#" aria-label="Next">
                  <span aria-hidden="true">»</span>
                </a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </>
  );
};

export default egressoPage;
