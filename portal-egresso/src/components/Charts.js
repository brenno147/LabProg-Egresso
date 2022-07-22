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

export default function Charts({description, labels, chartData, text}) {

  const options = {
    responsive: true,
    plugins: {
      legend: {
        position: "top",
      },
      title: {
        display: true,
        text
      }
    },
  };

  // console.log(chartData)

  const currentLabels = labels ?? ["Insira os valores"];

  const currentChartData = chartData ?? [0];

  const data = {
    labels: currentLabels,
    datasets: [
      {
        label: description,
        data: currentChartData,
        backgroundColor: "rgba(108, 93, 211, 1)",
      },
    ],
  };
  
  return (
    <div className="w-75">
      {description ? (
        <Bar options={options} data={data} />
      ) : (
        <h3 className="text-center">Dados não informados</h3>
      )}
    </div>
  );
}
