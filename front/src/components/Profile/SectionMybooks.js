import React from 'react';
import Mybooks from './Mybooks'
import '../../css/pseudoElement.css';

export default class SectionMybooks extends React.Component {
    
    constructor(props) {
        super(props);
        this.state = {
        }
      }
    
      handleDelete = () => {}
      
  render(){
    const {bookList} = this.props;
    return (
        <div className="py-5 w-75 h-auto d-flex flex-column" style={{minHeight : '100%'}}>
            <h2 className="pl-4 mt-4 mb-auto  w-100 font-weight-normal">Mis libros</h2>
            <div className=" h-auto w-100 d-flex flex-column justify-content-start align-items-start">
                {
                this.props.bookList.length > 0 ?
                    bookList.map((book,index)=>{
                        return <Mybooks key={index} name={book.name} disponible={book.disponible} img={book.image} delete={this.handleDelete}/>
                    }) 
                    : null
                }
            </div>
        </div>
    );
  }
}