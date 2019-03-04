import React from "react";
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import {getData, onAdd, onDelete, onUpdate} from "../api/api";
import CSVReader from "../containers/CSVReader.react";

const cellEditProp = {
  mode: 'click',
  blurToSave: true
};

const OBJECT_TYPE = 'company';

class BSTable extends React.Component {
  render() {
    if (this.props.data) {
      return (
        <BootstrapTable data={this.props.data} >
          <TableHeaderColumn width='100' dataField='id' editable={false} isKey export={false} >ID</TableHeaderColumn >
          <TableHeaderColumn width='400' dataField='name' >Name</TableHeaderColumn >
          <TableHeaderColumn dataField='street' >Street</TableHeaderColumn >
          <TableHeaderColumn width='100' dataField='houseNumber' >House Number</TableHeaderColumn >
          <TableHeaderColumn width='400' dataField='zipCode' >ZIP Code</TableHeaderColumn >
        </BootstrapTable >);
    } else {
      return (<p >?</p >);
    }
  }
}

export default class CompanyTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      companies: []
    };


  }

  componentDidMount() {
    getData(OBJECT_TYPE, this.setStateHandler);
  }

  onAddRow = (row) => {
    onAdd(OBJECT_TYPE, this.setStateHandler, {name: row.name});

  };

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
      onCellEdit: this.onCellEdit,
      expandRowBgColor: 'MediumAquamarine',
    };

    const selectRow = {
      mode: 'checkbox',
      clickToSelect: true,
      clickToExpand: true
    };

    const expandColumnComponent = ({isExpandableRow, isExpanded}) => {
      let content = '';

      if (isExpandableRow) {
        content = (isExpanded ? '(-)' : '(+)');
      } else {
        content = ' ';
      }
      return (
        <div > {content} </div >
      );
    };

    const expandColumnOptions = {
      expandColumnVisible: true,
      expandColumnComponent,
      columnWidth: 50
    };


    const handleForce = data => {
      data.forEach(obj => onAdd(OBJECT_TYPE, this.setStateHandler, obj));
    };

    const isExpandableRow = row => row.offices.length > 0;

    const expandComponent = row => {
      let offices = row.offices.map(office => {
        return {
          id: office.id,
          name: office.name,
          street: office.address.street,
          houseNumber: office.address.houseNumber,
          zipCode: office.address.zipCode,
        }
      });
      return (
        <BSTable data={offices} />
      );
    };

    return (
      <div className="react-bs-container" >
        <CSVReader onFileLoaded={handleForce} />

        <BootstrapTable data={this.state.companies}
                        remote={true}
                        deleteRow={true}
                        selectRow={selectRow}
                        cellEdit={cellEditProp}
                        expandableRow={isExpandableRow}
                        expandComponent={expandComponent}
                        expandColumnOptions={expandColumnOptions}
                        options={options}
                        insertRow={true}
                        exportCSV={true}
                        striped hover condensed >
          <TableHeaderColumn width='100' dataField='id' editable={false} isKey export={false} hiddenOnInsert>ID</TableHeaderColumn >
          <TableHeaderColumn dataField='name' >Name</TableHeaderColumn >
        </BootstrapTable >
      </div >

    );
  }
}