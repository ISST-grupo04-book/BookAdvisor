import React from 'react';
import {Link, BrowserRouter} from 'react-router-dom'
import '../../css/pseudoElement.css';
import '../../css/Access/Login.css';


export default class Login extends React.Component {
  render(){
    const styles = {
      login__wrapper : {
        boxShadow: '0px 0px 10px rgba(119, 93, 255,.4)'
      },
      input__login : {
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
      <div className="p-5 h-50 w-75 d-flex flex-column justify-content-start align-items-start bg-white" style={styles.login__wrapper}>
        <h2 className="mb-4 w-100 font-weight-normal">Iniciar sesión</h2>
        <form className="w-100"action="#">
          <label className="w-100 font-weight-normal" for="email">Email:</label><br/>
          <input className="mb-4 p-2 w-100" style={styles.input__login} type="email" id="email" name="email" placeholder="Introduce tu correo electrónico"/><br/>
          <label className="w-100 font-weight-normal" for="psd">Contraseña:</label><br/>
          <input className="mb-2 p-2 w-100" style={styles.input__login} type="password" id="psd" name="psd" placeholder="Introduce tu contraseña"/><br/>
          <div className="mb-4 d-flex">
            <input className="checkbox__login" type="checkbox" id="session" name="session"/>
            <label className="label__login" for="session"><span className="span__login"></span>Mantener sesión iniciada</label>
            <Link className="ml-auto link__hover" style={styles.link}  key="key1" to="#">Restablecer contraseña</Link>
          </div>
          <input className="p-2 w-100 font-weight-light rounded button__hover" style={styles.input__submit} type="submit" value="Iniciar sesión"/>
        </form>
        <BrowserRouter>
        <Link className="my-4 link__hover" style={styles.link} key="key2" to="/signup">Registrarse</Link>
        </BrowserRouter>
      </div>
    );
  }
}