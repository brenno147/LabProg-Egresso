import React, { useEffect, useState } from "react";
import TextInputComponent from "../components/TextInputComponent";
import NavbarComponentLogin from "../components/NavbarComponentLogin";
import Footer from "../components/Footer";
import ButtonComponent from "../components/ButtonComponent";
import ButtonSubmitComponent from "../components/ButtonSubmitComponent";
import DepoimentoTextComponent from "../components/DepoimentoTextComponent";
import SelectInput from "../components/SelectInput";
import DateInput from "../components/DateInput";
import EgressoService from "../services/EgressoService";
import { Alert } from "react-bootstrap";
import {useNavigate} from "react-router-dom";

function Cadastro() {
  const egressoService = new EgressoService()
  const navigate = useNavigate();
  const [invalidText, setInvalidText] = useState(false);

  const [egresso, setEgresso] = useState({
    nome: "",
    email: "",
    cpf: "",
    senha: "",
    resumo: "",
    urlFoto: "",
    contatos: [],
    profissoes: [],
    cursos: [],
  });

  const [contatos, setContatos] = useState({
    contatoInsta: "",
    contatoLinke: "",
    contatoGit: "",
  });

  const [curso, setCurso] = useState([{
    cursoId: "",
    dataInicio: "",
    dataConclusao: "",
  }]);

  const [profissao, setProfissao] = useState([{
    cargoId: "",
    faixaSalarioId: "",
    empresa: "",
    descricao: "",
    dataRegistro: "",
  }]);

  const handleChange = (e) => {
    const value = e.target.value;
    setEgresso((prevState) => ({ ...prevState, [e.target.name]: value }));
  };

  const handleChangeSelectProf = (selectedOption, i) => {
    let newProf = [...profissao]
    newProf[i][selectedOption.nome] = selectedOption.value
    setProfissao(newProf);
  };

  const handleChangeProf = (e, i) => {
    let newProf = [...profissao]
    newProf[i][e.target.name] = e.target.value
    setProfissao(newProf)
  };

  const addProfField = () => {
    setProfissao([...profissao, {nome: "", faixaSalarioId: "", empresa: "", descricao: "", dataRegistro: ""}])
  }

  const removeProfFields = (i) => {
    let newProf = [...profissao]
    newProf.splice(i,1);
    setProfissao(newProf)
  }

  const handleChangeSelectCurso = (selectedOption, i) => {
    let newCurso = [...curso]
    newCurso[i][selectedOption.nome] = selectedOption.value
    setCurso(newCurso);
  };

  const handleChangeCurso = (e, i) => {
    let newCurso = [...curso]
    newCurso[i][e.target.name] = e.target.value
    setCurso(newCurso)
  };

  const addCursoField = () => {
    setCurso([...curso, {cargoId: "", nivel:"", dataInicio: "", dataConclusao: ""}])
  }

  const removeCursoFields = (i) => {
    let newCurso = [...curso]
    newCurso.splice(i,1);
    setCurso(newCurso)
  }

  const handleChangeContato = (e) => {
    const value = e.target.value;
    setContatos((prevState) => ({ ...prevState, [e.target.name]: value }));
  };

  useEffect(() => {
    console.log(egresso) 
  }, [egresso])
  
  useEffect(() => {
    setEgresso((prevState) => ({ ...prevState, profissoes: profissao }));
    console.log(profissao)
  }, [profissao])

  useEffect(() => {
    setEgresso((prevState) => ({ ...prevState, cursos: curso }));
    console.log(curso)
  }, [curso])

  useEffect(() => {
    setEgresso((prevState) => ({ ...prevState, contatos: [{nome: "Instagram", urlLogo: contatos.contatoInsta}, 
                                                          {nome: "Linkedin", urlLogo: contatos.contatoLinke},
                                                          {nome: "Github", urlLogo: contatos.contatoGit},] }));
    console.log(contatos)
  }, [contatos])

  const handleClickCadastrar = () => {
    if (
      egresso.nome.trim() === "" ||
      egresso.email.trim() === "" ||
      egresso.cpf.trim() === "" ||
      egresso.resumo.trim() === ""
    )  {
      setInvalidText("Preencha corretamente as suas informações pessoais");
    } else if (
      (egresso.profissoes.length === 1 && egresso.profissoes[0].cargoId === '') ||
      (egresso.cursos.length === 1 && egresso.cursos[0].cursoId === "")
    ) {
      setInvalidText("Insira pelo menos um curso e um cargo");
    } else {
      egressoService.fazerCadastro({...egresso}).then((dados) =>{
        console.log("Respo",dados);
        if (dados.idEgresso > 0){
          navigate("/login");
        }else{
          setInvalidText("Erro ao tentar realizar o cadastro");
        }
    })
      
    }
  }

  return (
    <div className="">
      <NavbarComponentLogin />

      {invalidText && (
        <div className="sticky-top">
          <Alert
            variant="danger"
            onClose={() => setInvalidText(false)}
            dismissible
          >
            {invalidText}
          </Alert>
        </div>
      )}

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
          <div
            className="mr-2"
            style={{
              alignItems: "flex-start",
              display: "in-line",
              backgroundColor: "transparent",
              width: "100%",
            }}
          >
            <label className="textInput">Senha:</label>
            <input
              type="password"
              className="input-text"
              placeholder="Digite sua senha"
              value={egresso.senha}
              onChange={(e) => handleChange(e)}
              name="senha"
            />
          </div>
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
        {curso.map((element, index) => (
          <div className="d-flex flex-row w-70 mb-5" key={index}>
            <SelectInput
              value="Curso:"
              options={[
                { nome: "cursoId", value: 1, label: "Engenharia da Computação" },
                { nome: "cursoId", value: 2, label: "Ciência da Computação" },
                { nome: "cursoId", value: 3, label: "Sistemas de Informação" },
              ]}
              inputChange={(selectedOption) =>
                handleChangeSelectCurso(selectedOption, index)
              }
            />
            <DateInput
              value="Data de Início:"
              inputValue={element.dataInicio || ""}
              inputChange={(e) => handleChangeCurso(e, index)}
              inputName="dataInicio"
            />
            <DateInput
              value="Data de Conclusão:"
              inputValue={element.dataConclusao || ""}
              inputChange={(e) => handleChangeCurso(e, index)}
              inputName="dataConclusao"
            />
            {index ? (
              <button
                type="button"
                className="button remove"
                onClick={() => removeCursoFields(index)}
              >
                Remover
              </button>
            ) : null}
          </div>
        ))}
        <div className="mt-5">
          <button
            className="button add"
            type="button"
            onClick={() => addCursoField()}
          >
            + adicionar
          </button>
        </div>
        <div className="h3" style={{ marginBottom: "50px", marginTop: "50px" }}>
          Cargo
        </div>
        {profissao.map((element, index) => (
          <div className="d-flex flex-row w-70 mb-5" key={index}>
            <SelectInput
              value="Cargo:"
              options={[
                { nome: "cargoId", value: 1, label: "Analista de Sistemas" },
                { nome: "cargoId", value: 2, label: "Engenheiro de Software" },
                { nome: "cargoId", value: 3, label: "DBA" },
                { nome: "cargoId", value: 4, label: "Cientista de Dados" },
                { nome: "cargoId", value: 5, label: "Professor na área de TI" },
                { nome: "cargoId", value: 6, label: "Outro" },
              ]}
              inputChange={(selectedOption) =>
                handleChangeSelectProf(selectedOption, index)
              }
            />
            <SelectInput
              value="Faixa Salarial:"
              options={[
                {
                  nome: "faixaSalarioId",
                  value: 1,
                  label: "1.000-5.000",
                },
                {
                  nome: "faixaSalarioId",
                  value: 2,
                  label: "6.000-12.000",
                },
                {
                  nome: "faixaSalarioId",
                  value: 3,
                  label: "13.000-26.000",
                },
                {
                  nome: "faixaSalarioId",
                  value: 4,
                  label: "Maior que 26.000",
                },
              ]}
              inputChange={(selectedOption) =>
                handleChangeSelectProf(selectedOption, index)
              }
            />
            <TextInputComponent
              value="Empresa:"
              inputValue={element.empresa || ""}
              inputChange={(e) => handleChangeProf(e, index)}
              inputName="empresa"
            />
            <TextInputComponent
              value="Descrição do cargo:"
              inputValue={element.descricao || ""}
              inputChange={(e) => handleChangeProf(e, index)}
              inputName="descricao"
            />
            <DateInput
              value="Data de Registro:"
              inputValue={element.dataRegistro || ""}
              inputChange={(e) => handleChangeProf(e, index)}
              inputName="dataRegistro"
            />
            {index ? (
              <button
                type="button"
                className="button remove"
                onClick={() => removeProfFields(index)}
              >
                Remover
              </button>
            ) : null}
          </div>
        ))}
        <div className="mt-5">
          <button
            className="button add"
            type="button"
            onClick={() => addProfField()}
          >
            + adicionar
          </button>
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
            inputName="contatoInsta"
          />
          <TextInputComponent
            value="Linkedin:"
            inputValue={contatos.contatoLinke}
            inputChange={(e) => handleChangeContato(e)}
            inputName="contatoLinke"
          />
          <TextInputComponent
            value="GitHub:"
            inputValue={contatos.contatoGit}
            inputChange={(e) => handleChangeContato(e)}
            inputName="contatoGit"
          />
        </div>
        <div className="h3" style={{ marginBottom: "50px", marginTop: "50px" }}>
          Depoimento
        </div>
        <DepoimentoTextComponent />
        {/* <div style={{ width: "30%", marginBottom: "30px" }}>
          <ButtonSubmitComponent value="+ adicionar" />
        </div> */}
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
