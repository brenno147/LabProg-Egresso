import ApiService from "../ApiService";

class FaixaSalarioService extends ApiService {
  constructor() {
    super("/api/faixasalario");
  }

  async quantEgressosPorFaixaSalario() {
    return await this.get("/egresso-por-salario");
  }
}

export default FaixaSalarioService;
