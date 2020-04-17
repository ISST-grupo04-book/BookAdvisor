import React from "react";
import Book from './book/Book.js'
import AccessLayout from './access/AccessLayout.js'
import {BrowserRouter as Router,Switch,Route,Link} from "react-router-dom";
import '../css/App.css';


export default class App extends React.Component {
  render(){
    return (
      <Router>
      <div>
        <nav style={{backgroundColor: "lightblue"}}>
          <ul>
            <li>
              <Link to="/book">Ficha Libro</Link>
            </li>
            <li>
              <Link to="/login">Iniciar Sesion</Link>
            </li>
            <li>
              <Link to="/signup">Registrarse</Link>
            </li>
            <li>
              <Link to="/signup/user">Registrarse Usuario</Link>
            </li>
            <li>
              <Link to="/signup/library">Registrarse Biblioteca</Link>
            </li>
            <li>
              <Link to="/signup/bookshop">Registrarse Librería</Link>
            </li>
            <li>
              <Link to="/signup/editorial">Registrarse Editorial</Link>
            </li>
          </ul>
        </nav>

        <Switch>
          <Route path="/book">
            <Book />
          </Route>
          <Route path="/login">
            <AccessLayout/>
          </Route>
          <Route path="/signup/user">
            <AccessLayout view="Signup" name="User" />
          </Route>
          <Route path="/signup/library">
            <AccessLayout view="Signup" name="Library" />
          </Route>
          <Route path="/signup/bookshop">
            <AccessLayout view="Signup" name="Bookshop" />
          </Route>
          <Route path="/signup/editorial">
            <AccessLayout view="Signup" name="Editorial" />
          </Route>
          <Route path="/signup">
            <AccessLayout view="Signup"/>
          </Route>
        </Switch>
      </div>
    </Router>
    );
  }
}


