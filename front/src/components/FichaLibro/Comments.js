import React from 'react';
import {Button,Col} from 'react-bootstrap';
import '../../css/pseudoElement.css';


export default class Comments extends React.Component {
    
    constructor(props) {
        super(props);
        this.state = { 
            comment : []
        };
    }

    componentDidMount(){
        this.setState({comment:this.props.book.comentarios})
    }

    handleComment = (e) =>{
        this.setState({comment:e.target.value});
    }

    handleClick = async () => {
        if(this.props.user === null){
            this.props.history.push("/login")
        }else{
            if(this.state.comment.trim() === "" ){
                alert("Debe rellenar todos los campos para registrarte");
            }else{
                let paramsToUpdate = {
                    comentario : this.state.comment.trim(),
                    ISBN : this.props.book.ISBN
                }
                const res = await this.props.postFetch("AddCommentToBookInfoServlet",paramsToUpdate)
                console.log(res);
            }
        }
    }

    render(){

        const styles = {
            button : {
                backgroundColor : 'rgba(119, 93, 255)',
                border: '2px solid rgba(119, 93, 255)',
            }
        }
        return (
            <div className="my-4 h-auto w-100">
                <div>
                    <h5 className="font-weight-normal">Comentarios:</h5>
                    <p>Este libro está genial</p>                        
                    <textarea className="h-auto w-100 border borderInfo" type="text" style={{resize: "none"}} 
                    onChange={(e) => this.handleComment(e)}/>
                    <Button  className="my-2 py-2 px-5 font-weight-lighter button__hover" style={styles.button} 
                    onClick={() => this.handleClick()}> 
                    {this.props.user === null ? "Registrate para comentar" : "Añadir comentario"}
                    </Button>
                </div>
            </div>
        )
    }
}
