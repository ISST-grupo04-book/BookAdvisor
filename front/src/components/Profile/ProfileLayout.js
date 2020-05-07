import React from 'react';
import Swal from 'sweetalert2';
import {Container,Row,Col} from 'react-bootstrap';
import AsideProfile from './AsideProfile';
import SectionProfile from './SectionProfile';
import SectionMybooks from './SectionMybooks';
import AddBook from './AddBook';
import Nav from '../Nav';

export default class ProfileLayout extends React.Component {
  
  constructor(props) {
    super(props);
    this.state = {
      user:{}
    }
  }
  
  componentDidMount(){
      this.setState({user:this.props.user})
  }

  render(){

    //Prueba. Borrar luego
    let bookList =[
      {
        name : "El señor de los anillos",
        disponible : true,
        image : "/img/book.jpg" 
      },
      {
        name : "Memorias de Adriano",
        disponible : false,
        image : "/img/memorias-de-adriano.jpg" 
      },
      {
        name : "La frontera",
        disponible : true,
        image : "/img/lafrontera.jpg" 
      },
      {
        name : "El código Da Vinci",
        disponible : true,
        image : "/img/codigodavinci.jpg" 
      },
      {
        name : "Harry Potter y la piedra filosofal",
        disponible : false,
        image : "/img/harrypotter.jpg" 
      }
    ]
    if(this.props.user === null){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Parece que tu sesión ha daducado, por favor, vuelva a iniciar sesión',
        showConfirmButton: true,
      })
      this.props.history.push("/login")
    }
    let view = null;
    switch (this.props.name) {
      case "My_profile":
        view = <SectionProfile user={this.state.user}/>
        break;
      case "My_books":
        view = <SectionMybooks bookList={bookList} user={this.state.user}/>
        break;
      case "Add_book":
        view = <AddBook user={this.state.user} postFetch={this.props.postFetch} history={this.props.history}/>
        break;
      default:
          view = <SectionProfile user={this.state.user}/>
          break;
    }

    const styles = {
      main : {
        backgroundColor: '#fcfcfc',
      }
    }
    return (
        <main className='h-auto min-vh-100'style={styles.main}>
        <Nav/>
        <Container fluid className="p-0 h-auto min-vh-100">
          <Row className="m-0 h-100 min-vh-100">
            <Col xs={2} className="p-0">
                <AsideProfile/>
            </Col>
            <Col xs={10} className="p-0 d-flex flex-column justify-content-center align-items-center">
                {view}
            </Col>
          </Row>
        </Container>
      </main>
    );
  }
}