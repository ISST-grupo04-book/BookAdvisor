import React from 'react';
import {Form, Col, Row, Button, Container, InputGroup} from 'react-bootstrap';
import '../../css/pseudoElement.css';
import '../../css/Profile/AddBooks.css'
 
export default class AddBook extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            titulo : "",
            ISBN : "",
            editorial: "",
            edicion: "",
            autor: "",
            categoria: "",
            formato: "",
            foto: "",
            descripcion: ""
        };
        this.handleTitulo = this.handleTitulo.bind(this);
        this.handleISBN = this.handleISBN.bind(this);
        this.handleEditorial = this.handleEditorial.bind(this);
        this.handleEdicion = this.handleEdicion.bind(this);
        this.handleAutor = this.handleAutor.bind(this);
        this.handleCategoria = this.handleCategoria.bind(this);
        this.handleFormato = this.handleFormato.bind(this);
        this.handleFoto = this.handleFoto.bind(this);
        this.handleDescripcion = this.handleDescripcion.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    //Métodos para capturar los cambios de evento de cada input:
    handleTitulo(e1){
        this.setState({titulo : e1.curretTarget.value});
    }
    handleISBN(e2){
        this.setState({ISBN : e2.curretTarget.value});
    }
    handleEditorial(e3){
        this.setState({editorial : e3.curretTarget.value});
    }
    handleEdicion(e4){
        this.setState({edicion : e4.curretTarget.value});
    }
    handleAutor(e5){
        this.setState({autor : e5.curretTarget.value});
    }
    handleCategoria(e6){
        this.setState({categoria : e6.curretTarget.value});
    }
    handleFormato(e7){
        this.setState({formato : e7.curretTarget.value});
    }
    handleFoto(e8){
        this.setState({foto : e8.curretTarget.value});
    }
    handleDescripcion(e9){
        this.setState({descripcion : e9.curretTarget.value});
    }

    //Método submit
    handleSubmit(e){
        e.preventDefault();
        if(this.state.titulo.trim() === "" || this.state.ISBN.trim() === "" || this.state.editorial.trim() === "" || 
        this.state.edicion.trim() === "" || this.state.autor.trim() === "" || this.state.categoria.trim() === "" || 
        this.state.formato.trim() === "" || this.state.foto === "" || this.state.descripcion === ""){
            alert("Debe rellenar todos los campos para completar la información sobre el libro");
        }else{
            let paramsToUpdate = {
                titulo : this.state.titulo.trim(),
                ISBN : this.state.ISBN.trim(),
                editorial: this.state.editorial.trim(),
                edicion: this.state.edicion.trim(),
                autor: this.state.edicion.trim(),
                categoria: this.state.categoria.trim(),
                formato: this.state.formato.trim(),
                foto: this.state.foto.trim(),
                descripcion: this.state.descripcion.trim()
            }
        }
    }

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
                        <Form.Control size="lg" type="text" style={styles.input} onChange={(e1) =>this.handleTitulo(e1)}/>
                    </Col>
                    <Col>
                        <p style={styles.text}>ISBN</p>
                        <Form.Control size="lg" type="text" style={styles.input} onChange={(e2) =>this.handleISBN(e2)}/>
                    </Col>
                </Form.Row>

                <span/>
                <Form.Row>
                    <Col>
                        <p style={styles.text}>Editorial</p>
                        <Form.Control size="lg" type="text" style={styles.input} onChange={(e3) =>this.handleEditorial(e3)}/>
                    </Col>
                    <Col>
                        <p style={styles.text}>Edición</p>
                        <Form.Control size="lg" type="text" style={styles.input} onChange={(e4) => this.handleEdicion(e4)}/>
                    </Col>
                </Form.Row>

                <span/>
                <Form.Row>
                    <Col>
                        <p style={styles.text}>Autor</p>
                        <Form.Control size="lg" type="text" style={styles.input} onChange={(e5) => this.handleAutor(e5)}/>
                    </Col>
                    <Col>
                        <p style={styles.text}>Categoría</p>
                        <Form.Control as="select" placeholder="Seleccionar" size="lg" style={styles.input} 
                        onChange={(e6) =>this.handleCategoria(e6)}>
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
                        <Form.Control size="lg" type="text" style={styles.input} onChange={(e7) => this.handleFormato(e7)}/>
                    </Col>

                    <Col>
                    <p style={styles.text}>Subir Fotografía</p>
                     <InputGroup className="picture">
                        <Form.Control size="lg" type="text" style={styles.input}/>
                            <InputGroup.Append>
                                <Button id="addpicture" variant="outline-secondary" style={styles.link} 
                                onChange={(e8) =>this.handleFoto(e8)}>Añadir foto</Button>
                            </InputGroup.Append>
                    </InputGroup>
                    </Col>
                </Form.Row>

                <span/>
                <Form.Row>
                    <Col>
                        <p style={styles.text}>Descripción</p>
                        <Form.Control size="lg" type="text" style={{height:'150px'}} 
                        onChange={(e9) => this.handleDescripcion(e9)}/>
                    </Col>
                </Form.Row>

                <span/>
                <Button type="submit" id="submit"  style={styles.button} onClick={(e) => this.handleSubmit(e)}><p style={styles.text}>Enviar libro a revisión</p></Button>
            </Form.Group >

            </div>
            </Form>
        );
    }
}