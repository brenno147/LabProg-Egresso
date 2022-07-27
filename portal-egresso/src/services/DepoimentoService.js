import ApiService from "../ApiService";

class DepoimentoService extends ApiService {
  constructor() {
    super("/api/depoimentos");
  }

  async getDepoimentos() {
    return await this.get('/depoimentos-recentes');
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
    
}

export default DepoimentoService;
