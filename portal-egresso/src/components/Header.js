import React from "react";

export default function Header() {
  const styles = {
    containerNavBar: {
      backgroundColor: "rgba(91, 122, 181, 1)",
      height: "100%",
    },
    navigationButton: {
      background: "none",
      border: "none",
    },
    navigationButtonsContainer: {
      width: "45%",
    },
    authenticationButtons: {
      backgroundColor: "rgba(46, 62, 92, 1)",
      border: "none",
      borderRadius: "10%",
      fontSize: "16px",
    },
  };

  return (
    <div
      style={styles.containerNavBar}
      className="d-flex justify-content-between align-items-center pt-3 pb-3 pr-5 pl-4"
    >
      <div>
        <p className="h5 text-light">PORTAL</p>
        <p className="h6 text-light">DO EGRESSO</p>
      </div>

      <div
        style={styles.navigationButtonsContainer}
        className="d-flex justify-content-around"
      >
        <button style={styles.navigationButton}>
          <p className="h4 text-light">Home</p>
        </button>
        <button style={styles.navigationButton}>
          <p className="h4 text-light">Egressos</p>
        </button>
        <button style={styles.navigationButton}>
          <p className="h4 text-light">Estatísticas</p>
        </button>
        <button style={styles.navigationButton}>
          <p className="h4 text-light">Depoimentos</p>
        </button>
      </div>

      <div>
        <button
          style={styles.authenticationButtons}
          className="text-light pr-4 pl-4 pt-3 pb-3 mr-4"
        >
          Cadastre-se
        </button>
        <button
          style={styles.authenticationButtons}
          className="text-light pr-3 pl-3 pt-2 pb-2"
        >
          Login
        </button>
      </div>
    </div>
  );
}
