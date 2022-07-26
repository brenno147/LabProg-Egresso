
class Constantes{
   Constantes(){
      this.logado = false;
      this.token = "";
      this.email = "";
      this.id = -1;
      this.senha = "";
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

   getId(){
      return this.senha;
   }

   setId(senha){
      this.senha = senha;
   }
}

export default Constantes