import axios from "axios";

const instance = axios.create({
    baseURL: 'http://localhost:8090'
})

class ApiService{
    constructor (apiUrl, apiToken) {
        this.apiUrl = apiUrl
        instance.defaults.headers.common['Authorization'] = apiToken;
    }

    post(url,objeto){
        return instance.post(`${this.apiUrl}${url}`, objeto)
    }

    get(url) {
        return instance.get(`${this.apiUrl}${url}`)
    }
}

export default ApiService