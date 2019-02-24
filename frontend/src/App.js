import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import './index.css'
import {
  Collapse,
  DropdownItem,
  DropdownMenu,
  DropdownToggle,
  Nav,
  Navbar,
  NavbarBrand,
  NavbarToggler,
  NavItem,
  NavLink,
  UncontrolledDropdown
} from 'reactstrap';
import {CompanyTable} from "./containers/CompanyTable.react";
import {AddressTable} from "./containers/AddressTable.react";


export default class App extends Component {
  constructor(props) {
    super(props);

  }




  render() {

    return (
      <div >
        <Navbar expand >
          <NavbarBrand href="/" >REACT+SPRING+Hibernate example</NavbarBrand >
          <NavbarToggler onClick={this.toggle} />
          <Collapse  navbar >
            <Nav className="ml-auto" navbar >
              <NavItem >
                <NavLink href="/components/" >Components</NavLink >
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

        {/*<CompanyList companies={this.state.companies}*/}
                     {/*onDelete={this.onDeleteRow}*/}
                     {/*onAdd={this.onAddRow}*/}
                     {/*refresh={this.refreshList} />*/}
        <CompanyTable  />
        <AddressTable  />
      </div >
    );
  }
}


ReactDOM.render(
  <App />,
  document.getElementById('root')
);
