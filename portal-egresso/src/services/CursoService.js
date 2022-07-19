import ApiService from "../ApiService";

class CursoService extends ApiService {
  constructor() {
    super("/api/cursos");
  }

  async quantEgressosPorCurso() {
    return await this.get("/quant-egresso-por-curso");
  }
}

export default CursoService;
