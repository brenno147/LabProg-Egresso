import React from "react";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
import { Bar } from "react-chartjs-2";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

const options = {
  responsive: true,
  plugins: {
    legend: {
      position: "top",
    },
    title: {
      display: true,
      text: "Faixa Salarial",
    },
  },
};

const labels = [
  "1k-1.5k",
  "1.5k-2k",
  "2k-2.5k",
  "2.5k-3k",
  "3k-3.5k",
  "3.5k-4k",
  "4k-4.5k",
  "4.5k-5k",
];
const dados = [5, 10, 6, 8, 15, 7, 5, 3];

const data = {
  labels,
  datasets: [
    {
      label: "Número de Egressos por Faixa Salarial",
      data: dados,
      backgroundColor: "rgba(108, 93, 211, 1)",
    },
  ],
};

export default function Charts() {
  return (
    <div className="w-75">
      <Bar options={options} data={data} />
    </div>
  );
}
