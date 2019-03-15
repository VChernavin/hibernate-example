import React from "react";
import {Link} from 'react-router-dom'
import {connect} from "react-redux";
import {updateMenu} from "../actions/actions";


export class Menu extends React.Component {


  render() {

    return (
      <div className="btn-group btn-group-lg" role="group" >
        {this.props.items.map((m, index) => {
          const style = this.props.focused === m.text ? 'btn btn-primary btn-lg' : 'btn btn-outline-info btn-lg';
          return <Link className={style} key={index} to={m.link} >{m.text}</Link >;
        })}
      </div >
    );

  }
}

export default connect(
  state => ({
    focused: state.menuReducer.focused
  }),
  dispatch => ({
    updateMenu: (focused) => {
      dispatch(updateMenu(focused));
    }
  })
)(Menu);
