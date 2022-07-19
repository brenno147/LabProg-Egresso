import ApiService from "../ApiService";

class CargoService extends ApiService {
  constructor() {
    super("/api/cargos");
  }

  async quantEgressosPorCargo() {
    return await this.get("/quant-egresso-por-cargo");
  }
}

export default CargoService;
