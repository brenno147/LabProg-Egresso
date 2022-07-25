import axios from "axios";
import constantes from "./Constantes";

const instance = axios.create({
    baseURL: 'http://localhost:8090'
})

class ApiService{
    constructor (apiUrl) {
        this.apiUrl = apiUrl
        instance.defaults.headers.get["Authorization"] = constantes.token;
    }

    post(url,objeto){
        return instance.post(`${this.apiUrl}${url}`, objeto)
    }

    put(url,objeto){
        return instance.put(`${this.apiUrl}${url}`,objeto)
    }

    delete(url){
        return instance.delete(`${this.apiUrl}${url}`)
    }

    get(url){
        
        return instance.get(`${this.apiUrl}${url}`)
    }
}

export default ApiService