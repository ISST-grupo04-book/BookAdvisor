import React from 'react';
import {Form, Col, Row, Button, Container, InputGroup} from 'react-bootstrap';
import '../../css/pseudoElement.css';
import '../../css/Profile/AddBooks.css'
 
export default class AddBook extends React.Component{
    render(){

        const styles = {
            section__wrapper : {
                boxShadow: '0px 0px 10px rgba(119, 93, 255,.4)',
              },
            link : {
                backgroundColor : 'white',
                color : 'rgba(119, 93, 255)',
                border: '2px solid rgba(119, 93, 255)',
                textDecoration: 'none',
                height: '48px'
            },
            button : {
                backgroundColor : 'rgba(119, 93, 255)',
                border: '2px solid rgba(119, 93, 255)',
                height: '50px',
                marginLeft: '580px'
            },
            text : {
                weight : 'bold',
                fontSize: '125%'
            },
            input : {
                position: 'relative',
                marginBottom: '10px'
            }

            }

        return (
            <Form className="Form">
            <h4>Añadir Libro</h4>
            
            <div className="p-5 mb-5 h-auto w-75 d-flex flex-column justify-content-start align-items-start bg-white rounded" style={styles.section__wrapper}>
            <Form.Group>
                <Form.Row>
                    <Col>
                        <p style={styles.text}>Título</p>
                        <Form.Control size="lg" type="text" style={styles.input}/>
                    </Col>
                    <Col>
                        <p style={styles.text}>ISBN</p>
                        <Form.Control size="lg" type="text" style={styles.input}/>
                    </Col>
                </Form.Row>

                <span/>
                <Form.Row>
                    <Col>
                        <p style={styles.text}>Editorial</p>
                        <Form.Control size="lg" type="text" style={styles.input}/>
                    </Col>
                    <Col>
                        <p style={styles.text}>Edición</p>
                        <Form.Control size="lg" type="text" style={styles.input}/>
                    </Col>
                </Form.Row>

                <span/>
                <Form.Row>
                    <Col>
                        <p style={styles.text}>Autor</p>
                        <Form.Control size="lg" type="text" style={styles.input}/>
                    </Col>
                    <Col>
                        <p style={styles.text}>Categoría</p>
                        <Form.Control as="select" placeholder="Seleccionar" size="lg" style={styles.input}>
                            <option>Narrativa</option>
                            <option>No ficción</option>
                            <option>Poesía</option>
                            <option>Cómic</option>
                            <option>Juvenil</option>
                            <option>Clásicos</option>
                            <option>Novela Negra</option>
                            <option>Política</option>
                        </Form.Control>
                    </Col>
                </Form.Row>

                <span/>
                <Form.Row>
                    <Col>
                        <p style={styles.text}>Formato</p>
                        <Form.Control size="lg" type="text" style={styles.input}/>
                    </Col>

                    <Col>
                    <p style={styles.text}>Subir Fotografía</p>
                     <InputGroup className="picture">
                        <Form.Control size="lg" type="text" style={styles.input}/>
                            <InputGroup.Append>
                                <Button id="addpicture" variant="outline-secondary" style={styles.link}>Añadir foto</Button>
                            </InputGroup.Append>
                    </InputGroup>
                    </Col>
                </Form.Row>

                <span/>
                <Form.Row>
                    <Col>
                        <p style={styles.text}>Descripción</p>
                        <Form.Control size="lg" type="text" style={{height:'150px'}}/>
                    </Col>
                </Form.Row>

                <span/>
                <Button type="submit" id="submit"  style={styles.button}><p style={styles.text}>Enviar libro a revisión</p></Button>
            </Form.Group >

            </div>
            </Form>
        );
    }
}