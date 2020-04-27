import React from 'react';
import {Link} from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHome,faBook,faBookmark} from '@fortawesome/free-solid-svg-icons';
import '../../css/pseudoElement.css';

export default class AsideProfile extends React.Component {
  render(){
    const styles = {
        aside: {
            backgroundColor: 'white',
            boxShadow: '0px 0px 10px rgba(0, 0, 0,.1)'
        },
        aside__elem: {
            color: '#a0a5ba',
            textDecoration: 'none'
        },
        aside__icon: {
            width:'25px',
            height:'25px'
        }
    }

    return (
        <div className='px-4 py-5 h-100 d-flex flex-column justify-content-start align-items-start' style={styles.aside}>
            <Link className='my-4 d-flex justify-content-start align-items-center aside__hover aside__focus' 
            style={styles.aside__elem} tabindex="1" key="key1" to="/profile/my_profile">
                <FontAwesomeIcon style={styles.aside__icon} icon={faHome} />
                <p className='my-0 mx-4'>Perfil</p>
            </Link>
            <Link className='my-4 d-flex justify-content-start align-items-center aside__hover aside__focus' 
            style={styles.aside__elem} tabindex="2" key="key2" to="/profile/my_books">
                <FontAwesomeIcon style={styles.aside__icon} icon={faBook} />
                <p className='my-0 mx-4'>Mis libros</p>
            </Link>      
            <Link className='my-4 d-flex justify-content-start align-items-center aside__hover aside__focus' 
            style={styles.aside__elem} tabindex="3" key="key3" to="/profile/add_book">
                <FontAwesomeIcon style={styles.aside__icon}  icon={faBookmark} />
                <p className='my-0 mx-4'>Añadir libro</p>
            </Link>            
        </div>
    );
  }
}