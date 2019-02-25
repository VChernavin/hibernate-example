import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {Route, BrowserRouter as Router} from "react-router-dom";
import {Navigation} from "./containers/Navigation.react";
import {CompanyTable} from "./containers/CompanyTable.react";
import {AddressTable} from "./containers/AddressTable.react";

ReactDOM.render(
  <Router >
    <div >
      <Navigation />
      <Route path="/companies" component={CompanyTable} />
      <Route path="/addresses" component={AddressTable} />
    </div >
  </Router >,
  document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
