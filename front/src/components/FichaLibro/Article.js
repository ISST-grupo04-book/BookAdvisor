import React from 'react';
import Section from './Section.js';
//import Comments from './Comments.js';

export default class Article extends React.Component {
  constructor(props){
    super(props)
    this.state = {
      book:{}
    }
  }
  componentDidMount(){
    this.setState({book:this.props.book1})
  }
  render(){
    return (
        <React.Fragment>
            <Section  book={this.props.book1} user={this.props.user} history={this.props.history} postFetch={this.props.postFetch}/>
        </React.Fragment>
    );
  }
}