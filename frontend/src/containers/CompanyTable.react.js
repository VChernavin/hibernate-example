import React from "react";
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import {getData, onAdd, onDelete, onUpdate} from "../api/api";
import CSVReader from "../containers/CSVReader.react";

const cellEditProp = {
  mode: 'click',
  blurToSave: true
};

const OBJECT_TYPE = 'company';


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
      onCellEdit: this.onCellEdit
    };

    // const paramNames = [];
    //
    // const resultList = [];
    //
    // const createObject = (item, index) => {
    //   if (index === 0) {
    //     item.forEach(propenty => paramNames.push(propenty));
    //   } else if (item[0] !== "") {
    //     const tmpObj = {};
    //     item.forEach((item, index) => {
    //       tmpObj[paramNames[index]] = item;
    //       // console.log(tmpObj);
    //       resultList.push(tmpObj);
    //     })
    //   }
    // };

    const handleForce = data => {
      data.forEach(obj => onAdd(OBJECT_TYPE, this.setStateHandler, obj));
    };

    return (
      <div className="react-bs-container" >
        <CSVReader onFileLoaded={handleForce} />

        <BootstrapTable data={this.state.companies}
                        remote={true}
                        deleteRow={true}
                        selectRow={{mode: 'checkbox'}}
                        cellEdit={cellEditProp}
                        options={options}
                        insertRow={true}
                        exportCSV={true}
                        striped hover condensed >
          <TableHeaderColumn width='100' dataField='id' editable={false} isKey export={false} >ID</TableHeaderColumn >
          <TableHeaderColumn dataField='name' >Name</TableHeaderColumn >
        </BootstrapTable >
      </div >

    );
  }
}