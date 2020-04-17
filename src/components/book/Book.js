import React from 'react';
import Nav from './Nav.js';
import Aside from './Aside.js';
import Article from './Article.js';
import Exchange from './Exchange.js';
import {Container,Row,Col} from 'react-bootstrap';

export default class Book extends React.Component {
  render(){
    const styles = {
      main : {
          backgroundColor: '#fcfcfc'
      } 
    }
    return (
      <main style={styles.main}>
        <Nav/>
        <Container className="my-0 py-5 px-0">
          <Row className="mx-0">
            <Col xs={4} className="px-0">
              <Aside/>
            </Col>
            <Col xs={1} />
            <Col xs={7} className="px-0">
              <Article/>
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


