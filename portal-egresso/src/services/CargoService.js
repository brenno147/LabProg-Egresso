import ApiService from '../ApiService'

class CargoService extends ApiService{
    constructor() {
      super('/api/cargos');
    }
    
}

export default CargoService
