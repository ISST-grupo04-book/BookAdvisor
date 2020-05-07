import React from 'react';
import {Image} from 'react-bootstrap';
import '../../css/pseudoElement.css';

export default class Mybooks extends React.Component {
  render(){
    const styles = {
        form : {
            backgroundColor : 'rgb(241,238,255)',
            boxShadow: '0px 0px 10px rgba(119, 93, 255,.3)',
            borderRadius : '1em' 
        },
        img : {
            height : '350px',
            borderRadius : '1em' 
        },
        title_wrapper : {
            height : '350px'
        },
        link : {
            backgroundColor : 'white',
            color : 'rgba(119, 93, 255)',
            border: '2px solid rgba(119, 93, 255)',
            textDecoration: 'none'
        },
        button : {
            backgroundColor : 'rgb(255,93,93)',
            color : 'white',
            border: 'none'
        }
    }

    return (
        <form className="p-5 mt-5 w-100 h-auto d-flex justify-content-start align-items-start" action="#" style={styles.form}>
            <Image className='w-auto' src={this.props.img} style={styles.img}/>
            <div className="ml-5 pt-4 w-100 d-flex flex-column" style={styles.title_wrapper}>
            <h4 className="my-2 font-weight-normal">{this.props.name}</h4>
            <h5 className="my-2 font-weight-normal">Estado actual: {this.props.disponible ? "disponible para el intercambio" :
                "en intercambio (no disponible)"}</h5>
                <div className="mt-auto w-100 d-flex justify-content-end align-items-center">
                    <button className="p-2 mr-3 w-25 rounded linkProfile__hover buttonProfile__focus" style={styles.link}>
                        {this.props.disponible ? "Pasar a intercambio" :"Pasar a disponible"}
                    </button>
                    <button className="p-2 w-25 font-weight-light rounded buttonProfile__hover buttonProfile__focus" 
                    style={styles.button} onClick={() => this.props.delete()}>Eliminar</button>
                </div>
            </div>
        </form>

    );
  }
}