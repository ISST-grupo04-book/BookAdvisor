import React from 'react';
import {Link} from 'react-router-dom';
import {Carousel, Image} from 'react-bootstrap';
import '../../../css/Home/Carousel.css';

export default class Center extends React.Component{
    render(){
        return (

          <div>
          <h4>Narrativa</h4>

            <Carousel className = "carousel">
            <Carousel.Item>
              <Link to='/book'>
              <Image
                className="picture1"
                src="/img/el-nombre-de-la-rosa-2.jpg"
                alt="First slide"
                width = "750px"
                height = "350px"
              />
            </Link>
              <Carousel.Caption>
                <h1>EL NOMBRE DE LA ROSA</h1>
              </Carousel.Caption>

            </Carousel.Item>

            <Carousel.Item>
              <Image
                className="picture2"
                src="/img/cienanos.jpg"
                alt="Third slide"
                width = "750px"
                height = "350px"
              />
          
              <Carousel.Caption>
                <h1>CIEN AÑOS DE SOLEDAD </h1>
              </Carousel.Caption>
            </Carousel.Item>

            <Carousel.Item>
              <Image
                className="picture3"
                src="/img/reinaroja.jpg"
                alt="Third slide"
                width = "750px"
                height = "350px"
              />
          
              <Carousel.Caption>
                <h1>REINA ROJA</h1>
              </Carousel.Caption>
            </Carousel.Item>

          </Carousel>
          </div>
        );
      }
}