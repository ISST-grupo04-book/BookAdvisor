import React from 'react';
import {Container,Row,Col} from 'react-bootstrap';
import AsideRight from '../../Home/AsideRight';
import Center from './Carousel';
import ListaLibros from './ListaLibros';

export default class Narrativa extends React.Component{

    render(){
        return (
          <main className="Narrativa">
            <Container className="my-0 py-5 px-0">
                <Row>
                <Col>
                <Center listBooks={this.props.listBooks}/>          
                </Col>

                <Col>  
                    <AsideRight/>
                </Col>
                </Row>

                <Row>
                    <ListaLibros listBooks={this.props.listBooks}/>
                </Row>
            </Container>
          </main>
        );
      }
}