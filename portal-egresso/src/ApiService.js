import axios from "axios";

const instance = axios.create({
    baseURL: 'http://localhost:8090'
})

class ApiService{
    constructor(apiUrl){
        this.apiUrl = apiUrl
    }

    post(url,objeto){
        return instance.post(`${this.apiUrl}${url}`, objeto)
    }
}

export default ApiService