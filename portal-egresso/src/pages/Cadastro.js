import React from 'react'
import TextInputComponent from '../components/TextInputComponent';
import NavbarComponentLogin from '../components/NavbarComponentLogin';
import Footer from '../components/Footer';
import ProfComponents from '../components/ProfComponents';
import ButtonComponent from '../components/ButtonComponent';
import ButtonSubmitComponent from '../components/ButtonSubmitComponent';
import DepoimentoTextComponent from '../components/DepoimentoTextComponent';

function Cadastro(){
    return(
        <div className="">
            <NavbarComponentLogin/>
            <div className="d-flex flex-column align-items-center">
                <div className="h1" style={{marginBottom:"50px", marginTop:"30px"}}>
                    Cadastro
                </div>
                <TextInputComponent value="Nome:"/>
                <TextInputComponent value="Email:"/>
                <TextInputComponent value="Cpf:"/>
                <div  className="h3" style={{marginBottom:"20px", marginTop:"30px"}}>
                    Curso
                </div>
                <ProfComponents value="Nome do seu curso de formação"/>
                <div style={{width:"30%"}}>
                    <ButtonSubmitComponent value="+ adicionar"/>
                </div>
                <div  className="h3" style={{marginBottom:"20px", marginTop:"30px"}}>
                    Cargo
                </div>
                <ProfComponents value="Nome do seu cargo"/>
                <div style={{width:"30%"}}>
                    <ButtonSubmitComponent value="+ adicionar"/>
                </div>
                <div  className="h3" style={{marginBottom:"20px", marginTop:"30px"}}>
                    Redes Sociais
                </div>
                <TextInputComponent value="Instagram:"/>
                <TextInputComponent value="Twitter:"/>
                <TextInputComponent value="GitHub:"/>
                <div style={{width:"30%"}}>
                    <ButtonSubmitComponent value="+ adicionar"/>
                </div>
                <div  className="h3" style={{marginBottom:"20px", marginTop:"30px"}}>
                    Depoimento
                </div>
                <DepoimentoTextComponent/>
                <div style={{width:"30%", marginBottom:"30px"}}>
                    <ButtonSubmitComponent value="+ adicionar"/>
                </div>
                <div style={{alignSelf:"end", display:"flex", flexDirection:"row", marginTop:"20px", marginBottom:"30px", marginRight:"60px"}}>
                    <ButtonComponent value="Cadastrar"/>
                </div>
            </div>
            
            <Footer/>
        </div>
    );
}

export default Cadastro