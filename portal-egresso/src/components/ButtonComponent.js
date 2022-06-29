import React from 'react';
function ButtonComponent(props) {
  return (
    <div className='button-style-hover'>
      <button  className="button-style" type="button">{props.nome}</button>
    </div>
  );
}

export default ButtonComponent