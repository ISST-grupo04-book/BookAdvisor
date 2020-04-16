import React from 'react';
import {Row, Col, Card } from 'react-bootstrap';
import '../../css/Home/ListaLibros.css';

export default class ListaLibros extends React.Component {
    render() {
        return (
            <div className = "listaLibros">
            <h4>Libros más buscados</h4>

            <Row>
            <Col>
                <Card style={{ width: '200px' }}>
                    <Card.Img variant="top" src="img/book.jpg" height="200px" width="200px" />
                    <Card.Body>
                        <Card.Title>El señor de los anillos</Card.Title>
                    </Card.Body>
                </Card>
            </Col>

            <Col>
                <Card style={{ width: '200px' }}>
                    <Card.Img variant="top" src="img/memorias-de-adriano.jpg" height="200px" width="200px" />
                    <Card.Body>
                        <Card.Title>Memorias de Adriano</Card.Title>
                    </Card.Body>
                </Card>
            </Col>

            <Col>
                <Card style={{ width: '200px' }}>
                    <Card.Img variant="top" src="img/lafrontera.jpg" height="200px" width="200px" />
                    <Card.Body>
                        <Card.Title>La frontera</Card.Title>
                    </Card.Body>
                </Card>
            </Col>

            <Col>
                <Card style={{ width: '200px' }}>
                    <Card.Img variant="top" src="img/codigodavinci.jpg" height="200px" width="200px" />
                    <Card.Body>
                        <Card.Title>El código Da Vinci</Card.Title>
                    </Card.Body>
                </Card>
            </Col>

            <Col>
                <Card style={{ width: '200px' }}>
                    <Card.Img variant="top" src="img/harrypotter.jpg" height="200px" width="200px" />
                    <Card.Body>
                        <Card.Title>Harry Potter y la piedra filosofal</Card.Title>
                    </Card.Body>
                </Card>
            </Col>
            </Row>
            </div>
        );
    }
}