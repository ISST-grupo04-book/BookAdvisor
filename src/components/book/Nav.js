import React from 'react';
import {Navbar,Nav,Button,FormControl,Form,Image} from 'react-bootstrap';
import '../../css/Nav.css';


export default class Navigator extends React.Component {
    render(){
        return (
            <Navbar className="navbar--color" expand="lg">
                <Navbar.Brand className="text-white p-0 navbar__bran" href="#home">
                    <Image className="d-inline-block align-top mr-1 navbar__brand_img" src="img/logo.png" alt="Logo"/>
                    BookAdvisor
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link href="#home">Inicio</Nav.Link>
                        <Nav.Link href="#link">Categorías</Nav.Link>
                    </Nav>
                    <Form inline>
                        <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                        <Button variant="outline-success">Search</Button>
                    </Form>
                </Navbar.Collapse>
            </Navbar>
        )
    }
}