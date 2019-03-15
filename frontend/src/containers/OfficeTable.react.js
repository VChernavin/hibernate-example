import React from "react";
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import {getBindedApi, getData} from "../api/api";
import TableButtonGroup from "./TableButtonGroup.react";
import {connect} from "react-redux";
import {receivedList, updateMenu} from "../actions/actions";
import {OFFICES_MENU_ITEM} from "../constants/menuItems";
import {ADDRESS_API_ID, COMPANY_API_ID, OFFICE_API_ID} from "../constants/api";

const cellEditProp = {
  mode: 'click',
  blurToSave: true
};


export class OfficeTable extends React.Component {

  api = getBindedApi(OFFICE_API_ID, this.props.receivedOfficeList);

  componentDidMount() {
    this.props.updateMenu(OFFICES_MENU_ITEM.text);
    getData(COMPANY_API_ID, this.props.receivedCompanyList)
      .then(() => getData(ADDRESS_API_ID, this.props.receivedAddressList))
      .then(this.api.getData);
  }

  parseOffice = office => ({
    name: office.name,
    company_id: this.props.companyMap.get(office.company).id,
    address: this.props.addressMap.get(office.address),
  });

  onAddRow = row => {
    this.api.onAdd(this.parseOffice(row));

  };

  onDeleteRow = (row) => {
    this.api.onDelete(row);

  };

  onCellEdit = (row, fieldName, value) => {
    const targetRow = {
      id: row.id,
      name: fieldName === "name" ? value : row.name,
      address: fieldName === "address" ? this.props.addressMap.get(value) : this.props.addressMap.get(row.address),
      company_id: fieldName === "company" ? this.props.companyMap.get(value).id : this.props.companyMap.get(row.company).id,
    };
    this.api.onUpdate(targetRow);
  };


  render() {

    const btnGroup = props => <TableButtonGroup exportCSVBtn={props.exportCSVBtn}
                                                insertBtn={props.insertBtn}
                                                deleteBtn={props.deleteBtn}
                                                onCSVFileLoaded={data => data.forEach(obj => this.api.onAdd(this.parseOffice(obj)))} />;


    const options = {
      onAddRow: this.onAddRow,
      onDeleteRow: this.onDeleteRow,
      onCellEdit: this.onCellEdit,
      btnGroup,
    };

    return (
      <div >
        <BootstrapTable data={this.props.officeList}
                        remote={true}
                        deleteRow={true}
                        selectRow={{mode: 'checkbox'}}
                        cellEdit={cellEditProp}
                        options={options}
                        exportCSV={true}
                        insertRow={true}
                        striped hover condensed >
          <TableHeaderColumn width='100' dataField='id' editable={false} isKey export={false} >ID</TableHeaderColumn >
          <TableHeaderColumn width='400' dataField='name' >Name</TableHeaderColumn >
          <TableHeaderColumn width='400' dataField='company'
                             editable={{type: 'select', options: {values: [...this.props.companyMap.keys()]}}} >Company</TableHeaderColumn >
          <TableHeaderColumn dataField='address'
                             editable={{type: 'select', options: {values: [...this.props.addressMap.keys()]}}} >Address</TableHeaderColumn >
        </BootstrapTable >
      </div >
    );
  }
}


export default connect(
  state => ({
      companyMap: new Map(state.receivedDataReducer.companyList.map(company => [company.name, company])),
      addressMap: new Map(state.receivedDataReducer.addressList.map(address => [`${address.street} , ${address.houseNumber} , ${address.zipCode}`, address])),
      officeList: Array.from(state.receivedDataReducer.officeList, office => {
        return{
          id: office.id,
          name: office.name,
          company: state.receivedDataReducer.companyList.filter(company => company.id === office.company_id)[0].name,
          address: `${office.address.street} , ${office.address.houseNumber} , ${office.address.zipCode}`,
        }}
      ),
    }
  ),
  dispatch => ({
    updateMenu: (focused) => {
      dispatch(updateMenu(focused));
    }, receivedOfficeList: (list) => {
      dispatch(receivedList(list, OFFICE_API_ID));
    },
    receivedAddressList: (list) => {
      dispatch(receivedList(list, ADDRESS_API_ID));
    },
    receivedCompanyList: (list) => {
      dispatch(receivedList(list, COMPANY_API_ID));
    },
  })
)(OfficeTable);