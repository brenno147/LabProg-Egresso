import React from "react";
import NavbarComponentLogin from '../components/NavbarComponentLogin'
import TextInputComponent from "../components/TextInputComponent";
import FooterComponent from "../components/FooterComponent";
import ProfComponents from "../components/ProfComponents";
import ButtonSubmitComponent from "../components/ButtonSubmitComponent";
class Cadastro extends React.Component{
    render(){
        return(
            <div>
                <NavbarComponentLogin/>
                <div className="cadastro">
                    <h1 className="h1-text">Cadastro</h1>
                </div>
                <div className="cadastro-text">
                    <TextInputComponent value="Nome: "/>
                    <TextInputComponent value="E-mail: "/>
                    <TextInputComponent value="CPF: "/> 
                </div>
                <div className="cargo">
                    <h1 className="h1-text">Cargo</h1>
                </div>
                <div className="cargo-text">
                    <ProfComponents value="coloque o nome do seu cargo "/>
                </div>
                <div className="buttonAdd-1">
                    <ButtonSubmitComponent value="+ adicionar"/>
                </div>
                <div className="curso">
                    <h1 className="h1-text">Curso</h1>
                </div>
                <div className="curso-text">
                    <ProfComponents value="coloque o nome da sua graduação"/>
                </div>
                <div className="buttonAdd-2">
                    <ButtonSubmitComponent value="+ adicionar"/>
                </div>
                <div className="redes">
                    <h1 className="h1-text">Redes Sociais</h1>
                </div>
                <FooterComponent/>
            </div>
        );
    }
}

export default Cadastro