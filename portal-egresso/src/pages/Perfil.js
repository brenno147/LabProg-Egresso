import React, {useEffect, useState} from "react";
import Footer from '../components/Footer';
import EgressoService from '../services/EgressoService';
import constantes from "../Constantes";
import NavbarComponentLogin from "../components/NavbarComponentLogin";
import Card from '@mui/material/Card';
import { Avatar } from "@mui/material";
import CardContent from '@mui/material/CardContent';
import ButtonComponent from "../components/ButtonComponent"
import Typography from '@mui/material/Typography';
import {useNavigate} from "react-router-dom";

function Perfil(){
    const navigate = useNavigate();
    const service = new EgressoService();
    let [nome, setNome] = useState();
    let [email, setEmail] = useState();
    let [cpf, setCPF] = useState();
    let [resumo, setResumo] = useState();
    let [linkedin, setLinkedin] = useState();
    let [git, setGit] = useState();
    let [insta, setInsta] = useState();
    let [cursos, setCursos] = useState([]);
    let [cargos, setCargos] = useState([]);
    let [depoimentos, setDepoimentos] = useState([]);
    let dados, depoimento;

    useEffect( () => {
        async function fectchData() {
            dados = await service.dadosPerfil(constantes.email);
            depoimento = await service.
            setNome(dados["nome"]);
            setEmail(dados["email"]);
            setCPF(dados["cpf"]);
            setResumo(dados["resumo"]);
            setLinkedin(dados["contatos"][0]["url_logo"])
            setGit(dados["contatos"][1]["url_logo"])
            setInsta(dados["contatos"][2]["url_logo"])
            setCursos(dados["datasCursos"])
            setCargos(dados["profissao"])
        }
        fectchData();
    }, [])

    function cursosList(){
        const listItems = cursos.map((curso) =>
            <li>
                {curso["curso"]["nome"]}
                <br/>Nível: {curso["curso"]["nivel"]}
                <br/>Data Inicio: {curso["data_inicio"][2]}/{curso["data_inicio"][1]}/{curso["data_inicio"][0]}
                <br/>Data Fim: {curso["data_conclusao"][2]}/{curso["data_conclusao"][1]}/{curso["data_conclusao"][0]}

            </li>
        );
        return (
            <ol>{listItems}</ol>
        );
    }
    function cargosList(){
        const listItems = cargos.map((cargo) =>
            <li>
                {cargo["cargo"]["nome"]}
                <br/>Descrição: {cargo["descricao"]}
                <br/>Empresa: {cargo["empresa"]}
                <br/>Data Registro: {cargo["dataRegistro"][2]}/{cargo["dataRegistro"][1]}/{cargo["dataRegistro"][0]}
                <br/>Faixa Salarial: {cargo["faixaSalario"]["descricao"]}

            </li>
        );
        return (
            <ol>{listItems}</ol>
        );
    }
    return(
        <div className="">
            <NavbarComponentLogin/>
            <div className="d-flex flex-column align-items-center mt-5 mb-5">
                <Card sx={{ minWidth: 275 }} style={{borderColor:"#9481ff4a",borderStyle:"solid",borderRadius:"8px",width:"60%"}}>
                    <CardContent>
                        <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg" style={{margin:"auto",width:"80px",height:"70px",marginBottom:"30px",marginTop:"30px"}}/>
                        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                            Nome: {nome}
                        </Typography>
                        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                            Email: {email}
                        </Typography>
                        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                            CPF: {cpf}
                        </Typography>
                        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                            Resumo: {resumo}
                        </Typography>
                        <Typography variant="h6" component="div" style={{textAlign:"center", background:"#9481ff2e",borderRadius:"8px",marginBottom:"20px",marginTop:"20px"}}>
                            Contatos
                        </Typography>
                        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                            Linkedin: {linkedin}
                        </Typography>
                        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                            GitHub: {git}
                        </Typography>
                        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                            Instagram: {insta}
                        </Typography>
                        <Typography variant="h6" component="div" style={{textAlign:"center", background:"#9481ff2e",borderRadius:"8px",marginBottom:"20px",marginTop:"20px"}}>
                            Cursos
                        </Typography>
                        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                            {cursosList()}
                        </Typography>
                        <Typography variant="h6" component="div" style={{textAlign:"center", background:"#9481ff2e",borderRadius:"8px",marginBottom:"20px",marginTop:"20px"}}>
                            Cargos
                        </Typography>
                        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                            {cargosList()}
                        </Typography>
                    </CardContent>
                    <div style={{align:"end", justifySelf:"end" ,marginTop:"5px", marginBottom:"10px", marginLeft:"15px", width:"8%"}}>
                        <ButtonComponent nome="editar" click={() => navigate("/editarperfil")}/>
                    </div>
                </Card>
            </div>
                <Footer/>
        </div>
    );
}

export default Perfil









