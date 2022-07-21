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

    async obterInvestimentos(nome) {
      const response = this.get(`?nome=${nome}`);
      console.log("GETEgresso",response);
    } 
    
}

export default EgressoService
