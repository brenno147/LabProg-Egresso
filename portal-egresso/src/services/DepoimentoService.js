import ApiService from '../ApiService'

class DepoimentoService extends ApiService{
  constructor() {
    super('/api/depoimentos');
  }
    
}

export default DepoimentoService
