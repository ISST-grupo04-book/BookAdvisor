import React from 'react';
//import FichaLibro from './FichaLibro/FichaLibro';
//import Home from './Home/Home';
//import Categorias from './Categorias/Categorias';
import Access from './Access/AccessLayout';
import Nav from './Nav';
import '../css/App.css';


export default class App extends React.Component {
  render(){
    return (
      <main className="App">
        <Nav/>
        <Access/>
      </main>
    );
  }
}


