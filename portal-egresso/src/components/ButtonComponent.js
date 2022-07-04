import React from 'react';
function ButtonComponent(props) {
  return (
    <div className='button-style-hover'>
        <button  className="button-style" onClick={props.click} type="button">{props.nome}</button>
    </div>
  );
}

export default ButtonComponent