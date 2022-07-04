import React, { useState } from 'react'
import TextInputComponent from '../components/TextInputComponent';
import NavbarComponentLogin from '../components/NavbarComponentLogin';
import Footer from '../components/Footer';
import ButtonComponent from '../components/ButtonComponent';
import ButtonSubmitComponent from '../components/ButtonSubmitComponent';
import DepoimentoTextComponent from '../components/DepoimentoTextComponent';
import SelectInput from '../components/SelectInput';
import DateInput from '../components/DateInput';

function Cadastro(){

    const [egresso, setEgresso] = useState({
        nome: '',
        email: '',
        cpf: '',
        senha: '',
        resumo: '',
        urlFoto: '',
        contatos: [{
            nome: '',
            urlLogo: '',
        }],
        profissoes: [],
        cursos: [
        //{
            //cursoId: '',
            //dataInicio: '',
            //dataConclusao: ''
        //}
        ]
    })

    const [profissao, setProfissao] = useState({
        cargoId: '',
        faixaSalarioId: '',
        empresa: '',
        descricao: '',
        dataRegistro: ''
    })

    const handleChange = (e) => {
        const value = e.target.value;
        setEgresso({ ...egresso, [e.target.name]: value });
        console.log(egresso)
      };

      const handleChangeSelect = (selectedOption) => {
        setProfissao({ ...profissao, [selectedOption.nome]: selectedOption.value });
        console.log(profissao)
      };


      const handleChangeProf = (e) => {
        const value = e.target.value;
        setProfissao({ ...profissao, [e.target.name]: value });
        console.log(profissao)
      };

    const addProf = () => {
        setEgresso({...egresso, profissoes: [...egresso.profissoes, profissao]})
        console.log(egresso)
    }



    return(
        <div className="">
            <NavbarComponentLogin/>
            <div className="d-flex flex-column align-items-center">
                <div className="h1" style={{marginBottom:"50px", marginTop:"30px"}}>
                    Cadastro
                </div>
                <div className='w-50'>
                    <TextInputComponent value="Nome:" inputValue={egresso.nome} inputChange={(e) =>handleChange(e)} inputName="nome"/>
                    <TextInputComponent value="Email:" inputValue={egresso.email} inputChange={(e) =>handleChange(e)} inputName="email"/>
                    <TextInputComponent value="Cpf:" inputValue={egresso.cpf} inputChange={(e) =>handleChange(e)} inputName="cpf"/>
                    <input name="resumo" value={egresso.resumo} onChange={(e) => handleChange(e)} type="text" className="input-text mt-3" placeholder={"Resumo sobre suas habilidades"}/>
                </div>
                <div  className="h3" style={{marginBottom:"50px", marginTop:"50px"}}>
                    Curso
                </div>
                <div className='d-flex flex-row w-70 mb-5'>
                    <SelectInput value = "Curso:" options = {[{ value: 'chocolate', label: 'Chocolate' },
                                            { value: 'strawberry', label: 'Strawberry' },
                                            { value: 'vanilla', label: 'Vanilla' }]}/>
                </div>
                <div style={{width:"30%"}}>
                    <ButtonSubmitComponent value="+ adicionar"/>
                </div>
                <div  className="h3" style={{marginBottom:"50px", marginTop:"50px"}}>
                    Cargo
                </div>
                <div className='d-flex flex-row w-70 mb-5'>
                    <SelectInput value = "Cargo:" options = {[{nome: "cargoId", value: 1, label: 'Cargo teste' },
                                                            {nome: "cargoId",  value: 2, label: 'Chocolate' }]}
                        inputChange={handleChangeSelect}/>
                    <SelectInput value = "Faixa Salarial:" options = {[{nome: "faixaSalarioId", value: 1, label: 'Faixa Salario teste' }]}
                        inputChange={handleChangeSelect}/>
                    <TextInputComponent value="Empresa:" inputValue={profissao.empresa} inputChange={(e) =>handleChangeProf(e)} inputName="empresa"/>
                    <TextInputComponent value="Descrição do cargo:" inputValue={profissao.descricao} inputChange={(e) =>handleChangeProf(e)} inputName="descricao"/>
                    <DateInput value = "Data de Registro:" inputValue={profissao.dataRegistro} inputChange={(e) =>handleChangeProf(e)} inputName="dataRegistro"/>
                </div>
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
                <div
                    style={{
                    alignSelf: "end",
                    display: "flex",
                    flexDirection: "row",
                    marginTop: "20px",
                    marginBottom: "30px",
                    marginRight: "60px",
                    }}>
                    <ButtonComponent nome="Cadastrar" click={() => addProf()}/>
                </div>
            </div>
            
            <Footer/>
        </div>
    );
}

export default Cadastro