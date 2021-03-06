import React from 'react';
import {Link} from 'react-router-dom'
import '../../css/pseudoElement.css';

export default class SectionProfile extends React.Component {
    
    constructor(props) {
        super(props);
        this.state = {
        }
      }
    

      handleDelete = () => {
        if(window.confirm("¿Estás seguro de querer eliminar tu cuenta? Una vez borrado no se podrá recuperar")){
            // fetch con delete 
        }
      }
      

  render(){
    const styles = {
        section__wrapper : {
            boxShadow: '0px 0px 10px rgba(119, 93, 255,.4)'
          },
        link : {
            width: '18%',
            backgroundColor : 'white',
            color : 'rgba(119, 93, 255)',
            border: '2px solid rgba(119, 93, 255)',
            textDecoration: 'none'
        },
        button : {
            width: '18%',
            backgroundColor : 'rgb(255,93,93)',
            color : 'white',
            border: 'none'
        }
    }

    return (
        <React.Fragment>
            <h2 className="pl-4 mb-5 w-75 font-weight-normal">Mi perfil</h2>
            <div className="p-5 mb-5 h-auto w-75 d-flex flex-column justify-content-start align-items-start bg-white rounded" style={styles.section__wrapper}>
                <form className="w-100"action="#">
                    <div className='d-flex justify-content-between align-items-center'>
                        <h3 className="mb-4 font-weight-normal">Datos</h3>
                        <Link className='p-2 text-center rounded linkProfile__hover' style={styles.link} aria-pressed='true'>Editar perfil</Link>
                    </div>
                    <div className="w-100">
                        <p className='px-4 font-weight-light'>Nombre: {this.props.user.nombre}</p> 
                        <p className='px-4 font-weight-light'>Nombre de usuario: {this.props.user.username}</p> 
                        <p className='px-4 font-weight-light'>Email: {this.props.user.email}</p> 
                        <p className='px-4 font-weight-light'>Telefono: {this.props.user.telefono}</p> 
                    </div>
                    <h4 className="my-4 font-weight-normal">Tipo de perfil: <p className='d-inline'>Usuario</p></h4>
                    <div className='d-flex justify-content-end align-items-center'>
                        <Link className='mr-3 p-2  text-center rounded linkProfile__hover' style={styles.link} to="/signup/newPassword">Cambiar contraseña</Link>
                        <button className='p-2 font-weight-light rounded buttonProfile__hover buttonProfile__focus' 
                        style={styles.button} onClick={() => this.handleDelete()}>Eliminar cuenta</button>
                    </div>
                </form>
            </div>
        </React.Fragment>
    );
  }
}