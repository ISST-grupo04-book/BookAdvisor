import React from 'react';
import {Link} from 'react-router-dom';
import '../../css/pseudoElement.css';

export default class Bookshop extends React.Component {
  render(){
    const styles = {
      bookshop__wrapper : {
        boxShadow: '0px 0px 10px rgba(119, 93, 255,.4)',
        heigth: '85%'
      },
      input__bookshop : {
        border: '1px solid rgba(215, 215, 215,.6)'
      },
      link : {
        textDecoration: 'none',
        color: 'rgb(119, 93, 255)'
      },
      input__submit : {
        backgroundColor: 'rgb(119, 93, 255)',
        color: 'white',
        border: '0px'
      }
    }
    return (
      <div className="p-5 w-75 d-flex flex-column justify-content-start align-items-start bg-white" style={styles.bookshop__wrapper}>
        <h2 className="mb-4 w-100 font-weight-normal">Registro de librería</h2>
        <form className="w-100 h-100" action="#">
          <label className="w-100 font-weight-normal" for="name">Nombre de la librería:</label><br/>
          <input className="mb-3 p-2 w-100" style={styles.input__bookshop} type="text" id="name" name="name" placeholder="Introduce el nombre"/><br/>
          <label className="w-100 font-weight-normal" for="email">Email:</label><br/>
          <input className="mb-3 p-2 w-100" style={styles.input__bookshop} type="email" id="email" name="email" placeholder="Introduce el email"/><br/>
          <label className="w-100 font-weight-normal" for="psd">Contraseña:</label><br/>
          <input className="mb-3 p-2 w-100" style={styles.input__bookshop} type="password" id="psd" name="psd" placeholder="Introduce la contraseña"/><br/>
          <label className="w-100 font-weight-normal" for="loc">Localización:</label><br/>
          <input className="mb-3 p-2 w-100" style={styles.input__bookshop} type="text" id="loc" name="loc" placeholder="Introduce la localización"/><br/>
          <label className="w-100 font-weight-normal" for="cif">CIF:</label><br/>
          <input className="mb-3 p-2 w-100" style={styles.input__bookshop} type="text" id="cif" name="cif" pattern="[A-Z]{1}-[0-9]{8}" placeholder="Introduce el CIF  (Ej: L-97643214)"/><br/>
          <label className="w-100 font-weight-normal" for="url">URL:</label><br/>
          <input className="mb-4 p-2 w-100" style={styles.input__bookshop} type="url" id="url" name="url" placeholder="Introduce la dirección url"/><br/>

          <input className="p-2 w-100 font-weight-light rounded button__hover" style={styles.input__submit} type="submit" value="Registrarse"/>
        </form> 
        <Link className="my-3 link__hover" style={styles.link} key="key2" to="/login">Iniciar sesión</Link>
      </div>
    );
  }
}