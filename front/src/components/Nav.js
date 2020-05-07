import React from 'react';
import {Link} from "react-router-dom";
import {Navbar,Nav,Button,FormControl,Form,Image} from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSearch,faUserCircle,faSignInAlt } from '@fortawesome/free-solid-svg-icons';
import '../css/Nav.css';


//import '../css/Nav.css';
export default class Navigator extends React.Component {
      
    render(){
        return (
            <Navbar className="navbar--color" expand="lg">
                <Link to="/">
                    <Navbar.Brand className="text-white p-0 navbar__bran">
                        <Image className="d-inline-block align-top mr-1 navbar__brand_img" src="/img/logo.png" alt="Logo"/>
                        BookAdvisor
                    </Navbar.Brand>
                </Link>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        <Link className="mx-2" style={{textDecoration:"none"}} to="/"><p id = "inicio">Inicio</p></Link>
                        <Link className="mx-2" style={{textDecoration:"none"}} to="/categorias"><p id= "categorias">Categorías</p></Link>
                    </Nav>
                    <Form inline>
                        <Button className = "button_search"><FontAwesomeIcon icon={faSearch}/></Button>
                        <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                    </Form>
                    <Link to={this.props.user === null ? "/login" : "/profile"}>
                        <Button className ="button_user">
                            <FontAwesomeIcon icon={this.props.user === null ? faSignInAlt : faUserCircle}/>
                        </Button>
                    </Link>
                </Navbar.Collapse>
            </Navbar>
        )
    }
}