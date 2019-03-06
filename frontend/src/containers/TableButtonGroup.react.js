import React from "react";
import {ButtonGroup} from "react-bootstrap-table";
import CSVReader from "./CSVReader.react";

export default class TableButtonGroup extends React.Component{


  render() {
    return (
      <ButtonGroup className='my-custom-class' sizeClass='btn-group-sm' >

        <CSVReader onFileLoaded={this.props.onCSVFileLoaded} />
        {this.props.exportCSVBtn}
        {this.props.insertBtn}
        {this.props.deleteBtn}
      </ButtonGroup >
      
    )
  }
}