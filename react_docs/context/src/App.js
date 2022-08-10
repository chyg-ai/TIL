import React, { Component } from "react";
import { ThemeContext, themes } from "./context/theme-context";
import ThemedButton from "./themed-button";

// props { changeTheme: () => { ... } }
function Toolbar(props) {
  return <ThemedButton onClick={props.changeTheme}>Change Theme</ThemedButton>;
}

class App extends Component {
  constructor(props) {
    super(props);

    // 초기 상태
    this.state = {
      theme: themes.light,
    };

    // 상태 변경
    this.toggleTheme = () => {
      this.setState((state) => ({
        theme: state.theme === themes.dark ? themes.light : themes.dark,
      }));
    };
  }

  render() {
    return (
      <>
        {/* createContext(defaultValue) */}
        <ThemeContext.Provider value={this.state.theme}>
          {/* Theme Change */}
          <Toolbar changeTheme={this.toggleTheme} />
        </ThemeContext.Provider>
      </>
    );
  }
}

export default App;
