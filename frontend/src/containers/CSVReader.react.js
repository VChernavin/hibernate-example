import React from 'react';
import PropTypes from "prop-types";
import PapaParse from 'papaparse';
import './CSVReader.css';

export default class CSVReader extends React.Component {


  static defaultProps = {
    cssClass: 'none',
    cssInputClass: 'btn btn-success',
    label: null,
    onError: null,
    inputId: null,
    inputStyle: {},
    parserOptions: {
      delimiter: "",	// auto-detect
      newline: "",	// auto-detect
      quoteChar: '"',
      escapeChar: '"',
      header: false,
      transformHeader: undefined,
      dynamicTyping: false,
      preview: 0,
      encoding: "",
      worker: false,
      comments: false,
      step: undefined,
      complete: undefined,
      error: undefined,
      download: false,
      skipEmptyLines: false,
      chunk: undefined,
      fastMode: undefined,
      beforeFirstChunk: undefined,
      withCredentials: undefined,
      transform: undefined,
      delimitersToGuess: [',', '\t', '|', ';', PapaParse.RECORD_SEP, PapaParse.UNIT_SEP]
    }
  };


  render() {


    const createObject = data => {
      const paramNames = [];

      const resultList = [];
      data.forEach((item, index) => {
        if (index === 0) {
          item.forEach(property => paramNames.push(property));
        } else if (item[0] !== "") {
          const tmpObj = {};
          item.forEach((item, index) => {
            tmpObj[paramNames[index]] = item;
          });

          resultList.push(tmpObj);
        }
      });
      return resultList;
    };

    const handleChangeFile = e => {
      let reader = new FileReader();
      const filename = e.target.files[0].name;
      reader.onload = event => {
        const csvData = PapaParse.parse(
          event.target.result,
          Object.assign(this.props.parserOptions, {
            error: this.props.onError
          })
        );
        this.props.onFileLoaded(createObject(csvData.data), filename);
      };

      reader.readAsText(e.target.files[0]);
    };


    return (
    <div className="file btn btn-sm btn-success csv-div" >
      Import CSV
      <input className="csv-input" type="file" name="file" onChange={handleChangeFile}/>
    </div >
    );
  }
}

CSVReader.propTypes = {
  cssClass: PropTypes.string,
  cssInputClass: PropTypes.string,
  label: PropTypes.oneOfType([PropTypes.string, PropTypes.element]),
  onFileLoaded: PropTypes.func.isRequired,
  onError: PropTypes.func,
  inputId: PropTypes.string
};
