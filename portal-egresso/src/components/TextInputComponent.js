import React from "react";

function TextInputComponent(props){
    return(
        <div className="input">
            <label className="textInput">{props.value}&nbsp;</label>
            <input type="text" className="input-text-1"/>
        </div>
    );
}

export default TextInputComponent 