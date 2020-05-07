import React from 'react';
import {Container,Row, Button} from 'react-bootstrap';
import '../../css/Categorias/Categorias.css';
import Nav from '../Nav';

export default class Categorias extends React.Component{

  handleSearch =  async(categoria) => {
    let res = await this.props.getFetch("ViewCategoryBooksServlet","?categoria=" + categoria)
    console.log(res);
    }

    render(){
        return (
          <main className="Categorias">
            <Nav user ={this.props.user}/>
            <Container>
                <Row>
                  <h5 id="cat">Categorías</h5>
                </Row>
                <Row>
                  <Button id="button1" onClick={() => this.handleSearch("Narrativa")}>Narrativa</Button>
                  <Button id="button2" onClick={() => this.handleSearch("No ficción")}>No ficción</Button>
                  <Button id="button3" onClick={() => this.handleSearch("Poesía")}>Poesía</Button>
                  <Button id="button4" onClick={() => this.handleSearch("Cómic")}>Cómic</Button>
                </Row>
                <Row>
                  <Button id="button5" onClick={() => this.handleSearch("Juvenil")}>Juvenil</Button>
                  <Button id="button6" onClick={() => this.handleSearch("Clásicos")}>Clásicos</Button>
                  <Button id="button7" onClick={() => this.handleSearch("Novela Negra")}>Novela Negra</Button>
                  <Button id="button8" onClick={() => this.handleSearch("Política")}>Política</Button>
                </Row>

            </Container>
        
            <Container>
              <Row>
                  <h5>Favoritos</h5>
                </Row>

              <Row>
                  <Button id="button9">Más Leídos</Button>
                  <Button id="button10">Recomendados</Button>
                  <Button id="button11">Novedades</Button>
                  <Button id="button12">Promociones</Button>
                </Row>
            </Container>
          </main>
        );
      }
}