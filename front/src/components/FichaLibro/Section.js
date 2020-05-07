import React from 'react';
import {Row,Col,Badge, Button} from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';
import Comments from './Comments.js';
import '../../css/pseudoElement.css';

export default class Section extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      valoracion: null
    } 
  };

  componentDidMount(){
    this.setState({valoracion:this.props.book.valoracion})
  }
  componentWillUnmount(){
    //Aqui va el put
  }



  reviewStars(num) {
    let stars = [];
    for(let i= 0; i < num; i++) {
      stars.push(<FontAwesomeIcon key={i}  style={{color:"orange"}}icon={faStar}/>);
    }
    for(let j = stars.length ; j < 5; j++) {
      stars.push(<FontAwesomeIcon key={j+5} style={{color:"#b5b5b5"}}icon={faStar}/>);
    }
    return (
      <span>{stars}</span>
    );
  };

  render(){
    const styles = {
      book__title : {
        fontSize: '2.2rem',
        fontWeight: 400
      },
      book__badge : {
        backgroundColor: 'rgb(119, 93, 255)',
        color: 'white',
        fontWeight: 400
      },
      book__description : {
        fontWeight: 300
      },
      edit__button : {
        textDecoration: 'none',
        backgroundColor: 'rgb(119, 93, 255)',
        color: 'white',
        fontWeight: 200,
    }

    }
    return (
        
        <React.Fragment>
            <Row className="mx-0">
              <Col className="px-0">
                <h1 style={styles.book__title}>{this.props.book.titulo}</h1>
                  <h4 className="font-weight-normal">{this.props.book.autor}</h4>
                  <h6 className="mt-3 font-weight-normal">Valoración media: {this.reviewStars(4)}</h6>
                  <h6 className="mt-3 font-weight-normal">Tu valoración: {this.reviewStars(this.state.valoracion)}
                    <button className="ml-2 py-0 px-2 d-inline-block btn btn-outline-secondary" 
                      onClick={() => this.setState({valoracion: this.state.valoracion >0 ? this.state.valoracion-1 : this.state.valoracion})}>-</button>
                    <button className="ml-1 py-0 px-2 d-inline-block btn btn-outline-warning"
                      onClick={() => this.setState({valoracion: this.state.valoracion <5 ? this.state.valoracion+1 : this.state.valoracion})}>+</button>
                </h6>
              </Col>
            </Row>
            <Row className="mx-0 my-3">
              <Col className="px-0">
                <Badge pill className="mr-2 px-4 py-1" style={styles.book__badge}>{this.props.book.categoria}</Badge>
              </Col>
            </Row>
            <Row className="mx-0">
              <Col className="px-0">
                <p style={styles.book__description}>{this.props.book.resena}</p>
              </Col>
            </Row>
            <Row className="mx-0">
              <Col xs={6} className="px-0">
                <Button className="p-2 w-100 h-100 d-block text-center rounded" style={styles.edit__button} disabled>Añadir Reedición</Button>
              </Col>
            </Row>
            <Row className="mx-0">
              <Col xs={12} className="px-0">
                <Comments user={this.props.user} book={this.props.book} history={this.props.history} postFetch={this.props.postFetch}/>
              </Col>
            </Row>

        </React.Fragment>
    );
  }
}