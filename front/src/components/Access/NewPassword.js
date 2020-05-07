import React from 'react';
import {Link,Redirect} from 'react-router-dom';
import '../../css/pseudoElement.css';

export default class NewPassword extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
        email : "",
        oldPsd : "",
        newPsd : "",
        newPsd2 : ""
    }
  }

  handleSubmit = (e) => {
    e.preventDefault();
    if(this.state.email.trim() === "" || this.state.oldPsd === "" || this.state.newPsd === "" || this.state.newPsd2 === ""){
        alert("Debe rellenar todos los campos para iniciar sesion");
    }else if (this.state.newPsd !== this.state.newPsd2 ){
        alert("La contraseña debe coincidir");
    }
    else{
        let paramsToUpdate = {
            email : this.state.email.trim(),
            oldPsd : this.state.oldPsd,
            newPsd : this.state.newPsd,
        }
        // fetch con paramsToUpdate
        
        alert("La contraseña se ha restablecido");    
        this.setState({email : "",oldPsd : "",newPsd : "",newPsd2 : ""});
        
        
    }

  }

  handleChange = (e)=> {
    this.setState({[e.target.name] : e.target.value})
    console.log(this.state)  
  }

  render(){
    const styles = {
      psd__wrapper : {
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
      <div className="p-5 h-auto w-75 d-flex flex-column justify-content-start align-items-start bg-white" style={styles.psd__wrapper}>
        <h2 className="mb-4 w-100 font-weight-normal">Cambiar contraseña</h2>
        <form className="w-100">
          <label className="w-100 font-weight-normal" for="email">Email:</label><br/>
          <input className="mb-4 p-2 w-100" style={styles.input__login} type="email" id="email" name="email" 
          value={this.state.email} placeholder="Introduce tu correo electrónico" onChange={(e) => this.handleChange(e)}/><br/>

          <label className="w-100 font-weight-normal" for="oldPsd">Contraseña actual:</label><br/>
          <input className="mb-4 p-2 w-100" style={styles.input__login} type="password" id="oldPsd" name="oldPsd" 
          value={this.state.oldPsd} placeholder="Introduce tu contraseña actual" onChange={(e) => this.handleChange(e)}/><br/>

          <label className="w-100 font-weight-normal" for="newPsd">Nueva contraseña:</label><br/>
          <input className="mb-4 p-2 w-100" style={styles.input__login} type="password" id="newPsd" name="newPsd"
          value={this.state.newPsd} placeholder="Introduce tu nueva contraseña" onChange={(e) => this.handleChange(e)}/><br/>

          <label className="w-100 font-weight-normal" for="newPsd2">Repetir nueva contraseña:</label><br/>
          <input className="mb-4 p-2 w-100" style={styles.input__login} type="password" id="newPsd2" name="newPsd2" 
          value={this.state.newPsd2} placeholder="Repite tu nueva contraseña" onChange={(e) => this.handleChange(e)}/><br/>

          <input className="p-2 w-100 font-weight-light rounded button__hover" style={styles.input__submit} 
          type="submit" value="Restablecer contraseña" onClick={(e) => this.handleSubmit(e)}/>
        </form>
        <div className="w-100 d-flex justify-content-between align-items-center">
            <Link className="mt-4 link__hover" style={styles.link} key="key3" to="/login">Iniciar sesión</Link>
        </div>
      </div>
    );
  }
}