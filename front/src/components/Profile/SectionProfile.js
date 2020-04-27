import React from 'react';
import {Link} from 'react-router-dom'
import '../../css/pseudoElement.css';

export default class SectionProfile extends React.Component {
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
                        <p className='px-4 font-weight-light'>Antonio García</p> 
                        <p className='px-4 font-weight-light'>@antioniog29</p> 
                        <p className='px-4 font-weight-light'>jesusper89@gmail.com</p> 
                        
                    </div>
                    <h4 className="my-4 font-weight-normal">Tipo de perfil: <p className='d-inline'>Usuario</p></h4>
                    <div className='d-flex justify-content-end align-items-center'>
                        <Link className='mr-3 p-2  text-center rounded linkProfile__hover' style={styles.link}>Cambiar contraseña</Link>
                        <button className='p-2 font-weight-light rounded buttonProfile__hover buttonProfile__focus' style={styles.button} >Eliminar cuenta</button>
                    </div>
                </form>
            </div>
        </React.Fragment>
    );
  }
}