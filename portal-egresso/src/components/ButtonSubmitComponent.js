import React from "react";

function ButtonSubmitComponent(props){
    return(
        <input type="submit" className="buttonadd" 
        value={props.value}/>
    );
}

export default ButtonSubmitComponent 