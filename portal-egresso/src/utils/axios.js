import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:8090/",
});

axios.interceptors.request.use((config) => {
  return config;
});

axios.interceptors.response.use((res) => {
  console.log("Response", res);
  return res;
});

export default instance;
