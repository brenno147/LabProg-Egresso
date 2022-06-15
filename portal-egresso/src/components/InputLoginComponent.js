import React from "react";

function InputLoginComponent(props){
    return(
        <div className="">
            <label className="textInput">{props.value}:</label>
            <br></br>
            <input type="text" className="login-input"/>
        </div>
    );
}

export default InputLoginComponent