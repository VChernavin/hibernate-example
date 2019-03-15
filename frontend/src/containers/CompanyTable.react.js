import React from "react";
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import {getBindedApi} from "../api/api";
import TableButtonGroup from "./TableButtonGroup.react";
import {connect} from "react-redux";
import {receivedList, updateMenu} from "../actions/actions";
import {COMPANIES_MENU_ITEM} from "../constants/menuItems";
import {COMPANY_API_ID} from "../constants/api";

const cellEditProp = {
  mode: 'click',
  blurToSave: true
};


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

export class CompanyTable extends React.Component {

  api = getBindedApi(COMPANY_API_ID, this.props.receivedCompanyList);

  componentDidMount() {
    this.props.updateMenu(COMPANIES_MENU_ITEM.text);
    this.api.getData();
  }

  onAddRow = (row) => {
    this.api.onAdd({name: row.name});

  };

  onDeleteRow = (row) => {
    this.api.onDelete(row);

  };

  onCellEdit = (row, fieldName, value) => {
    const {companyList} = this.props;
    const targetRow = companyList.find(prod => prod.id === row.id);
    if (targetRow) {
      targetRow[fieldName] = value;
      this.api.onUpdate(targetRow);
    }
  };


  render() {

    const btnGroup = props => <TableButtonGroup exportCSVBtn={props.exportCSVBtn}
                                                insertBtn={props.insertBtn}
                                                deleteBtn={props.deleteBtn}
                                                onCSVFileLoaded={data => this.api.onAddList(data)} />;


    const options = {
      onAddRow: this.onAddRow,
      onDeleteRow: this.onDeleteRow,
      onCellEdit: this.onCellEdit,
      expandRowBgColor: 'MediumAquamarine',
      btnGroup,
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
        <BootstrapTable data={this.props.companyList}
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
          <TableHeaderColumn width='100' dataField='id' editable={false} isKey export={false} hiddenOnInsert >ID</TableHeaderColumn >
          <TableHeaderColumn dataField='name' >Name</TableHeaderColumn >
        </BootstrapTable >
      </div >

    );
  }
}

export default connect(
  state => ({
    companyList: state.receivedDataReducer.companyList,
  }),
  dispatch => ({
    updateMenu: (focused) => {
      dispatch(updateMenu(focused));
    }, receivedCompanyList: (list) => {
      dispatch(receivedList(list, COMPANY_API_ID));
    },
  })
)(CompanyTable);