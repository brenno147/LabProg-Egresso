import ApiService from '../ApiService'
import constantes from "../Constantes";

class EgressoService extends ApiService{
    constructor() {
      super('/api/egressos');
    }

    async fazerCadastro({nome,email,cpf,senha,resumo,urlFoto,contatos,profissoes,cursos}) {
      try {
        const response = await this.post('/', {
          nome,
          email,
          cpf,
          resumo,
          urlFoto,
          senha,
          contatos,
          cursos,
          profissoes
        });
        console.log("\n\nResposta:",response);
        return response.data;
      } catch (erro) {
        console.log("ERRO:",erro.response);
        return erro.response.data;
      }
    }

    async dadosPerfil(email) {
      const response = this.get(`/${email}`);
      console.log("GETEgresso",response);
      return (await response).data;
      
    } 
    
}

export default EgressoService
