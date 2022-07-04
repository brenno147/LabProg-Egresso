import React, { useState } from "react";
import TextInputComponent from "../components/TextInputComponent";
import NavbarComponentLogin from "../components/NavbarComponentLogin";
import Footer from "../components/Footer";
import ButtonComponent from "../components/ButtonComponent";
import ButtonSubmitComponent from "../components/ButtonSubmitComponent";
import DepoimentoTextComponent from "../components/DepoimentoTextComponent";
import SelectInput from "../components/SelectInput";
import DateInput from "../components/DateInput";
import EgressoService from "../services/EgressoService";

function Cadastro() {
  const egressoService = new EgressoService()

  const [egresso, setEgresso] = useState({
    nome: "",
    email: "",
    cpf: "",
    senha: "SenhaTeste",
    resumo: "",
    urlFoto: "teste",
    contatos: [],
    profissoes: [],
    cursos: [],
  });

  const [contatos, setContatos] = useState({
    contatoInsta: "",
    contatoLinke: "",
    contatoGit: "",
  });

  const [curso, setCurso] = useState({
    cursoId: "",
    dataInicio: "",
    dataConclusao: "",
  });

  const [profissao, setProfissao] = useState({
    cargoId: "",
    faixaSalarioId: "",
    empresa: "",
    descricao: "",
    dataRegistro: "",
  });

  const handleChange = (e) => {
    const value = e.target.value;
    setEgresso((prevState) => ({ ...prevState, [e.target.name]: value }));
    console.log(egresso);
  };

  const handleChangeSelectProf = (selectedOption) => {
    setProfissao((prevState) => ({ ...prevState, [selectedOption.nome]: selectedOption.value }));
    console.log(profissao);
  };

  const handleChangeSelectCurso = (selectedOption) => {
    setCurso((prevState) => ({
      ...prevState,
      [selectedOption.nome]: selectedOption.value,
    }));
    console.log(curso);
  };

  const handleChangeContato = (e) => {
    const value = e.target.value;
    setContatos((prevState) => ({ ...prevState, [e.target.name]: value }));
    console.log(contatos);
  };

  const handleChangeCurso = (e) => {
    const value = e.target.value;
    setCurso((prevState) => ({ ...prevState, [e.target.name]: value }));
    console.log(curso);
  };

  const handleChangeProf = (e) => {
    const value = e.target.value;
    setProfissao((prevState) => ({ ...prevState, [e.target.name]: value }));
    console.log(profissao);
  };

  const addContatos = () => {
    setEgresso((prevState) => ({ ...prevState, contatos: [{nome: "Instagram", urlLogo: contatos.contatoInsta}, 
                                                          {nome: "Linkedin", urlLogo: contatos.contatoLinke},
                                                          {nome: "Github", urlLogo: contatos.contatoGit},] 
    }));
    console.log(egresso)
};

const addCurso = () => {
    setEgresso((prevState) => ({ ...prevState, cursos: [...egresso.cursos, curso] }));
    console.log(egresso)
};

  const addProf = () => {
    setEgresso((prevState) => ({ ...prevState, profissoes: [...egresso.profissoes, profissao] }));
    console.log(egresso)
  };

  const handleClickCadastrar = () => {
    addContatos()
    addProf()
    addCurso()
    egressoService.fazerCadastro({...egresso})
  }

  return (
    <div className="">
      <NavbarComponentLogin />
      <div className="d-flex flex-column align-items-center">
        <div className="h1" style={{ marginBottom: "50px", marginTop: "30px" }}>
          Cadastro
        </div>
        <div className="w-50">
          <TextInputComponent
            value="Nome:"
            inputValue={egresso.nome}
            inputChange={(e) => handleChange(e)}
            inputName="nome"
          />
          <TextInputComponent
            value="Email:"
            inputValue={egresso.email}
            inputChange={(e) => handleChange(e)}
            inputName="email"
          />
          <TextInputComponent
            value="Cpf:"
            inputValue={egresso.cpf}
            inputChange={(e) => handleChange(e)}
            inputName="cpf"
          />
          <input
            name="resumo"
            value={egresso.resumo}
            onChange={(e) => handleChange(e)}
            type="text"
            className="input-text mt-3"
            placeholder={"Resumo sobre suas habilidades"}
          />
        </div>
        <div className="h3" style={{ marginBottom: "50px", marginTop: "50px" }}>
          Curso
        </div>
        <div className="d-flex flex-row w-70 mb-5">
          <SelectInput
            value="Curso:"
            options={[
              { nome: "cursoId", value: 1, label: "Chocolate" },
              { nome: "cursoId", value: 2, label: "Strawberry" },
              { nome: "cursoId", value: 3, label: "Vanilla" },
            ]}
            inputChange={(e) => handleChangeSelectCurso(e)}
          />
          <DateInput
            value="Data de Início:"
            inputValue={curso.dataInicio}
            inputChange={(e) => handleChangeCurso(e)}
            inputName="dataInicio"
          />
          <DateInput
            value="Data de Conclusão:"
            inputValue={curso.dataConclusao}
            inputChange={(e) => handleChangeCurso(e)}
            inputName="dataConclusao"
          />
        </div>
        <div style={{ width: "30%" }}>
          <ButtonSubmitComponent value="+ adicionar" />
        </div>
        <div className="h3" style={{ marginBottom: "50px", marginTop: "50px" }}>
          Cargo
        </div>
        <div className="d-flex flex-row w-70 mb-5">
          <SelectInput
            value="Cargo:"
            options={[
              { nome: "cargoId", value: 1, label: "Cargo teste" },
              { nome: "cargoId", value: 2, label: "Chocolate" },
            ]}
            inputChange={handleChangeSelectProf}
          />
          <SelectInput
            value="Faixa Salarial:"
            options={[
              {
                nome: "faixaSalarioId",
                value: 1,
                label: "Faixa Salario teste",
              },
            ]}
            inputChange={handleChangeSelectProf}
          />
          <TextInputComponent
            value="Empresa:"
            inputValue={profissao.empresa}
            inputChange={(e) => handleChangeProf(e)}
            inputName="empresa"
          />
          <TextInputComponent
            value="Descrição do cargo:"
            inputValue={profissao.descricao}
            inputChange={(e) => handleChangeProf(e)}
            inputName="descricao"
          />
          <DateInput
            value="Data de Registro:"
            inputValue={profissao.dataRegistro}
            inputChange={(e) => handleChangeProf(e)}
            inputName="dataRegistro"
          />
        </div>
        <div className="mt-5" style={{ width: "30%" }}>
          <ButtonSubmitComponent value="+ adicionar" />
        </div>
        <div
          className="h3 "
          style={{ marginBottom: "50px", marginTop: "50px" }}
        >
          Contatos
        </div>
        <div className="w-50">
          <TextInputComponent 
            value="Instagram:" 
            inputValue={contatos.contatoInsta}
            inputChange={(e) => handleChangeContato(e)}
            inputName="contatoInsta"/>
          <TextInputComponent 
            value="Linkedin:" 
            inputValue={contatos.contatoLinke}
            inputChange={(e) => handleChangeContato(e)}
            inputName="contatoLinke"/>
          <TextInputComponent 
            value="GitHub:" 
            inputValue={contatos.contatoGit}
            inputChange={(e) => handleChangeContato(e)}
            inputName="contatoGit"/>
        </div>
        <div className="h3" style={{ marginBottom: "50px", marginTop: "50px" }}>
          Depoimento
        </div>
        <DepoimentoTextComponent />
        <div style={{ width: "30%", marginBottom: "30px" }}>
          <ButtonSubmitComponent value="+ adicionar" />
        </div>
        <div
          style={{
            alignSelf: "end",
            display: "flex",
            flexDirection: "row",
            marginTop: "20px",
            marginBottom: "30px",
            marginRight: "60px",
          }}
        >
          <ButtonComponent
            nome="Cadastrar"
            click={() => handleClickCadastrar()}
          />
        </div>
      </div>

      <Footer />
    </div>
  );
}

export default Cadastro;
