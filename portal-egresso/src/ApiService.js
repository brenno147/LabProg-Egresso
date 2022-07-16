import axios from "axios";

const instance = axios.create({
    baseURL: 'http://localhost:8090'
})

class ApiService{
    constructor (apiUrl, apiToken) {
        this.apiUrl = apiUrl
        console.log("Token:",apiToken)
        instance.defaults.headers.common['Authorization'] = apiToken;
    }

    post(url,objeto){
        return instance.post(`${this.apiUrl}${url}`, objeto)
    }
}

export default ApiService