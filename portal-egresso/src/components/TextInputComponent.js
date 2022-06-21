import React from "react";

function TextInputComponent(props){
    return(
        <div style={{alignItems: "flex-start",display: "in-line", backgroundColor: "transparent", width:"100%"}}>
            <label className="textInput">{props.value}&nbsp;</label>
            <input type="text" className="input-text-1"/>
        </div>
    );
}

export default TextInputComponent 