import React from 'react';
import {BrowserRouter as Router,Switch,Route} from "react-router-dom";
import FichaLibro from './FichaLibro/FichaLibro';
import Home from './Home/Home';
import Categorias from './Categorias/Categorias';
import Access from './Access/AccessLayout';
import Profile from './Profile/ProfileLayout';
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
              <Route path="/profile/my_profile">
                <Nav/>
                <Profile name="My_profile"/>
              </Route>
              <Route path="/profile/my_books">
                <Nav/>
                <Profile name="My_books"/>
              </Route>
              <Route path="/profile/add_book">
                <Nav/>
                <Profile name="Add_book"/>
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
              <Route path="/profile">
                <Nav/>
                <Profile/>
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


