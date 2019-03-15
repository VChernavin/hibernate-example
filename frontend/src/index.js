import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {Provider} from "react-redux";
import {BrowserRouter as Router, Route} from "react-router-dom";
import Navigation from "./containers/Navigation.react";
import CompanyTable from "./containers/CompanyTable.react";
import AddressTable from "./containers/AddressTable.react";
import HomePage from "./containers/HomePage.react";
import OfficeTable from "./containers/OfficeTable.react";
import configureStore from "./store/configureStore";

const store = configureStore();

ReactDOM.render(
  <Provider store={store} >
    <Router >
      <div >
        <Navigation />
        <Route exact path="/" component={HomePage} />
        <Route path="/companies" component={CompanyTable} />
        <Route path="/addresses" component={AddressTable} />
        <Route path="/offices" component={OfficeTable} />
      </div >
    </Router >
  </Provider >,
  document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
