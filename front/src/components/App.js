import React from 'react';
import {BrowserRouter as Router,Switch,Route,} from "react-router-dom";
import FichaLibro from './FichaLibro/FichaLibro';
import Home from './Home/Home';
import Categorias from './Categorias/Categorias';
import Access from './Access/AccessLayout';
import Profile from './Profile/ProfileLayout';
import Narrativa from './Categorias/Narrativa/Narrativa'
import '../css/App.css';


export default class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
        listBooks: [],
        user : null
    } 
  };

  getFetch = async(servlet="",query="") => {
    const URI = "http://localhost:8080/BookAdvisor/";    
    const petition = await fetch(URI+servlet+query);
    const petitionJson = await petition.json();
    const parseJson = await JSON.parse(petitionJson);
    return parseJson;
  }

  postFetch = async(servlet="",data) => {
    const URI = "http://localhost:8080/BookAdvisor/"; 
    let myInit = { method: "POST",
                  body: JSON.stringify(data)
                };
    
    const response = await fetch(URI+servlet,myInit);
    const responseJson = await response.json();
    const parseJson = await JSON.parse(responseJson);
    return (parseJson);
    
  }

  changeAppState = (user)=>{
      this.setState({user})
  }
  changeAppNarrativa = (listBooks)=>{
    this.setState({listBooks})
}

  render(){
    return (
        <Router>
            <Switch>
              <Route path="/signup/newPassword" render={(props) => <Access {...props} view="Signup" name="Psd" postFetch={this.postFetch}/>}/>
              <Route path="/signup/user" render={(props) => <Access {...props} view="Signup" name="User" postFetch={this.postFetch}/>}/>
              <Route path="/signup/library" render={(props) => <Access {...props} view="Signup" name="Library" postFetch={this.postFetch}/>}/>
              <Route path="/signup/bookshop" render={(props) => <Access {...props} view="Signup" name="Bookshop" postFetch={this.postFetch}/>}/>
              <Route path="/signup/editorial" render={(props) => <Access {...props} view="Signup" name="Editorial" postFetch={this.postFetch}/>}/>
              <Route path="/profile/my_profile" render={(props) => <Profile {...props} user={this.state.user} name="My_profile"/>}/>
              <Route path="/profile/my_books" render={(props) => <Profile {...props} user={this.state.user} name="My_books"/>}/>
              <Route path="/profile/add_book" render={(props) => <Profile {...props} user={this.state.user} name="Add_book"/>}/>
              <Route path="/signup" render={(props) => <Access {...props} view="Signup" postFetch={this.postFetch}/>}/>
              <Route path="/categorias/narrativa" render={(props) => <Narrativa {...props} user={this.state.user} getFetch={this.getFetch} listBooks={this.state.listBooks}/>}/>
              <Route path="/categorias" render={(props) => <Categorias {...props} user={this.state.user} getFetch={this.getFetch} changeAppNarrativa={this.changeAppNarrativa}/>}/>
              <Route path="/book/:ISBN" render={(props) => <FichaLibro {...props}  user={this.state.user} getFetch={this.getFetch} postFetch={this.postFetch}/>}/>
              <Route path="/login" render={(props) => <Access {...props} postFetch={this.postFetch} changeAppState={this.changeAppState}/>}/>
              <Route path="/profile" render={(props) => <Profile {...props} user={this.state.user} postFetch={this.postFetch}/>}/>
              <Route path="/" render={(props) => <Home {...props} user={this.state.user} getFetch={this.getFetch}/>}/>
              
              
            </Switch>
        </Router>
    );
  }
}


