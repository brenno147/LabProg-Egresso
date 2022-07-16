import ApiService from '../ApiService'

class LoginService extends ApiService{
    
    constructor() {
        super('/login');
    }

     async fazerLogin(email,senha){
        try {
            const response = await this.post('', {
                email: email,
                senha: senha
            });
            console.log(response);
            return response;
        } catch (erro) {
            console.log(erro.response);
            // return erro.response;
        }
    }
}

export default LoginService