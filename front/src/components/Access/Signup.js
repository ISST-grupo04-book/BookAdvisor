import React from 'react';
import {Link, BrowserRouter} from "react-router-dom";
import '../../css/pseudoElement.css';

export default class Signup extends React.Component {
 
  constructor(props){
    super(props);
    this.state = {
      user : false,
      library : false,
      bookshop : false,
      editorial : false
    };
  }

  render(){
    const styles = {
      signup__wrapper : {
        boxShadow: '0px 0px 10px rgba(119, 93, 255,.4)'
      },
      checkbox__label : {
        backgroundColor: '#f1eeff'
      },
      checkbox__description : {
        fontSize: '.7em'
      },
      input__submit : {
        backgroundColor: 'rgb(119, 93, 255)',
        color: 'white',
        border: '0px'
      },
      link : {
        textDecoration: 'none',
        color: 'rgb(119, 93, 255)'
      }
    }

    return (
      <div className="p-5 h-75 w-50 d-flex flex-column justify-content-start align-items-start bg-white" style={styles.signup__wrapper}>
        <h2 className="mb-3 w-100 font-weight-normal">Registrarse</h2>
        <form className="w-100 h-100 d-flex flex-column justify-content-between align-items-start" action=
        {this.state.user ? '/signup/user' : this.state.library ? '/signup/library' : this.state.bookshop ?'/signup/bookshop' : 
        this.state.editorial ? '/signup/editorial' : ''}>
            <input className="d-none"  type="checkbox" id="user" name="user" 
              onChange={() => 
              this.setState({
                user : !this.state.user,
                library : false,
                bookshop : false,
                editorial : false})}/>

            <label className="mb-0 mx-3 p-3 rounded" 
              style={{...styles.checkbox__label, ...{border: this.state.user ? '1px solid rgb(119, 93, 255)' : '0px'}}} for="user">

              <div className="checkbox__content">
                <h5 clasName="checkbox__title">Perfil Usuario</h5>
                <p className="mb-0" style={styles.checkbox__description}>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
              </div>
            </label>

            <input className="d-none" type="checkbox" id="library" name="library"
              onChange={() => 
              this.setState({
                user : false,
                library : !this.state.library,
                bookshop : false,
                editorial : false})}/>
            
            <label className="mb-0 mx-3 p-3 rounded" 
            style={{...styles.checkbox__label, ...{border: this.state.library ? '1px solid rgb(119, 93, 255)' : '0px'}}} for="library">

              <div className="checkbox__content">
                <h5 clasName="checkbox__title">Perfil Biblioteca</h5>
                <p className="mb-0" style={styles.checkbox__description}>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
              </div>
            </label>

            <input className="d-none" type="checkbox" id="bookshop" name="bookshop"
             onChange={() => 
              this.setState({
                user : false,
                library : false,
                bookshop : !this.state.bookshop,
                editorial : false})}
            />
            <label className="mb-0 mx-3 p-3 rounded" 
            style={{...styles.checkbox__label, ...{border: this.state.bookshop ? '1px solid rgb(119, 93, 255)' : '0px'}}} for="bookshop">

              <div className="checkbox__content">
                <h5 clasName="checkbox__title">Perfil Librería</h5>
                <p className="mb-0" style={styles.checkbox__description}>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
              </div>
            </label>

            <input className="d-none" type="checkbox" id="editorial" name="editorial"
              onChange={() => 
              this.setState({
                user : false,
                library : false,
                bookshop : false,
                editorial : !this.state.editorial})}
            />
            <label className="mb-0 mx-3 p-3 rounded" 
            style={{...styles.checkbox__label, ...{border: this.state.editorial ? '1px solid rgb(119, 93, 255)' : '0px'}}} for="editorial">

              <div className="checkbox__content">
                <h5 clasName="mb-auto checkbox__title">Perfil Editorial</h5>
                <p className="mb-0" style={styles.checkbox__description}>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
              </div>
            </label>

            <input className="p-2 w-100 font-weight-light rounded button__hover" style={styles.input__submit} type="submit" value="Siguiente"/>
        </form>
        <BrowserRouter>
        <Link className="my-2 link__hover" style={styles.link} key="key3" to="/login">Iniciar sesión</Link>
        </BrowserRouter>
      </div>
    );
  }
}