
class Constantes{
   Constantes(){
      this.logado = false;
      this.token = "";
      this.email = "";
   }

   getLogado(){
      return this.logado;
   }

   setLogado(logado){
      this.logado = logado;
   }

   getToken(){
      return this.token;
   }

   setToken(token){
      this.token = token;
   }

   getEmail(){
      return this.email;
   }

   setNome(email){
      this.email = email;
   }
}

export default Constantes