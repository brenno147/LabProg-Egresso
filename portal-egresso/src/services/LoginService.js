import ApiService from '../ApiService'

let token = ' ';

class LoginService extends ApiService{
    
    constructor() {
        super('/login');
    }

    async fazerLogin(email,senha){
        try {
            const response = await this.post('',{
                email: email,
                senha: senha
            });
            console.log("Login",response);
            token = response.data;
            return response;
        } catch (erro) {
            token = erro.response.data;
            return token;
        }
    }
}

export default LoginService