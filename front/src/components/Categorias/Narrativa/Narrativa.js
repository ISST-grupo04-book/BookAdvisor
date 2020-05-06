import React from 'react';
import {Container,Row,Col} from 'react-bootstrap';
import AsideRight from '../../Home/AsideRight';
import Center from './Carousel';
import ListaLibros from './ListaLibros';

export default class Narrativa extends React.Component{
  
  constructor(props) {
    super(props);
    this.state = {
        listBooks : {},
    } 
  };

  /*async componentDidMount(){
    const listBooks = await this.props.getFetch("AllBooksServlet")
    this.setState({listBooks:listBooks});
  }*/

    render(){
        return (
          <main className="Narrativa">
            <Container className="my-0 py-5 px-0">
                <Row>
                <Col>
                <Center listBooks={this.state.listBooks}/>          
                </Col>

                <Col>  
                    <AsideRight/>
                </Col>
                </Row>

                <Row>
                    <ListaLibros listBooks={this.state.listBooks}/>
                </Row>
            </Container>
          </main>
        );
      }
}