import React from 'react';
import {Container,Row, Button} from 'react-bootstrap';
import '../../css/Categorias/Categorias.css';
import Nav from '../Nav';

export default class Categorias extends React.Component{

  handleSearch =  async(categoria) => {
    let res = await this.props.getFetch("ViewCategoryBooksServlet","?categoria=" + categoria)
    this.props.changeAppNarrativa(res)
    console.log(res);
    this.props.history.push("/categorias/narrativa");
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
                  <Button id="button1" onClick={() => this.handleSearch("1")}>Narrativa</Button>
                  <Button id="button2" onClick={() => this.handleSearch("0")}>No ficción</Button>
                  <Button id="button3" onClick={() => this.handleSearch("2")}>Poesía</Button>
                  <Button id="button4" onClick={() => this.handleSearch("3")}>Cómic</Button>
                </Row>
                <Row>
                  <Button id="button5" onClick={() => this.handleSearch("4")}>Juvenil</Button>
                  <Button id="button6" onClick={() => this.handleSearch("5")}>Clásicos</Button>
                  <Button id="button7" onClick={() => this.handleSearch("6")}>Novela Negra</Button>
                  <Button id="button8" onClick={() => this.handleSearch("7")}>Política</Button>
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