import React, { useEffect, useState} from "react";
import EgressoService from '../services/EgressoService';
import constantes from "../Constantes";
import NavbarComponentLogin from "../components/NavbarComponentLogin";
import { Alert } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Footer from "../components/Footer";
import TextInputComponent from "../components/TextInputComponent";
import SelectInput from "../components/SelectInput";
import DateInput from "../components/DateInput";
import DepoimentoTextComponent from "../components/DepoimentoTextComponent";
import ButtonComponent from "../components/ButtonComponent";
import DepoimentoServise from "../services/DepoimentoService";
import CursoService from "../services/CursoService";
import {faEdit, faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";


function EditarPerfil(){
  const egressoService = new EgressoService();
  let dados, j=0;
  const [invalidText, setInvalidText] = useState(false);
  const listaCursos = [], listaCargo = [], listaDepoimentos = [];
  const navigate = useNavigate();
  const dep = new DepoimentoServise();
  const curs = new CursoService(); 

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
    depoimentos:[],
  });

  // Egresso (Pega os valores da caixas de texto)
  const handleChange = (e) => {
    const value = e.target.value;
    setEgresso((prevState) => ({ ...prevState, [e.target.name]: value }));
  };

  useEffect(() => {
    // console.log(egresso) 
  }, [egresso])

  // curso
  const [curso, setCurso] = useState([{
    idEgresso: "",
    cursoId: "",
    dataInicio: "",
    dataConclusao: "",
  }]);

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

  const removeCursoFields = (i) => {
    let newCurso = [...curso]
    if(newCurso[i]["idEgresso"] !== ""){
      curs.deletar(newCurso[i]["idEgresso"],newCurso[i]["cursoId"])
    }
    newCurso.splice(i,1);
    setCurso(newCurso)
  }

  const addCursoField = () => {
    setCurso([...curso, {idEgresso: "", cursoId: "", dataInicio: "", dataConclusao: ""}])
  }

  useEffect(() => {
    setEgresso((prevState) => ({ ...prevState, cursos: curso }));
    // console.log(curso)
  }, [curso])

  // prof
  const [profissao, setProfissao] = useState([{
    idProfEgresso: "",
    cargoId: "",
    faixaSalarioId: "",
    empresa: "",
    descricao: "",
    dataRegistro: "",
  }]);

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
    setProfissao([...profissao, {idProfEgresso: "", nome: "", faixaSalarioId: "", empresa: "", descricao: "", dataRegistro: ""}])
  }

  const removeProfFields = (i) => {
    let newProf = [...profissao]
    if(newProf[i]["idProfEgresso"] !== ""){
      egressoService.deletarProfEgresso(newProf[i]["idProfEgresso"])
    }
    newProf.splice(i,1);
    setProfissao(newProf)
  }

  useEffect(() => {
    setEgresso((prevState) => ({ ...prevState, profissoes: profissao }));
    // console.log(profissao)
  }, [profissao])



  //contatos
  const [contatos, setContatos] = useState({
    contatoInsta: "",
    contatoLinke: "",
    contatoGit: "",
  });

  const handleChangeContato = (e) => {
    const value = e.target.value;
    setContatos((prevState) => ({ ...prevState, [e.target.name]: value }));
  };

  useEffect(() => {
    setEgresso((prevState) => ({ ...prevState, contatos: [{nome: "Instagram", urlLogo: contatos.contatoInsta}, 
                                                          {nome: "Linkedin", urlLogo: contatos.contatoLinke},
                                                          {nome: "Github", urlLogo: contatos.contatoGit},] }));
    // console.log(contatos)
  }, [contatos])



  // depoimentos

  const [depoimento, setDepoimento] = useState([{
    id: "",
    texto: "",
    data: "",
  }]);

  const handleChangeDepoimento = (e, i) => {
    let newDepoimento = [...depoimento]
    newDepoimento[i]["texto"] = e.target.value
    setDepoimento(newDepoimento)
  };

  const addDepField = () => {
    setDepoimento([...depoimento, {id: "", texto: "",
    data: ""}])
    dep.salvar()
    
  }

  const removeDepFields = (i) => {
    let newDepoimento = [...depoimento]
    if(newDepoimento[i]["id"] != ""){
      dep.deletar(newDepoimento[i]["id"]);
    }
    newDepoimento.splice(i,1);
    setDepoimento(newDepoimento)
  }

  useEffect(() => {
    dados = egressoService.dadosPerfil(constantes.email);
    setEgresso((prevState) => ({ ...prevState, depoimentos: depoimento }));
    // console.log(curso)
  }, [depoimento])



  useEffect( () => {
    async function fectchData() {
      dados = await egressoService.dadosPerfil(constantes.email);
      console.log("Dados",dados)

      // contatos
      setContatos(
        {
          contatoInsta: dados["contatos"][0]["url_logo"],
          contatoLinke: dados["contatos"][1]["url_logo"],
          contatoGit: dados["contatos"][2]["url_logo"],
        }
      );


      for(j=0;j<dados["datasCursos"].length;j++){
        listaCursos.pop();
      }
      
      for(j=0;j<dados["datasCursos"].length;j++){
        let mes="",dia="",mes2="",dia2="";
        // mes
        if(dados["datasCursos"][j]["data_inicio"][1] > 9){
          mes = dados["datasCursos"][j]["data_inicio"][1];
        }else{
          mes = "0"+dados["datasCursos"][j]["data_inicio"][1];
        }
        // dia
        if(dados["datasCursos"][j]["data_inicio"][2] > 9){
          dia = dados["datasCursos"][j]["data_inicio"][2];
        }else{
          dia = "0"+dados["datasCursos"][j]["data_inicio"][2];
        }

        //mes
        if(dados["datasCursos"][j]["data_conclusao"][1] > 9){
          mes2 = dados["datasCursos"][j]["data_conclusao"][1];
        }else{
          mes2 = "0"+dados["datasCursos"][j]["data_conclusao"][1];
        }
        //dia
        if(dados["datasCursos"][j]["data_conclusao"][2] > 9){
          dia2 = dados["datasCursos"][j]["data_conclusao"][2];
        }else{
          dia2 = "0"+dados["datasCursos"][j]["data_conclusao"][2];
        }


        listaCursos.push(
          {
            idEgresso: parseInt(dados["datasCursos"][j]["egresso"]),
            cursoId: parseInt(dados["datasCursos"][j]["curso"]["id_curso"]),
            dataInicio: (dados["datasCursos"][j]["data_inicio"][0]+"-"+mes+"-"+dia).toString(),
            dataConclusao: (dados["datasCursos"][j]["data_conclusao"][0]+"-"+mes2+"-"+dia2).toString(),
          }
        )
      }
      
      
      for(j=0;j<dados["profissao"].length;j++){
        listaCargo.pop();
      }
      for(j=0;j<dados["profissao"].length;j++){
        let mes,dia;

        //mes
        if(dados["profissao"][j]["dataRegistro"][1] > 9){
          mes = dados["profissao"][j]["dataRegistro"][1];
        }else{
          mes = "0"+dados["profissao"][j]["dataRegistro"][1];
        }
        //dia
        if(dados["profissao"][j]["dataRegistro"][2] > 9){
          dia = dados["profissao"][j]["dataRegistro"][2];
        }else{
          dia = "0"+dados["profissao"][j]["dataRegistro"][2];
        }
        listaCargo.push(
          {
            idProfEgresso: dados["profissao"][j]["idProfEgresso"],
            cargoId: 1,
            faixaSalarioId: 1,
            empresa: dados["profissao"][j]["empresa"],
            descricao: dados["profissao"][j]["descricao"],
            dataRegistro: (dados["profissao"][j]["dataRegistro"][0]+"-"+mes+"-"+dia).toString()
          }
        )
      }
      

      for(j=0;j<dados["depoimento"].length;j++){
        listaDepoimentos.pop();
      }
      for(j=0;j<dados["depoimento"].length;j++){
        listaDepoimentos.push(
          {
            id: dados["depoimento"][j]["id_depoimento"],
            texto: dados["depoimento"][j]["texto"],
            data: dados["depoimento"][j]["data"][0]+"-"+dados["depoimento"][j]["data"][1]+"-"+dados["depoimento"][j]["data"][2]
          }
        )
      };

      setEgresso(
        {
          nome: dados["nome"],
          email: dados["email"],
          cpf: dados["cpf"],
          resumo: dados["resumo"],
          urlFoto: dados["urlFoto"],
          senha: constantes.senha,
        }
      );

      setCurso(listaCursos)
      setProfissao(listaCargo)
      setDepoimento(listaDepoimentos);
      console.log("EgressoDepois:",egresso);
    }
    
    fectchData();
    },[]);

    const handleClickGuardar = () => {
      if (
        egresso.nome.trim() === "" ||
        egresso.email.trim() === "" ||
        egresso.cpf.trim() === "" ||
        egresso.resumo.trim() === ""
      )  {
        setInvalidText("Preencha corretamente as suas informações pessoais");
      }else {
        console.log("Egresso",egresso);
        egressoService.editar({...egresso},constantes.id).then((dados) =>{
          console.log("Respo",dados);
          if (dados["idEgresso"] > 0){
            navigate("/perfil");
          }else{
            setInvalidText("Erro ao tentar guardar as informações");
          }
      })
        
      }
    }

    return(
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
            Perfil
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
            <TextInputComponent
              value="URL da sua foto de perfil:"
              inputValue={egresso.urlFoto}
              inputChange={(e) => handleChange(e)}
              inputName="urlFoto"
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
                  inicial = {element.cursoId || ""}
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
                <div style={{marginLeft:"20px",marginRight:"20px"}}>
                  <DateInput
                    value="Data de Início:"
                    inputValue={element.dataInicio || ""}
                    inputChange={(e) => handleChangeCurso(e, index)}
                    inputName="dataInicio"
                  />
                </div>
                <div style={{marginRight:"20px"}}>
                  <DateInput
                    value="Data de Conclusão:"
                    inputValue={element.dataConclusao || ""}
                    inputChange={(e) => handleChangeCurso(e, index)}
                    inputName="dataConclusao"
                  />
                </div>
                  {index ? (
                    <button class="depoimento-btn" type="button" onClick={() => removeCursoFields(index)}>
                      <FontAwesomeIcon icon={faTrash} className="icon"/>
                    </button>
                ) : null}
              </div>
          ))}
          <div className="mt-5">
            <button
              className="buttonadd"
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
                inicial = {element.cargoId || ""}
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
                inicial = {element.faixaSalarioId || ""}
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
                <button class="depoimento-btn" type="button" onClick={() => removeProfFields(index)}>
                  <FontAwesomeIcon icon={faTrash} className="icon"/>
                </button>
              ) : null}
            </div>
          ))}
          <div className="mt-5">
            <button
              className="buttonadd"
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
          {depoimento.map((element,index) => (
            <div className="d-flex flex-row w-50 mb-5" key={index}>
              <DepoimentoTextComponent
                inputName="Depoimento:"
                inputValue={element.texto || ""}
                inputChange = {(e) => handleChangeDepoimento(e, index)}/>
              {index ? (
                <button className="depoimento-btn" type="button" onClick={() => removeDepFields(index)}>
                  <FontAwesomeIcon icon={faTrash} className="icon"/>
                </button>
              ) : null}
            </div>
          ))}
          <div className="mt-5">
            <button
              className="buttonadd"
              type="button"
              onClick={() => addDepField()}
            >
              + adicionar
            </button>
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
            nome="Guardar"
            click={() => handleClickGuardar()}
          />
        </div>
        </div>
        <Footer />
      </div>
    );
 
}

export default EditarPerfil
