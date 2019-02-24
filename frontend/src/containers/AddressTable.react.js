import React from "react";
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import {getCompanies, onAdd, onDelete,onUpdate} from "../api/api";

const cellEditProp = {
  mode: 'click',
  blurToSave: true
};

const OBJECT_TYPE ='address';


export class AddressTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      addressList: []
    };

    this.onAddRow = this.onAddRow.bind(this);
    this.onDeleteRow = this.onDeleteRow.bind(this);
    this.onCellEdit = this.onCellEdit.bind(this);
    this.setStateHandler = this.setStateHandler.bind(this);
  }

  componentDidMount() {
    getCompanies(OBJECT_TYPE, this.setStateHandler);
  }

  onAddRow(row) {
    onAdd(OBJECT_TYPE, this.setStateHandler, {
      houseNumber: row.houseNumber,
      street: row.street,
      zipCode: row.zipCode
    });

  }

  onDeleteRow(row) {
    onDelete(OBJECT_TYPE, this.setStateHandler, row);

  };

  onCellEdit = (row, fieldName, value) => {
    const {addressList} = this.state;
    let rowIdx;
    const targetRow = addressList.find((prod, i) => {
      if (prod.id === row.id) {
        rowIdx = i;
        return true;
      }
      return false;
    });
    if (targetRow) {
      targetRow[fieldName] = value;
      console.log(typeof targetRow);
      onUpdate(OBJECT_TYPE,this.setStateHandler, targetRow);
    }
  };

  setStateHandler(res) {
    const addressList = res.data;
    this.setState({addressList});
  }

  render() {

    const options = {
      onAddRow: this.onAddRow,
      onDeleteRow: this.onDeleteRow,
      onCellEdit: this.onCellEdit
    };

    return (
      <BootstrapTable data={this.state.addressList}
                      remote={true}
                      deleteRow={true}
                      selectRow={{mode: 'checkbox'}}
                      cellEdit={cellEditProp}
                      options={options}
                      insertRow={true} striped hover condensed>
        <TableHeaderColumn width='100' dataField='id' editable={false} isKey >ID</TableHeaderColumn >
        <TableHeaderColumn width='1200' dataField='street' >Street</TableHeaderColumn >
        <TableHeaderColumn width='100' dataField='houseNumber' >House Number</TableHeaderColumn >
        <TableHeaderColumn width='600' dataField='zipCode' >ZIP Code</TableHeaderColumn >
      </BootstrapTable >
    );
  }
}