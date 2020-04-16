import React from 'react';
import {Container,Row,Col,Image} from 'react-bootstrap';
import '../../css/FichaLibro/Aside.css';

export default class Navigator extends React.Component {
    render(){
        return (
            <Container fluid className="px-0 mx-0">
                <Row className="mx-0 mb-2">
                    <Col className="px-0">
                        <Image className="book__image" src="img/book.jpg" alt="Book Image"/>
                    </Col>
                </Row>
                <Row className="mx-0 mb-4">
                    <Col className="px-0">
                        <a className="book__button" href="#">¡Conseguir libro!</a>
                    </Col>
                </Row>
                <Row className="mx-0 mb-2">
                    <Col className="px-0 d-flex align-items-center">
                        <p className="mb-0 mr-2 py-1 description__box">ISBN</p>
                        <p className="my-0 description__text">9788445003022</p>
                    </Col>
                </Row>
                <Row className="mx-0 mb-2">
                    <Col className="px-0 d-flex align-items-center">
                        <p className="mb-0 mr-2 py-1 description__box">E</p>
                        <p className="my-0 description__text">Minotauro</p>
                    </Col>
                </Row>
                <Row className="mx-0 mb-2">
                    <Col className="px-0 d-flex align-items-center">
                        <p className="mb-0 mr-2 py-1 description__box">ED</p>
                        <p className="my-0 description__text">3ª Edición</p>
                    </Col>
                </Row>
                <Row className="mx-0">
                    <Col className="px-0 d-flex align-items-center">
                        <p className="mb-0 mr-2 py-1 description__box">F</p>
                        <p className="my-0 description__text">Físico, tapa blanda</p>
                    </Col>
                </Row>
            </Container>
        )
    }
}