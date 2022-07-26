import React from 'react'
import Select from 'react-select'

function SelectInput(props){

    const options = props.options
    const inicial = props.inicial;
    return(
        <div className='mr-2' style={{alignItems: "flex-start",display: "in-line", backgroundColor: "transparent", width:"100%"}}>
            <label className="textInput">{props.value}&nbsp;</label>
            <Select defaultValue={options[inicial]}options={options} onChange={props.inputChange}/>
        </div>
    );
}

export default SelectInput