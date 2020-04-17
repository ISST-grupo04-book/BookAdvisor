import React from 'react';
import {BrowserRouter as Router,Switch,Route,Redirect} from "react-router-dom";
import FichaLibro from './FichaLibro/FichaLibro';
import Home from './Home/Home';
import Categorias from './Categorias/Categorias';
import Access from './Access/AccessLayout';
import Nav from './Nav';
import '../css/App.css';


export default class App extends React.Component {
  render(){
    return (
        <Router>
            <Switch>
              <Route path="/signup/user">
                <Access view="Signup" name="User" />
              </Route>
              <Route path="/signup/library">
                <Access view="Signup" name="Library" />
              </Route>
              <Route path="/signup/bookshop">
                <Access view="Signup" name="Bookshop" />
              </Route>
              <Route path="/signup/editorial">
                <Access view="Signup" name="Editorial" />
              </Route>
              <Route path="/signup">
                <Access view="Signup"/>
              </Route>
              <Route path="/categorias">
                <Nav/>
                <Categorias/>
              </Route>
              <Route path="/book">
                <Nav/>
                <FichaLibro />
              </Route>
              <Route path="/login">
                <Access/>
              </Route>
              <Route path="/">
                <Nav/>
                <Home/>
              </Route>
            </Switch>
        </Router>
    );
  }
}


