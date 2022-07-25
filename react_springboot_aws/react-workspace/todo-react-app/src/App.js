import React, { Component } from "react";
import Todo from "./Todo";
import AddTodo from "./AddTodo.js";
import { Paper, List, Container } from "@mui/material";
import "./App.css";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [
        { id: "0", title: "Hello World 1", done: true },
        { id: "1", title: "Hello World 2", done: false },
      ],
    };
  }

  add = (item) => {
    const thisItems = this.state.items;
    item.id = "ID-" + thisItems.length;
    item.done = false;
    thisItems.push(item);
    this.setState({ items: thisItems });
    console.log("items : ", this.state.items);
  };

  delete = (item) => {
    const thisItems = this.state.items; // 기존 데이터
    console.log("Before Update Items : ", this.state.items);
    const newItems = thisItems.filter((e) => e.id !== item.id);
    this.setState({ items: newItems }, () => {
      console.log("Update Items : ", this.state.items);
    });
  };

  render() {
    var todoItems = this.state.items.length > 0 && (
      <Paper style={{ margin: 16 }}>
        <List>
          {this.state.items.map((item, idx) => (
            <Todo item={item} key={item.id} delete={this.delete} />
          ))}
        </List>
      </Paper>
    );
    return (
      <div className="App">
        <Container maxWidth="md">
          <AddTodo add={this.add} />
          <div className="TodoList">{todoItems}</div>
        </Container>
      </div>
    );
  }
}

export default App;
