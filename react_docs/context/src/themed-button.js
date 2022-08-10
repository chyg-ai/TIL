import React, { Component } from "react";
import { ThemeContext } from "./context/theme-context";

class ThemedButton extends Component {
  // static contextType = ThemeContext;

  constructor(props) {
    super(props);
    this.state = {
      toggleTheme: props.onClick,
      children: props.children,
    };
  }

  render() {
    const { children, toggleTheme } = this.state;
    let theme = this.context; // ThemeContext.provider value
    return (
      <button
        onClick={toggleTheme}
        style={{ backgroundColor: theme.foreground }}
      >
        {children}
      </button>
    );
    a;
  }
}

ThemedButton.contextType = ThemeContext;

export default ThemedButton;
