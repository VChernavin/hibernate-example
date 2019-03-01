import React, {Component} from "react";
import {Link} from "react-router-dom";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavLink,
  NavItem,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem } from 'reactstrap';



export default class Navigation extends Component {
  render() {

    return (
      <div >
        <Navbar expand >
          <NavbarBrand href="/" >REACT+SPRING+Hibernate example</NavbarBrand >
          <NavbarToggler onClick={this.toggle} />
          <Collapse  navbar >
            <Nav className="ml-auto" navbar >
              <NavItem >
                <NavLink tag={Link} to="/companies" >Companies</NavLink >
              </NavItem >
              <NavItem >
                <NavLink tag={Link} to="/addresses" >Addresses</NavLink >
              </NavItem >
              <NavItem >
                <NavLink href="https://github.com/VChernavin/hibernate-example" >GitHub</NavLink >
              </NavItem >
              <UncontrolledDropdown nav inNavbar >
                <DropdownToggle nav caret >
                  Options
                </DropdownToggle >
                <DropdownMenu right >
                  <DropdownItem >
                    Option 1
                  </DropdownItem >
                  <DropdownItem >
                    Option 2
                  </DropdownItem >
                  <DropdownItem divider />
                  <DropdownItem >
                    Reset
                  </DropdownItem >
                </DropdownMenu >
              </UncontrolledDropdown >
            </Nav >
          </Collapse >
        </Navbar >
        
      </div >
    );
  }
}