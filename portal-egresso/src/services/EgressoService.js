import ApiService from '../ApiService'

class EgressoService extends ApiService{
    constructor() {
      super('/api/egressos');
    }

    async listEgresso(){
      return await this.get('');
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
        //console.log("\n\nResposta:",response);
        return response.data;
      } catch (erro) {
        // console.log("ERRO:",erro.response);
        return erro.response.data;
      }
    }

    async dadosPerfil(email) {
      try{
        const response = this.get(`/email/${email}`);
        // console.log("GETEgresso",response);
        return (await response).data;
      }catch (erro) {
        console.log("ERRO:",erro.response.data);
        return erro.response.data;
      }
      
    } 

    async editar({nome,email,cpf,senha,resumo,urlFoto,contatos,profissoes,cursos,depoimentos},id) {
      try {
        const response = await this.put(`/editar/${id}`,{
          nome,
          email,
          cpf,
          resumo,
          urlFoto,
          senha,
          contatos,
          cursos,
          profissoes,
          depoimentos
        });
        // console.log("\n\nResposta:",response);
        return response.data;
      } catch (erro) {
        // console.log("ERRO:",erro.response);
        return erro.response.data;
      }
    }

    async deletarProfEgresso(idProfEgresso){
      await this.delete(`/editar/profEgresso/${idProfEgresso}`)
    }
    
}

export default EgressoService
