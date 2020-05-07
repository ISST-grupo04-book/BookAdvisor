import React from 'react';
import {Container,Card,CardGroup,ListGroup,Button} from 'react-bootstrap';
import '../../css/pseudoElement.css';

export default class Exchange extends React.Component {
  render(){
      const styles = {
        card__image : {
            height: '14vw',
            objectFit: 'cover'
        },
        card__overlay : {
            height: '14vw'
        },
        card__title : {
            color: 'white',
            backgroundColor: 'rgba(0, 0, 0, 0.6)',
            fontWeight: 300,
            fontSize: '1.3rem'
        },
        card__button : {
            backgroundColor: 'rgb(119, 93, 255)',
            color: 'white',
            fontWeight: 200,
        }
      }

    return (
        <Container fluid className="pt-5 px-0">
            <CardGroup>
                <Card>
                    <Card.Img variant="top" style={styles.card__image} src="/img/bookShop.jpg" />
                    <Card.ImgOverlay className="p-0 d-flex align-items-end" style={styles.card__overlay}>
                        <Card.Title className="m-0 p-4 w-100 text-left" style={styles.card__title}>LIBRERÍAS</Card.Title>
                    </Card.ImgOverlay>
                    <Card.Body className="d-flex flex-column">
                    <ListGroup variant="flush" className="p-0">
                        <ListGroup.Item className="text-secondary">18€ Librería Toa</ListGroup.Item>
                        <ListGroup.Item className="text-secondary">18€ Librería Pasajes</ListGroup.Item>
                        <ListGroup.Item className="text-secondary">19€ La casa del libro</ListGroup.Item>
                        <ListGroup.Item className="text-secondary">22€ El Corte Inglés</ListGroup.Item>
                    </ListGroup>
                    <Button className="w-100 mt-auto" style={styles.card__button} disabled>Añadir precio al libro</Button>
                    </Card.Body>
                </Card>
                <Card>
                    <Card.Img variant="top" style={styles.card__image} src="/img/library.jpg" />
                    <Card.ImgOverlay className="p-0 d-flex align-items-end" style={styles.card__overlay}>
                        <Card.Title className="m-0 p-4 w-100 text-left" style={styles.card__title}>BIBLIOTECAS</Card.Title>
                    </Card.ImgOverlay>
                    <Card.Body className="d-flex flex-column">
                        <ListGroup variant="flush">
                            <ListGroup.Item className="text-secondary">Biblioteca Muncipal Arguelles</ListGroup.Item>
                            <ListGroup.Item className="text-secondary">Biblioteca ETSIT</ListGroup.Item>
                        </ListGroup>
                        <Button className="w-100 mt-auto" style={styles.card__button} disabled>Añadir disponibilidad</Button>
                    </Card.Body>
                </Card>
                <Card>
                    <Card.Img variant="top" style={styles.card__image} src="/img/exchange.jpg" />
                    <Card.ImgOverlay className="p-0 d-flex align-items-end" style={styles.card__overlay}>
                        <Card.Title className="m-0 p-4 w-100 text-left" style={styles.card__title} >INTERCAMBIOS</Card.Title>
                    </Card.ImgOverlay>
                    <Card.Body className="d-flex flex-column">
                        <ListGroup variant="flush">
                            <ListGroup.Item className="text-secondary">@jesus839. Madrid</ListGroup.Item>
                            <ListGroup.Item className="text-secondary">@alberto424. Madrid</ListGroup.Item>
                            <ListGroup.Item className="text-secondary">@tomasito23. Segovia</ListGroup.Item>
                        </ListGroup>
                        <Button className="w-100 mt-auto" style={styles.card__button} disabled>Añadir disponibilidad</Button>
                    </Card.Body>  
                </Card>
            </CardGroup>
        </Container>
    );
  }
}