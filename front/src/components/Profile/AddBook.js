import React from 'react';
import {Form, Col, Row, Button} from 'react-bootstrap';
import Swal from 'sweetalert2';
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
            categoria: "Narrativa",
            formato: "",
            foto: "",
            descripcion: ""
        };
    }

    postFetch = async(servlet="",data) => {
        const URI = "http://localhost:8080/BookAdvisor/"; 
        let myInit = { method: "POST",
                      body: JSON.stringify(data)
                    };
        
        const response = await fetch(URI+servlet,myInit);
        const responseJson = await response.json();
        const parseJson = await JSON.parse(responseJson);
        return (parseJson);
        
      }
    handleChange = (e)=> {
        this.setState({[e.target.name] : e.target.value})
      }
    
    handleFoto = async (e)=> {
        const fd = new FormData()
        fd.append('image',e.target.files[0])
        const URI = "https://api.imgbb.com/1/upload?key=b30e9fdefc063109466c47f428b4cb53"; 
        let myInit = { method: "POST",
                      body: fd
                    };
        const response = await fetch(URI,myInit);
        const responseJson = await response.json();
        this.setState({foto:responseJson.data.url});
        
    }

    //Método submit
    handleSubmit = async (e) => {
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
                resena: this.state.descripcion.trim(),
            }
            const res = await this.postFetch("AddBookInfoServlet",paramsToUpdate);
            if (res.creacion === "incorrecta"){
                Swal.fire({
                  icon: 'error',
                  title: 'Oops...',
                  text: 'Ha habido algún error durante la creación. Por favor, vuelva a intentarlo'
                })
              }else{
                Swal.fire({
                  icon: 'success',
                  title: 'Creación realizada con éxito.',
                  showConfirmButton: false,
                  timer: 2000
                })
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
                        <Form.Control size="lg" type="text" style={styles.input} name="titulo" onChange={(e) => this.handleChange(e)}/>
                    </Col>
                    <Col>
                        <p style={styles.text}>ISBN</p>
                        <Form.Control size="lg" type="text" style={styles.input} name="ISBN" onChange={(e) => this.handleChange(e)}/>
                    </Col>
                </Form.Row>

                <span/>
                <Form.Row>
                    <Col>
                        <p style={styles.text}>Editorial</p>
                        <Form.Control size="lg" type="text" style={styles.input} name="editorial" onChange={(e) => this.handleChange(e)}/>
                    </Col>
                    <Col>
                        <p style={styles.text}>Edición</p>
                        <Form.Control size="lg" type="text" style={styles.input} name="edicion" onChange={(e) => this.handleChange(e)}/>
                    </Col>
                </Form.Row>

                <span/>
                <Form.Row>
                    <Col>
                        <p style={styles.text}>Autor</p>
                        <Form.Control size="lg" type="text" style={styles.input} name="autor" onChange={(e) => this.handleChange(e)}/>
                    </Col>
                    <Col>
                        <p style={styles.text}>Categoría</p>
                        <Form.Control as="select" placeholder="Seleccionar" size="lg" style={styles.input}  name="categoria"
                        onChange={(e) => this.handleChange(e)}>
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
                        <Form.Control size="lg" type="text" style={styles.input} name="formato"  onChange={(e) => this.handleChange(e)}/>
                    </Col>

                    <Col>
                    <p style={styles.text}>Subir Fotografía</p>
                    <div class="input-group">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" id="inputGroupFile01"
                            aria-describedby="inputGroupFileAddon01" accept="image/*" onChange={(e) => this.handleFoto(e)}
                            disabled={this.state.foto !== ""}/>
                            <label class="custom-file-label" for="inputGroupFile01">{this.state.foto !== "" ? "Imagen cargada" :
                            "Selecciona imagen"}</label>
                        </div>
                    </div>
                    </Col>
                </Form.Row>

                <span/>
                <Form.Row>
                    <Col>
                        <p style={styles.text}>Descripción</p>
                        <Form.Control size="lg" type="text" style={{height:'150px'}} name="descripcion"
                        onChange={(e) => this.handleChange(e)}/>
                    </Col>
                </Form.Row>

                <span/>
                <Button type="submit" id="submit"  style={styles.button} onClick={(e) => this.handleSubmit(e)}><p style={styles.text}>Enviar libro</p></Button>
            </Form.Group >

            </div>
            </Form>
        );
    }
}