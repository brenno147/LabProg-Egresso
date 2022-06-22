import React from "react";
import logo from "./../imgs/thumbnail.svg";
import { ReactComponent as Facebook } from "./../imgs/facebook.svg";
import { ReactComponent as Instagram } from "./../imgs/instagram.svg";
import { ReactComponent as Github } from "./../imgs/github.svg";
import { ReactComponent as Up } from "./../imgs/chevron-up.svg";
import { ReactComponent as Down } from "./../imgs/chevron-down.svg";

export default function EgressoModal() {
  return (
    <div
      className="d-flex justify-content-center pt-5 pb-5"
      style={{
        backgroundColor: "rgba(46, 62, 92, 1)",
        borderRadius: "2%",
        width: "60%",
        display: "none",
      }}
    >
      <div className="d-flex flex-column justify-content-center text-white mr-5 mb-3">
        <img
          className="mb-4"
          src={logo}
          style={{ height: "250px" }}
          alt="..."
        />
        <div>
          <p
            className="text-center m-0"
            style={{ fontSize: "24px", fontWeight: "500" }}
          >
            Contatos:
          </p>
          <p
            className="text-center"
            style={{ fontSize: "24px", fontWeight: "500" }}
          >
            email: sara@gmail.com
          </p>

          <div className="d-flex justify-content-between ">
            <div
              className="p-2 d-flex justify-content-center align-items-center"
              style={{
                backgroundColor: "rgba(112, 111, 229, 1)",
                borderRadius: "50%",
                width: "65px",
                height: "65px",
              }}
            >
              <Instagram fill="white" />
            </div>
            <div
              className="p-2 d-flex justify-content-center align-items-center"
              style={{
                backgroundColor: "rgba(112, 111, 229, 1)",
                borderRadius: "50%",
                width: "65px",
                height: "65px",
              }}
            >
              <Facebook fill="white" />
            </div>
            <div
              className="p-2 d-flex justify-content-center align-items-center"
              style={{
                backgroundColor: "rgba(112, 111, 229, 1)",
                borderRadius: "50%",
                width: "65px",
                height: "65px",
              }}
            >
              <Github fill="white" />
            </div>
          </div>
        </div>
      </div>

      <div
        style={{ width: "50%" }}
        className="d-flex flex-column justify-content-end text-white"
      >
        <div className="mt-4 mb-4">
          <p style={{ fontSize: "24px" }} className="mb-1">
            SARA ARCHIDI
          </p>
          <p style={{ fontWeight: "300", fontSize: "18px" }}>
            Marketing Coordinator
          </p>
        </div>
        <div className="d-flex bg-light  pr-2 pl-2">
          <div className="pt-3 pb-3 mr-2">
            <p
              className="h3 text-center"
              style={{ color: "rgba(91, 122, 181, 1)" }}
            >
              Depoimentos
            </p>
            <p
              style={{ fontSize: "22px", fontWeight: "400" }}
              className="text-center mb-0"
            >
              Lorem Ipsum is simply dummy text of the printing and typesetting
              industry. Lorem Ipsum has been the industry's standard dummy text
              ever since the 1500s, when an unknown printer took a galley of
              type and scrambled it to make a type specimen book.
            </p>
            <p style={{ fontSize: "22px" }} className="text-right mb-1">
              Data: 10/06/2022
            </p>
          </div>
          <div className="d-flex flex-column justify-content-between">
            <Up fill="rgba(91, 122, 181, 1)" />
            <Down fill="rgba(91, 122, 181, 1)" />
          </div>
        </div>
      </div>
    </div>
  );
}
