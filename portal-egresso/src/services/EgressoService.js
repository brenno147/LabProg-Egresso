import ApiService from '../ApiService'

class EgressoService extends ApiService{
    constructor() {
      super('/api/egressos');
    }
    async fazerCadastro({nome,email,cpf,senha,resumo,urlFoto,contatos,profissoes,cursos}) {
      cursos = [];
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
    
}

export default EgressoService
