import React from "react";
import {BootstrapTable, ButtonGroup, TableHeaderColumn} from 'react-bootstrap-table';
import {getData, onAdd, onDelete, onUpdate} from "../api/api";
import CSVReader from "./CSVReader.react";

const cellEditProp = {
  mode: 'click',
  blurToSave: true
};

const OBJECT_TYPE = 'address';


export default class AddressTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      addressList: []
    };

  }

  componentDidMount() {
    getData(OBJECT_TYPE, this.setStateHandler);
  }

  onAddRow = (row) => {
    onAdd(OBJECT_TYPE, this.setStateHandler, {
      houseNumber: row.houseNumber,
      street: row.street,
      zipCode: row.zipCode
    });

  };

  onDeleteRow = (row) => {
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
      onUpdate(OBJECT_TYPE, this.setStateHandler, targetRow);
    }
  };

  setStateHandler = (res) => {
    const addressList = res.data;
    this.setState({addressList});
  };

  render() {
    const btnGroup = props => {
      return (
        <ButtonGroup className='my-custom-class' sizeClass='btn-group-sm' >

          <CSVReader onFileLoaded={importCSV} />
          {props.exportCSVBtn}
          {props.insertBtn}
          {props.deleteBtn}
        </ButtonGroup >
      );
    };
    const importCSV = data => {
      data.forEach(obj => onAdd(OBJECT_TYPE, this.setStateHandler, obj));
    };

    const options = {
      onAddRow: this.onAddRow,
      onDeleteRow: this.onDeleteRow,
      onCellEdit: this.onCellEdit,
      btnGroup,
    };

    return (
      <div >
        <BootstrapTable data={this.state.addressList}
                        remote={true}
                        deleteRow={true}
                        selectRow={{mode: 'checkbox'}}
                        cellEdit={cellEditProp}
                        options={options}
                        exportCSV={true}
                        insertRow={true}
                        striped hover condensed >
          <TableHeaderColumn width='100' dataField='id' editable={false} isKey export={false} >ID</TableHeaderColumn >
          <TableHeaderColumn dataField='street' >Street</TableHeaderColumn >
          <TableHeaderColumn width='100' dataField='houseNumber' >House Number</TableHeaderColumn >
          <TableHeaderColumn width='400' dataField='zipCode' >ZIP Code</TableHeaderColumn >
        </BootstrapTable >
      </div >
    );
  }
}