import React from 'react';
import {Link} from 'react-router-dom';
import {Row, Col, Card } from 'react-bootstrap';
import '../../../css/Home/ListaLibros.css';

export default class ListaLibros extends React.Component {
    render() {
        return (
            <div className = "listaLibros">
            <h4>Libros más buscados de esta categoría:</h4>

            <Row>
                {Array.from(this.props.listBooks).map((book,index)=>{
                    const {ISBN,titulo,foto,} = book
                    return <Col key={index}>
                            <Link to={"/book/"+ISBN} className="linklibros">
                                <Card style={{ width: '200px' }}>
                                    <Card.Img variant="top" src={foto} height="200px" width="200px" />
                                    <Card.Body>
                                        <Card.Title>{titulo}</Card.Title>
                                    </Card.Body>
                                </Card>
                            </Link>
                           </Col>  
                 })}
            </Row>
            </div>
        );
    }
}