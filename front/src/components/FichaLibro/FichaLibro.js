import React from 'react';
import Aside from './Aside.js';
import Article from './Article.js';
import Exchange from './Exchange.js';
import {Container,Row,Col} from 'react-bootstrap';
import Nav from '../Nav';

export default class FichaLibro extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      book: {}
    } 
  };

  async componentDidMount(){
    const res = await this.props.getFetch("ViewBookInfoServlet","?ISBN="+this.props.match.params.ISBN);
    this.setState({book:res})
  }
  
  render(){
    const styles = {
      main : {
          backgroundColor: '#fcfcfc'
      } 
    }
    return (
      
      <main style={styles.main}>
        <Nav user={this.props.user}/>
        <Container className="my-0 py-5 px-0">
          <Row className="mx-0">
            <Col xs={4} className="px-0">
              <Aside book={this.state.book}/>
            </Col>
            <Col xs={1} />
            <Col xs={7} className="px-0">
              <Article book1={this.state.book} user={this.props.user} history={this.props.history} postFetch={this.props.postFetch}/>
            </Col>
          </Row>
          <Row className="mx-0">
            <Col className="px-0">
              <Exchange/>
            </Col>
          </Row>
        </Container>
      </main>
    );
  }
}


