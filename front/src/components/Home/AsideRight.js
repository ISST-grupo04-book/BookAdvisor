import React from 'react';
import {Container,Row,Col, Button} from 'react-bootstrap';
import '../../css/Home/AsideRight.css';

export default class AsideRight extends React.Component{
    render(){
        return (
          <main className="AsideRight">
            <Container className="buttonGroup">
             <Row>
              <Button id="buttona" size="lg">Más Leídos</Button>
             </Row>

             <Row>
              <Button id="buttonb" size="lg">Recomendados</Button>
             </Row>

             <Row>
              <Button id="buttonc" size="lg">Novedades</Button>
              </Row>

              <Row>
              <Button id="buttond" size="lg">Promociones</Button>
              </Row>
            </Container>
          </main>
        );
      }
}