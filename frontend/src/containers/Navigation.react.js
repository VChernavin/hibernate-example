import React, {Component} from "react";
import Menu from "./Menu.react";


export default class Navigation extends Component {
  render() {

    return (
      <div className='nav-menu' >

        <Menu items={[
          {text: 'Home', link: '/'},
          {text: 'Companies', link: '/companies'},
          {text: 'Addresses', link: '/addresses'},
          {text: 'Offices', link: '/offices'},
        ]} />

      </div >
    );
  }
}