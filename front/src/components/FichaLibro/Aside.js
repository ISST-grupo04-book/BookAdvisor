import React from 'react';
import {Container,Row,Col,Image, Button} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import '../../css/pseudoElement.css';


export default class Aside extends React.Component {
    render(){
        const styles = {
            book__button : {
                textDecoration: 'none',
                backgroundColor: 'rgb(119, 93, 255)',
                color: 'white',
                fontWeight: 200
            }, 
            description__box : {
                width: '2.2rem',
                backgroundColor: 'rgb(119, 93, 255)',
                color: 'white',
                fontSize: '1rem'
            },
            description__text : {
                fontSize: '1rem',
                fontWeight: 300,
                color: 'rgb(119, 93, 255)'
            }
        }
        
        return (
            <Container fluid className="px-0 mx-0">
                <Row className="mx-0 mb-2">
                    <Col className="px-0">
                        <Image className="w-100 h-100" src={this.props.book.foto} alt="Book Image"/>
                    </Col>
                </Row>
                <Row className="mx-0 mb-4">
                    <Col className="px-0">
                        <Button className="p-2 w-100 h-100 d-block text-center rounded" style={styles.book__button} disabled>¡Conseguir libro!</Button>
                    </Col>
                </Row>
                <Row className="mx-0 mb-2">
                    <Col className="px-0 d-flex align-items-center">
                        <p className="mb-0 mr-2 py-1 text-center rounded" style={styles.description__box}>ISBN</p>
                        <p className="my-0 d-block text-center" style={styles.description__text}>{this.props.book.ISBN}</p>
                    </Col>
                </Row>
                <Row className="mx-0 mb-2">
                    <Col className="px-0 d-flex align-items-center">
                        <p className="mb-0 mr-2 py-1 text-center rounded" style={styles.description__box}>E</p>
                        <p className="my-0 d-block text-center" style={styles.description__text}>{this.props.book.editorial}</p>
                    </Col>
                </Row>
                <Row className="mx-0 mb-2">
                    <Col className="px-0 d-flex align-items-center">
                        <p className="mb-0 mr-2 py-1 text-center rounded" style={styles.description__box}>ED</p>
                        <p className="my-0 d-block text-center" style={styles.description__text}>{this.props.book.edicion}</p>
                    </Col>
                </Row>
                <Row className="mx-0">
                    <Col className="px-0 d-flex align-items-center">
                        <p className="mb-0 mr-2 py-1 text-center rounded" style={styles.description__box}>F</p>
                        <p className="my-0 d-block text-center" style={styles.description__text}>{this.props.book.formato}</p>
                    </Col>
                </Row>
            </Container>
        )
    }
}
