import React from "react";

function TextInputComponent(props){
    return(
        <div className='mr-2' style={{alignItems: "flex-start",display: "in-line", backgroundColor: "transparent", width:"100%"}}>
            <label className="textInput">{props.value}&nbsp;</label>
            <input name={props.inputName} value = {props.inputValue} onChange = {props.inputChange} type="text" className="input-text-1"/>
        </div>
    );
}

export default TextInputComponent 