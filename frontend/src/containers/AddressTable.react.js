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



class AddressTable extends React.Component {

  api = getBindedApi(ADDRESS_API_ID, this.props.receivedAddressList);

  componentDidMount() {
    this.props.updateMenu(ADDRESSES_MENU_ITEM.text);
    this.api.getData();
  }

  onAddRow = (row) => {
    this.api.onAdd( {
      houseNumber: row.houseNumber,
      street: row.street,
      zipCode: row.zipCode
    });

  };

  onDeleteRow = (row) => {
    this.api.onDelete( row);

  };

  onCellEdit = (row, fieldName, value) => {
    const {addressList} = this.props;
    const targetRow = addressList.find(prod => prod.id === row.id);
    if (targetRow) {
      targetRow[fieldName] = value;
      this.api.onUpdate( targetRow);
    }
  };


  render() {


    const btnGroup = props => <TableButtonGroup exportCSVBtn={props.exportCSVBtn}
                                                insertBtn={props.insertBtn}
                                                deleteBtn={props.deleteBtn}
                                                onCSVFileLoaded={data => data.forEach(obj => this.api.onAdd( obj))}/>;


    const options = {
      onAddRow: this.onAddRow,
      onDeleteRow: this.onDeleteRow,
      onCellEdit: this.onCellEdit,
      btnGroup,
    };
console.log(this.props);
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

export default connect(
        state => ({
          addressList: state.receivedDataReducer.addressList,
        }),
    dispatch => ({
      updateMenu:(focused) => {
        dispatch(updateMenu(focused));
      },
      receivedAddressList: (list) => {
        dispatch(receivedList(list, ADDRESS_API_ID));
      },
    })
)(AddressTable);