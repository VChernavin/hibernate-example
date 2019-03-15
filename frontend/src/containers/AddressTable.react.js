import React from "react";
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import {getBindedApi} from "../api/api";
import TableButtonGroup from './TableButtonGroup.react';
import {connect} from "react-redux";
import {receivedList, updateMenu} from "../actions/actions";
import {ADDRESSES_MENU_ITEM} from "../constants/menuItems";
import {ADDRESS_API_ID} from "../constants/api";


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
    const {addressList} = this.props;
    const targetRow = addressList.find(prod => prod.id === row.id);
    if (targetRow) {
      targetRow[fieldName] = value;
      onUpdate(OBJECT_TYPE, this.setStateHandler, targetRow);
    }
  };


  render() {


    const btnGroup = props => <TableButtonGroup exportCSVBtn={props.exportCSVBtn}
                                                insertBtn={props.insertBtn}
                                                deleteBtn={props.deleteBtn}
                                                onCSVFileLoaded={data => data.forEach(obj => onAdd(OBJECT_TYPE, this.setStateHandler, obj))}/>;


    const options = {
      onAddRow: this.onAddRow,
      onDeleteRow: this.onDeleteRow,
      onCellEdit: this.onCellEdit,
      btnGroup,
    };

    return (
      <div >
        <BootstrapTable data={this.props.addressList}
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