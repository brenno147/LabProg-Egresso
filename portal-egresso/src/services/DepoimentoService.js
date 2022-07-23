import ApiService from '../ApiService'

class DepoimentoService extends ApiService{
  constructor() {
    super('/api/depoimentos');
  }

  async dadosPerfil(email) {
    const response = this.get(`/${email}`);
    console.log("GETEgresso",response);
    return (await response).data;
    
  }
    
}

export default DepoimentoService
