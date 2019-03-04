import React from "react";
import { Link } from 'react-router-dom'


export default class Menu extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      focused: 0
    };

  }


  clicked = (focused) => {

    this.setState({focused});
    console.log(this.state.focused)
  };

  render() {

    return (
      <div className="btn-group btn-group-lg" role="group">
        {this.props.items.map((m, index)=> {
          const style = this.state.focused === index ? 'btn btn-primary btn-lg' : 'btn btn-outline-info btn-lg';
           return <Link className={style} onClick={this.clicked.bind(this, index)} to={m.link}>{m.text}</Link>;
        })}
      </div >
    );

  }
}
