import React from 'react'
import TextInputComponent from '../components/TextInputComponent';
import NavbarComponentLogin from '../components/NavbarComponentLogin';
import Footer from '../components/Footer';
import ProfComponents from '../components/ProfComponents';
import ButtonComponent from '../components/ButtonComponent';
import ButtonSubmitComponent from '../components/ButtonSubmitComponent';
import DepoimentoTextComponent from '../components/DepoimentoTextComponent';
import Curso from '../components/Curso';
import Cargo from '../components/Cargo';
import CriarContato from '../components/CriarContato';

function Cadastro(){
    return(
        <div className="">
            <NavbarComponentLogin/>
            <div className="d-flex flex-column align-items-center">
                <div className="h1" style={{marginBottom:"50px", marginTop:"30px"}}>
                    Cadastro
                </div>
                <div className='w-50'>
                    <TextInputComponent value="Nome:"/>
                    <TextInputComponent value="Email:"/>
                    <TextInputComponent value="Cpf:"/>
                    <input type="text" className="input-text mt-3" placeholder={"Resumo sobre suas habilidades"}/>
                </div>
                <div  className="h3" style={{marginBottom:"50px", marginTop:"50px"}}>
                    Curso
                </div>
                <div className='w-70 mb-5'>
                    <Curso curso="curso" nivel="nivel"/>
                </div>
                <div style={{width:"30%"}}>
                    <ButtonSubmitComponent value="+ adicionar"/>
                </div>
                <div  className="h3" style={{marginBottom:"50px", marginTop:"50px"}}>
                    Cargo
                </div>
                    <Cargo cargo="nome" descricao="breve descrição do seu cargo"/>
                <div  className='mt-5' style={{width:"30%"}}>
                    <ButtonSubmitComponent value="+ adicionar"/>
                </div>
                <div  className="h3 " style={{marginBottom:"50px", marginTop:"50px"}}>
                   Contatos
                </div>
                <div className='w-50'>
                    <TextInputComponent value="Instagram:"/>
                    <TextInputComponent value="Twitter:"/>
                    <TextInputComponent value="GitHub:"/>
                </div>
                <div  className="h3" style={{marginBottom:"50px", marginTop:"50px"}}>
                    Depoimento
                </div>
                    <DepoimentoTextComponent/>
                <div style={{width:"30%", marginBottom:"30px"}}>
                    <ButtonSubmitComponent value="+ adicionar"/>
                </div>
                <div style={{alignSelf:"end", display:"flex", flexDirection:"row", marginTop:"20px", marginBottom:"30px", marginRight:"60px"}}>
                    <ButtonComponent nome="Cadastrar"/>
                </div>
            </div>
            
            <Footer/>
        </div>
    );
}

export default Cadastro