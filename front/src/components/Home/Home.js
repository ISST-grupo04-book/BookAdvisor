import React from 'react';
import {Container,Row,Col} from 'react-bootstrap';
import '../../css/Home/Home.css';
import AsideRight from './AsideRight';
import Center from './Carousel';
import ListaLibros from './ListaLibros';
import Nav from '../Nav';

export default class Home extends React.Component{
  
  constructor(props) {
    super(props);
    this.state = {
        listBooks : {},
    } 
  };

  async componentDidMount(){
    const listBooks = await this.props.getFetch("AllBooksServlet")
    this.setState({listBooks:listBooks});
  }

    render(){
        return (
          <main className="Home">
            <Nav user={this.props.user}/>
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