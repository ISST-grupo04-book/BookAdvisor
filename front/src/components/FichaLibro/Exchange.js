import React from 'react';
import {Container,Card,CardGroup,ListGroup,Button} from 'react-bootstrap';
import '../../css/FichaLibro/Exchange.css';


export default class Exchange extends React.Component {
  render(){
    return (
        <Container fluid className="pt-5 px-0">
            <CardGroup>
                <Card>
                    <Card.Img variant="top" className="card_image" src="img/bookShop.jpg" />
                    <Card.ImgOverlay className="p-0 d-flex align-items-end card_overlay">
                        <Card.Title className="m-0 p-4 w-100 text-left card_title">LIBRERÍAS</Card.Title>
                    </Card.ImgOverlay>
                    <Card.Body className="d-flex flex-column">
                    <ListGroup variant="flush" className="p-0">
                        <ListGroup.Item className="text-secondary">18€ Librería Toa</ListGroup.Item>
                        <ListGroup.Item className="text-secondary">18€ Librería Pasajes</ListGroup.Item>
                        <ListGroup.Item className="text-secondary">19€ La casa del libro</ListGroup.Item>
                        <ListGroup.Item className="text-secondary">22€ El Corte Inglés</ListGroup.Item>
                    </ListGroup>
                    <Button variant="primary" className="w-100 mt-auto card_button">Añadir precio al libro</Button>
                    </Card.Body>
                </Card>
                <Card>
                    <Card.Img variant="top" className="card_image" src="img/library.jpg" />
                    <Card.ImgOverlay className="p-0 d-flex align-items-end card_overlay">
                        <Card.Title className="m-0 p-4 w-100 text-left card_title">BIBLIOTECAS</Card.Title>
                    </Card.ImgOverlay>
                    <Card.Body className="d-flex flex-column">
                        <ListGroup variant="flush">
                            <ListGroup.Item className="text-secondary">Biblioteca Muncipal Arguelles</ListGroup.Item>
                            <ListGroup.Item className="text-secondary">Biblioteca ETSIT</ListGroup.Item>
                        </ListGroup>
                        <Button variant="primary" className="w-100 mt-auto card_button">Añadir disponibilidad</Button>
                    </Card.Body>
                </Card>
                <Card>
                    <Card.Img variant="top" className="card_image" src="img/exchange.jpg" />
                    <Card.ImgOverlay className="p-0 d-flex align-items-end card_overlay">
                        <Card.Title className="m-0 p-4 w-100 text-left card_title">INTERCAMBIOS</Card.Title>
                    </Card.ImgOverlay>
                    <Card.Body className="d-flex flex-column">
                        <ListGroup variant="flush">
                            <ListGroup.Item className="text-secondary">@jesus839. Madrid</ListGroup.Item>
                            <ListGroup.Item className="text-secondary">@alberto424. Madrid</ListGroup.Item>
                            <ListGroup.Item className="text-secondary">@tomasito23. Segovia</ListGroup.Item>
                        </ListGroup>
                        <Button variant="primary" className="w-100 mt-auto card_button">Añadir disponibilidad</Button>
                    </Card.Body>  
                </Card>
            </CardGroup>
        </Container>
    );
  }
}