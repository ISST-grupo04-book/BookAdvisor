import React from 'react';
import Section from './Section.js';
//import Comments from './Comments.js';

export default class Article extends React.Component {
  render(){
    return (
        <React.Fragment>
            <Section  book={this.props.book}/>
        </React.Fragment>
    );
  }
}