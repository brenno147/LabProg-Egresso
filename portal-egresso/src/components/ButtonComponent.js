import React from 'react';
import Button from 'react-bootstrap/Button';


function ButtonComponent(props) {
  return (
    <div className='button-style-hover'>
      <button  className="button-style" type="button">{props.value}</button>
    </div>
  );
}

export default ButtonComponent