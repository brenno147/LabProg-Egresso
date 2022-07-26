import ApiService from "../ApiService";

class DepoimentoService extends ApiService {
  constructor() {
    super("/api/depoimentos");
  }

  async getDepoimentos() {
    return await this.get();
  }

  async depoimentos(id) {
    const response = this.get(`/depoimentos-por-egresso/${id}`);
    console.log("Depoimentos:",response);
    return (await response).data;
    
  }
    
}

export default DepoimentoService;
