import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {Route, BrowserRouter as Router} from "react-router-dom";
import Navigation from "./containers/Navigation.react";
import CompanyTable from "./containers/CompanyTable.react";
import AddressTable from "./containers/AddressTable.react";
import OfficeTable from "./containers/OfficeTable.react";

class HomePage extends React.Component {
  render() {
    return <div>Home Page</div>
  }
}

ReactDOM.render(
  <Router >
    <div >
      <Navigation />
      <Route exact path="/" component={HomePage} />
      <Route path="/companies" component={CompanyTable} />
      <Route path="/addresses" component={AddressTable} />
      <Route path="/offices" component={OfficeTable} />
    </div >
  </Router >,
  document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
