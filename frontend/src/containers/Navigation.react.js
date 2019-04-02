import React, {Component} from "react";
import Menu from "./Menu.react";
import {MENU_ITEMS} from "../constants/menuItems";


export default class Navigation extends Component {
  render() {

    return (
      <div className='nav-menu' >

        <Menu items={MENU_ITEMS} />

      </div >
    );
  }
}