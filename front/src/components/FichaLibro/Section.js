import React from 'react';
import {Row,Col,Badge} from 'react-bootstrap';
import '../../css/FichaLibro/Section.css';

export default class Section extends React.Component {
    render(){
      return (
          <React.Fragment>
              <Row className="mx-0">
                <Col className="px-0">
                    <h1 className="book_title">El señor de los anillos</h1>
                </Col>
              </Row>
              <Row className="mx-0 my-3">
                <Col className="px-0">
                    <Badge pill variant="primary" className="mr-2 book_badge">Ficción</Badge>
                    <Badge pill variant="primary" className="book_badge">Aventuras</Badge>
                </Col>
              </Row>
              <Row className="mx-0">
                <Col className="px-0">
                <p className="book_description">El Señor de los Anillos (título original en inglés: The Lord of the Rings) es una novela de fantasía épica escrita por el filólogo y escritor británico J. R. R. Tolkien.
                   Su historia se desarrolla en la Tercera Edad del Sol de la Tierra Media, un lugar ficticio poblado por hombres y otras razas antropomorfas como los hobbits, los elfos o los enanos, así como por muchas otras criaturas reales y fantásticas. La novela narra el viaje del protagonista principal, Frodo Bolsón, hobbit de la Comarca, para destruir el Anillo Único y la consiguiente guerra que provocará el enemigo para recuperarlo, ya que es la principal fuente de poder de su creador, el Señor oscuro Sauron.
                </p>
                </Col>
              </Row>
              <Row className="mx-0">
                <Col xs={6} className="px-0">
                  <a className="edit__button" href="#">Añadir Reseña Editorial</a>
                </Col>
              </Row>
          </React.Fragment>
      );
    }
  }