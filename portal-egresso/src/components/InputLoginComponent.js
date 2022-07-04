import React from "react";

function InputLoginComponent(props){
    return(
        <div>
            <label className="textInput">{props.label}:</label>
            <br></br>
            <input type="text" className="login-input"/>
        </div>
    );
}

export default InputLoginComponent