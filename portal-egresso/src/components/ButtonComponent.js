import React from 'react';
function ButtonComponent(props) {
  return (
    <div className='button-style-hover'>
      <a href={props.route}>
        <button  className="button-style" onClick={props.nav} type="button">{props.nome}</button>
      </a>
    </div>
  );
}

export default ButtonComponent