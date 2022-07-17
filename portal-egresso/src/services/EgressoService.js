import ApiService from '../ApiService'

class EgressoService extends ApiService{
    constructor() {
        super('/api/egressos');
    }
    async fazerCadastro({nome,email,cpf,senha,resumo,urlFoto,contatos,profissoes,cursos }) {
        try {
          const response = await this.post("/", {
            nome,
            email,
            cpf,
            senha,
            resumo,
            urlFoto,
            contatos,
            profissoes,
            cursos
          });
          console.log(response);
          return response;
        } catch (erro) {
          console.log(erro.response);
          // return erro.response;
        }
    }
    
}

export default EgressoService
