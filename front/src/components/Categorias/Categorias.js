import React from 'react';
import {Container,Row, Button} from 'react-bootstrap';
import '../../css/Categorias/Categorias.css';

export default class Categorias extends React.Component{
    render(){
        return (
          <main className="Categorias">
            <Container>
                <Row>
                  <h5 id="cat">Categorías</h5>
                </Row>
                <Row>
                  <Button id="button1">Narrativa</Button>
                  <Button id="button2">No ficción</Button>
                  <Button id="button3">Poesía</Button>
                  <Button id="button4">Cómic</Button>
                </Row>
                <Row>
                  <Button id="button5">Juvenil</Button>
                  <Button id="button6">Clásicos</Button>
                  <Button id="button7">Novela Negra</Button>
                  <Button id="button8">Política</Button>
                </Row>

            </Container>
        
            <Container>
              <Row>
                  <h5>Favoritos</h5>
                </Row>

              <Row>
                  <Button id="button9">Más Leídos</Button>
                  <Button id="button10">Recomendados</Button>
                  <Button id="button11">Novedades</Button>
                  <Button id="button12">Promociones</Button>
                </Row>
            </Container>
          </main>
        );
      }
}