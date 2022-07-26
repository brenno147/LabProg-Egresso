
class Constantes{
   Constantes(){
      this.logado = false;
      this.token = "";
      this.email = "";
      this.id = -1;
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

   setEmail(email){
      this.email = email;
   }

   getId(){
      return this.id;
   }

   setId(id){
      this.id = id;
   }
}

export default Constantes