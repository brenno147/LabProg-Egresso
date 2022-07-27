import ApiService from "../ApiService";
import constantes from "../Constantes";

class DepoimentoService extends ApiService {
  constructor() {
    super("/api/depoimentos");
  }

  async getDepoimentos() {
    return await this.get('');
  }

  async depoimentos(id) {
    const response = this.get(`/depoimentos-por-egresso/${id}`);
    console.log("Depoimentos:",response);
    return (await response).data;
    
  }

  async deletar(id) {
    const response = this.delete(`/${id}`);
    console.log("Delete:",response);
    return (await response);
    
  }

  async salvar() {
    const response = this.post('/',{
      idEgresso: constantes.id,
      texto:"depoimento",
      data:"2022-03-03"
    });
    console.log("AddDep:",response);
    return (await response);
    
  }

  async editar(depoimento){
    console.log("dep",depoimento)
    const response = await this.put(`/${constantes.id}`,
    depoimento)
  }  
}

export default DepoimentoService;
