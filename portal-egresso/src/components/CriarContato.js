import { faCheck } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React from 'react'


function CriarContato(props){
    return(
        <>
            <div className='row  justify-content-evenly'> 
                <div className='col'>
                    <input type="text" className="input-text" placeholder={props.nome}/>
                </div>
                <div className='col'>
                    <input type="text" className="input-text" placeholder={props.contato}/>
                </div>
                <div className='col-1'>
                    <button className="depoimento-btn"><FontAwesomeIcon icon={faCheck} className="icon"/></button>
                </div>
            </div>
        </>
    );
}

export default CriarContato;