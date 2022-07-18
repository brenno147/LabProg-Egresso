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
            token = response.data;
            return token;
        } catch (erro) {
            token = erro.response.data;
            return token;
        }
    }
}

export default LoginService