import React from 'react';
import '../style/todocurrent.css';
import '../style/todoform.css';

class TodoCurrent extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            tasks:[]
        };
        this.updateTask = this.updateTask.bind(this);
        this.getTasks = this.getTasks.bind(this);
        this.createTask = this.createTask.bind(this);
        this.deleteTask = this.deleteTask.bind(this);
    }
    componentDidMount() {
        this.getTasks();
    }

    deleteTask(event){
        event.preventDefault();
        let id = parseInt(event.target.form[0].name);
        let fetchData = {
            method: "DELETE",
            headers: {'Content-Type': 'application/json;charset=utf-8'}
        };
        fetch('/api/person/'+ id, fetchData)
            .then(()=>{
                this.getTasks();
            }).catch(err=>{
                console.log(err);
        })
    }

    createTask(event){
        event.preventDefault();

        let data = {
            name: event.target.form[0].value,
            task:{
                description: event.target.form[1].value
            }
        }
        let fetchData = {
            method: "POST",
            body: JSON.stringify(data),
            headers: {'Content-Type': 'application/json;charset=utf-8'}
        }
        fetch('/api/person', fetchData)
            .then(()=>{
                this.getTasks();
            }).catch(err=>{
                console.log(err);
        })
    }

    getTasks(){
        fetch('/api/person')
            .then(response => response.json())
            .then(data=>{
                this.setState({tasks: data});
            }).catch(err=>{
            console.log(err);
        })
    }
    updateTask(event){
        event.preventDefault();
        if(event.target.form[0].value !== "" || event.target.form[1].value !== ""){
            let data = {
                id: parseInt(event.target.form[0].name),
                task: {
                    id: parseInt(event.target.form[1].name),
                    description: (event.target.form[1].value === "" ? event.target.form[1].placeholder: event.target.form[1].value)
                },
                name: (event.target.form[0].value === "" ? event.target.form[0].placeholder: event.target.form[0].value)
            }
            let fetchData = {
                method: "POST",
                body: JSON.stringify(data),
                headers: {'Content-Type': 'application/json;charset=utf-8'}
            };
            fetch('/api/person', fetchData)
                .then(()=>{
                    this.getTasks();
                }).catch(err=>{
                    console.log(err);
            })
            // event.target.form.reset();
        }
    }
    render(){
        return(
            <div className="Main-Container">
                <div className="TodoForm-Container">
                    <form className="TodoForm">
                        <div className="Form-Group">
                            <input id="Name" type="text" name="personname" placeholder="Name" maxLength="30"/>
                        </div>
                        <div className="Form-Group">
                            <input id="Task" type="text" name="persontask" placeholder="Task" maxLength="60"/>
                        </div>
                        <input className="Submit-New" type="submit" value="submit" onClick={this.createTask}/>
                    </form>
                </div>
                <div className="TodoCurrent-Container">
                    <div className="TodoList">
                        {this.state.tasks.length > 0 ? this.state.tasks.map((task)=>(
                                <div className="Task" key={""+task.id+task.task.id}>
                                    <form className="Task-Form">
                                        <div className="Task-Input-Container">
                                            <input className="Task-Name" type="text" name={task.id} placeholder={task.name} maxLength="30"/>
                                        </div>
                                        <div className="Task-Input-Container">
                                            <input className="Task-Description" type="text" name={task.task.id} placeholder={task.task.description} maxLength="60"/>
                                        </div>
                                        <input className="Task-Update" type="submit" value="update" onClick={this.updateTask}/>
                                        <input className="Task-Delete" type="submit" value="completed" onClick={this.deleteTask}/>
                                    </form>
                                </div>
                            )
                        ): null}
                    </div>
                </div>
            </div>
        )
    }
}

export default TodoCurrent;