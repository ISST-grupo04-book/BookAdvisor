import React from 'react';
import {Row,Col,Badge} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import '../../css/pseudoElement.css';

export default class Section extends React.Component {
  render(){
    const styles = {
      book__title : {
        fontSize: '2.2rem',
        fontWeight: 400
      },
      book__badge : {
        backgroundColor: 'rgb(119, 93, 255)',
        color: 'white',
        fontWeight: 400
      },
      book__description : {
        fontWeight: 300
      },
      edit__button : {
        textDecoration: 'none',
        backgroundColor: 'rgb(119, 93, 255)',
        color: 'white',
        fontWeight: 200,
    }

    }
    return (
        <React.Fragment>
            <Row className="mx-0">
              <Col className="px-0">
                  <h1 style={styles.book__title}>El señor de los anillos</h1>
              </Col>
            </Row>
            <Row className="mx-0 my-3">
              <Col className="px-0">
                  <Badge pill className="mr-2 px-4 py-1" style={styles.book__badge}>Ficción</Badge>
                  <Badge pill className="px-4 py-1" style={styles.book__badge}>Aventuras</Badge>
              </Col>
            </Row>
            <Row className="mx-0">
              <Col className="px-0">
              <p style={styles.book__description}>El Señor de los Anillos (título original en inglés: The Lord of the Rings) es una novela de fantasía épica escrita por el filólogo y escritor británico J. R. R. Tolkien.
                  Su historia se desarrolla en la Tercera Edad del Sol de la Tierra Media, un lugar ficticio poblado por hombres y otras razas antropomorfas como los hobbits, los elfos o los enanos, así como por muchas otras criaturas reales y fantásticas. La novela narra el viaje del protagonista principal, Frodo Bolsón, hobbit de la Comarca, para destruir el Anillo Único y la consiguiente guerra que provocará el enemigo para recuperarlo, ya que es la principal fuente de poder de su creador, el Señor oscuro Sauron.
              </p>
              </Col>
            </Row>
            <Row className="mx-0">
              <Col xs={6} className="px-0">
                <Link className="p-2 w-100 h-100 d-block text-center rounded button__hover" style={styles.edit__button} to="#">Añadir Reseña Editorial</Link>
              </Col>
            </Row>
        </React.Fragment>
    );
  }
}