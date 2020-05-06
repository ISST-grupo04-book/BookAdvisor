import React, { Fragment } from 'react';
import {BrowserRouter as Router,Switch,Route,useParams} from "react-router-dom";
import FichaLibro from './FichaLibro/FichaLibro';
import Home from './Home/Home';
import Categorias from './Categorias/Categorias';
import Narrativa from './Categorias/Narrativa/Narrativa';
import Access from './Access/AccessLayout';
import Profile from './Profile/ProfileLayout';
import Nav from './Nav';
import '../css/App.css';


export default class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
        user : {},
        res : ""
    } 
  };

  getFetch = async(servlet="",query="") => {
    const URI = "http://localhost:8080/BookAdvisor/";    
    const petition = await fetch(URI+servlet+query);
    const petitionJson = await (petition.json());
    const parseJson = await JSON.parse(petitionJson);
    return parseJson;
  }

  postFetch = async(servlet="",data) => {
    const URI = "http://localhost:8080/BookAdvisor/"; 
    const headers = { 'Content-Type': 'application/json' }
    let myInit = { method: 'POST',
               headers: headers,
               body: JSON.stringify(data)
              };
    
    const response = await fetch(URI+servlet,myInit);
    const responseJson = await response.json();
    this.setState({res:responseJson});
  }

  putFetch = async(servlet="",data) => {
    const URI = "http://localhost:8080/BookAdvisor/"; 
    const headers = { 'Content-Type': 'application/json' }
    let myInit = { method: 'PUT',
               headers: headers,
               body: JSON.stringify(data)
              };
    
    const response = await fetch(URI+servlet,myInit);
    const responseJson = await response.json();
    this.setState({res:responseJson});
  }

  deleteFetch = async(servlet ="", data) => {
    const URI = "http://localhost:8080/BookAdvisor/"; 
    const headers = { 'Content-Type': 'application/json' }
    let myInit = { method: 'DELETE',
               headers: headers,
               body: JSON.stringify(data)
              };
    
    const response = await fetch(URI+servlet,myInit);
    const responseJson = await response.json();
    this.setState({res:responseJson});
  }

  render(){
    return (
        <Router>
            <Switch>
              <Route path="/signup/newPassword">
                <Access view="Signup" name="Psd"/>
              </Route>
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
              <Route path="/narrativa">
                <Nav/>
                <Narrativa/>
              </Route>
              <Route path="/book/:ISBN" render={(props) => <FichaLibro {...props}  getFetch={this.getFetch}/>}>
              </Route>
              <Route path="/login">
                <Access postFetch={this.postFetch}/>
              </Route>
              <Route path="/profile">
                <Nav/>
                <Profile/>
              </Route>
              <Route path="/">
                <Nav/>
                <Home getFetch={this.getFetch}/>
              </Route>
            </Switch>
        </Router>
    );
  }
}


