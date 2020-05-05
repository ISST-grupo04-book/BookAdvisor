import React from 'react';
import Login from './Login.js';
import Signup from './Signup.js';
import SignupUser from './SignupUser.js';
import SignupLibrary from './SignupLibrary.js';
import SignupBookshop from './SignupBookshop.js';
import SignupEditorial from './SignupEditorial.js';
import NewPassword from './NewPassword.js';

import {Container,Row,Col,Image} from 'react-bootstrap';

export default class Access_layout extends React.Component {
  render(){
    const styles = {
      main : {
        height: '100vh',
        backgroundColor: '#fcfcfc'
      },
      bg__login : {
        display: 'grid',
        gridTemplateColumns: 'repeat(12, 1fr)',
        gridTemplateRows: 'repeat(12, 1fr)' 
      },
      bg__image : {
        gridColumn: '1 / span 12',
        gridRow: '1 / span 12',
        filter: 'drop-shadow(0px 0px 30px rgba(119, 93, 255,.9))'
      },
      bg__filter : {
        gridColumn: '1 / span 12',
        gridRow: '1 / span 12',
        zIndex: 1,
        background: 'linear-gradient(90deg, rgba(119, 93, 255,.9), rgba(119, 93, 255,.4) 100%)'
      },
      bg__logo : {
        borderRadius: '25px',
        zIndex: 2
      }
    }

    let view = null;
    switch (this.props.name) {
      case "Psd":
        view = <NewPassword/>
        break;
      case "User":
        view = <SignupUser/>
        break;
      case "Library":
        view = <SignupLibrary/>
        break;
      case "Bookshop":
        view = <SignupBookshop/>
        break;
      case "Editorial":
        view = <SignupEditorial/>
        break;
      default:
        if (this.props.view === "Signup"){
          view = <Signup/>
        }else{
          view = <Login postFetch={this.props.postFetch}/>
        }
        break;
    }
    return (
        <main style={styles.main}>
        <Container fluid className="p-0 h-100">
          <Row className="m-0 h-100">
            <Col xs={6} className="p-0" style={styles.bg__login}>
              <Image className="w-100 h-100" style={styles.bg__image} src="/img/library.jpg" alt="Login Image"/>
              <div className="d-flex justify-content-center align-items-center" style={styles.bg__filter}>
                <Image className="w-auto h-auto" style={styles.bg__logo} src="/img/Logo.png" alt="Logo Image"/>
              </div>
            </Col>
            <Col xs={6} className="p-0 d-flex flex-column justify-content-center align-items-center">
              {view}
            </Col>
          </Row>
        </Container>
      </main>
    );
  }
}