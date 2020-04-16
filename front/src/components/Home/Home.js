import React from 'react';
import {Container,Row,Col} from 'react-bootstrap';
import '../../css/Home/Home.css';
import AsideRight from './AsideRight';
import Center from './Carousel';
import ListaLibros from './ListaLibros';

export default class Home extends React.Component{
    render(){
        return (
          <main className="Home">
            <Container className="my-0 py-5 px-0">
                <Row>
                <Col>
                <Center/>          
                </Col>

                <Col>  
                    <AsideRight/>
                </Col>
                </Row>

                <Row>
                    <ListaLibros/>
                </Row>
            </Container>
          </main>
        );
      }
}