import React from 'react';
import {Container,Row,Col, Button, Carousel, Image} from 'react-bootstrap';
import '../../css/Home/Carousel.css';

export default class Center extends React.Component{
    render(){
        return (

          <div>
          <h4>Novedades del Mes</h4>

            <Carousel className = "carousel">
            <Carousel.Item>
              <Image
                className="picture1"
                src="img/señoranillos.jpeg"
                alt="First slide"
                width = "750px"
                height = "350px"
              />

              <Carousel.Caption>
                <h1>EL SEÑOR DE LOS ANILLOS</h1>
              </Carousel.Caption>

            </Carousel.Item>

            <Carousel.Item>
              <Image
                className="picture2"
                src="img/lospilaresdelatierra.jpg"
                alt="Third slide"
                width = "750px"
                height = "350px"
              />
          
              <Carousel.Caption>
                <h1>LOS PILARES DE LA TIERRA </h1>
              </Carousel.Caption>
            </Carousel.Item>

            <Carousel.Item>
              <Image
                className="picture3"
                src="img/library.jpg"
                alt="Third slide"
                width = "750px"
                height = "350px"
              />
          
              <Carousel.Caption>
                <h1>BIBLIOTECAS</h1>
              </Carousel.Caption>
            </Carousel.Item>

          </Carousel>
          </div>
        );
      }
}