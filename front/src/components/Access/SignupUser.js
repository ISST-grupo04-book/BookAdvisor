import React from 'react';
import {Link} from 'react-router-dom';
import '../../css/pseudoElement.css';

export default class SignupUser extends React.Component {
  render(){
    const styles = {
      user__wrapper : {
        boxShadow: '0px 0px 10px rgba(119, 93, 255,.4)'
      },
      input__user : {
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
    <div className="p-5 h-75 w-75 d-flex flex-column justify-content-start align-items-start bg-white" style={styles.user__wrapper}>
      <h2 className="mb-4 w-100 font-weight-normal">Registro de usuario</h2>
      <form className="w-100 h-100"action="#">
        <label className="w-100 font-weight-normal" for="name">Nombre:</label><br/>
        <input className="mb-3 p-2 w-100" style={styles.input__user} type="text" id="name" name="name" placeholder="Introduce tu nombre"/><br/>
        <label className="w-100 font-weight-normal" for="email">Email:</label><br/>
        <input className="mb-3 p-2 w-100" style={styles.input__user} type="email" id="email" name="email" placeholder="Introduce tu email"/><br/>
        <label className="w-100 font-weight-normal" for="tel">Teléfono:</label><br/>
        <input className="mb-3 p-2 w-100" style={styles.input__user} type="tel" id="tel" name="tel" pattern="[0-9]{9}" placeholder="Introduce tu teléfono"/><br/>
        <label className="w-100 font-weight-normal" for="psd">Contraseña:</label><br/>
        <input className="mb-3 p-2 w-100" style={styles.input__user} type="password" id="psd" name="psd" placeholder="Introduce tu contraseña"/><br/>
        <label className="w-100 font-weight-normal" for="loc">Localización:</label><br/>
        <input className="mb-4 p-2 w-100" style={styles.input__user} type="text" id="loc" name="loc" placeholder="Introduce tu localización"/><br/>
  
        <input className="p-2 w-100 font-weight-light rounded button__hover" style={styles.input__submit} type="submit" value="Registrarse"/>
      </form>
      <div className="w-100 d-flex justify-content-between align-items-center">
        <Link className="my-3 link__hover" style={styles.link} key="key2" to="/login">Iniciar sesión</Link>
        <Link className="my-3 link__hover" style={styles.link} key="key23" to="/">Inicio</Link>
      </div>
    </div>
    );
  }
}