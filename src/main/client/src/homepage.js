import React from 'react';
import './style/homepage.css';
import TodoForm from "./components/todoform";
import TodoCurrent from "./components/todocurrent";

class Homepage extends React.Component{
    constructor(props){
        super(props);
    }
    render(){
        return(
            <div className="Site-Content">
                <h1 className="Title">Todo List</h1>
                <div className="Todo-Container">
                    <TodoCurrent />
                </div>
            </div>
        )
    }
}

export default Homepage;