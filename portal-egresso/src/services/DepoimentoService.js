import ApiService from "../ApiService";

class DepoimentoService extends ApiService {
  constructor() {
    super("/api/depoimentos");
  }

  async getDepoimentos() {
    return await this.get();
  }
}

export default DepoimentoService;
