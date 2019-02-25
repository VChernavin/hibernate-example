import React from "react";
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import {getCompanies, onAdd, onDelete, onUpdate} from "../api/api";

const cellEditProp = {
  mode: 'click',
  blurToSave: true
};

const OBJECT_TYPE = 'company';


export class CompanyTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      companies: []
    };


  }

  componentDidMount() {
    getCompanies(OBJECT_TYPE, this.setStateHandler);
  }

  onAddRow = (row) => {
    onAdd(OBJECT_TYPE, this.setStateHandler, {name: row.name});

  }

  onDeleteRow = (row) => {
    onDelete(OBJECT_TYPE, this.setStateHandler, row);

  };

  onCellEdit = (row, fieldName, value) => {
    const {companies} = this.state;
    let rowIdx;
    const targetRow = companies.find((prod, i) => {
      if (prod.id === row.id) {
        rowIdx = i;
        return true;
      }
      return false;
    });
    if (targetRow) {
      targetRow[fieldName] = value;
      console.log(typeof targetRow);
      onUpdate(OBJECT_TYPE, this.setStateHandler, targetRow);
    }
  };

  setStateHandler = (res) => {
    const companies = res.data;
    this.setState({companies});
  };

  render() {

    const options = {
      onAddRow: this.onAddRow,
      onDeleteRow: this.onDeleteRow,
      onCellEdit: this.onCellEdit
    };

    return (
      <BootstrapTable data={this.state.companies}
                      remote={true}
                      deleteRow={true}
                      selectRow={{mode: 'checkbox'}}
                      cellEdit={cellEditProp}
                      options={options}
                      insertRow={true}
                      striped hover condensed >
        <TableHeaderColumn width='100' dataField='id' editable={false} isKey >ID</TableHeaderColumn >
        <TableHeaderColumn dataField='name' >Name</TableHeaderColumn >
      </BootstrapTable >
    );
  }
}