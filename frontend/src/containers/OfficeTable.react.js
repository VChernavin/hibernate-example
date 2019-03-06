import React from "react";
import {BootstrapTable, ButtonGroup, TableHeaderColumn} from 'react-bootstrap-table';
import {getData, onAdd, onDelete, onUpdate} from "../api/api";
import TableButtonGroup from "./TableButtonGroup.react";

const cellEditProp = {
  mode: 'click',
  blurToSave: true
};

const OBJECT_TYPE = 'office';




export default class OfficeTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      officeList: [],
      companyMap: new Map(),
      addressMap: new Map(),
    };

  }

  componentDidMount() {
    getData('company', res => {
      const companyMap = new Map();
      res.data.forEach(company => companyMap.set(company.name, company.id));
      this.setState({companyMap});
    }).then(() => {
        return getData('address', res => {
          const addressMap = new Map();
          res.data.forEach(address => addressMap.set(`${address.street} , ${address.houseNumber} , ${address.zipCode}`, address));
          this.setState({addressMap});
        })
      }
    ).then(() => {
      return getData(OBJECT_TYPE, this.setStateHandler)
    });
  }

  parseOffice = office => {
    return{
      name: office.name,
      company_id: this.state.companyMap.get(office.company),
      address: this.state.addressMap.get(office.address),
    }};

  onAddRow = row => {
    onAdd(OBJECT_TYPE, this.setStateHandler, this.parseOffice(row));

  };

  onDeleteRow = (row) => {
    onDelete(OBJECT_TYPE, this.setStateHandler, row);

  };

  onCellEdit = (row, fieldName, value) => {
    console.log(row);
    const targetRow = {
      id: row.id,
      name: fieldName === "name" ? value: row.name,
      address: fieldName === "address" ? this.state.addressMap.get(value) : this.state.addressMap.get(row.address),
      company_id: fieldName === "company" ? this.state.companyMap.get(value) : this.state.companyMap.get(row.company[0]),
    };
    console.log(targetRow);

    onUpdate(OBJECT_TYPE, this.setStateHandler, targetRow);
  };

  setStateHandler = res => {
    const officeList = res.data.map(value => ({
      id: value.id,
      name: value.name,
      address: `${value.address.street} , ${value.address.houseNumber} , ${value.address.zipCode}`,
      company: [...this.state.companyMap.entries()].filter(([key, mapValue]) => mapValue === value.company_id).map(([key]) => key),
    }));
    this.setState({officeList});
  };

  render() {

    const btnGroup = props => <TableButtonGroup exportCSVBtn={props.exportCSVBtn}
                                                insertBtn={props.insertBtn}
                                                deleteBtn={props.deleteBtn}
                                                onCSVFileLoaded={data => data.forEach(obj => onAdd(OBJECT_TYPE, this.setStateHandler, this.parseOffice(obj)))}/>;


    const options = {
      onAddRow: this.onAddRow,
      onDeleteRow: this.onDeleteRow,
      onCellEdit: this.onCellEdit,
      btnGroup,
    };


    return (
      <div >
        <BootstrapTable data={this.state.officeList}
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
                             editable={{type: 'select', options: {values: [...this.state.companyMap.keys()]}}} >Company</TableHeaderColumn >
          <TableHeaderColumn dataField='address'
                             editable={{type: 'select', options: {values: [...this.state.addressMap.keys()]}}} >Address</TableHeaderColumn >
        </BootstrapTable >
      </div >
    );
  }
}