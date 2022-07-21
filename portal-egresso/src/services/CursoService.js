import ApiService from '../ApiService'

class CursoService extends ApiService{
    constructor() {
      super('/api/cursos');
    }
    
    
}

export default CursoService
