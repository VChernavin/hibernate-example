// import React from 'react';
// import {getCompanies ,onAdd ,onDelete} from '../api/api'
//
// export class CustomInsertModal extends React.Component {
//
//   handleSaveBtnClick = () => {
//     const { columns, onSave } = this.props;
//     const newRow = {};
//     // columns.
//     console.log(columns);
//     columns.forEach((column, i) => {
//       console.log(column);
//       if (column.field === "name") {
//          onAdd(this.refs[column.field].value);
//         newRow[column.field] = this.refs[column.field].value;
//       }
//     }, this);
//
//     onSave(newRow);
//   };
//
//   render() {
//     const {
//       onModalClose,
//       onSave,
//       columns,
//       validateState,
//       ignoreEditable
//     } = this.props;
//     return (
//       <div  className='modal-content'>
//         <h2 style={ { color: 'red' } }>Custom Insert Modal</h2>
//         <div>
//           {
//             columns.map((column, i) => {
//               const {
//                 editable,
//                 format,
//                 field,
//                 name,
//                 hiddenOnInsert
//               } = column;
//
//               if (hiddenOnInsert) {
//                 // when you want same auto generate value
//                 // and not allow edit, for example ID field
//                 return null;
//               }
//               const error = validateState[field] ?
//                 (<span className='help-block bg-danger'>{ validateState[field] }</span>) :
//                 null;
//               return (
//                 <div className='form-group' key={ field }>
//                   <label>{ name } : </label>
//                   <input className="form-control editor edit-text" ref={ field } type='text' defaultValue={ '' } />
//                   { error }
//                 </div>
//               );
//             })
//           }
//         </div>
//         <div>
//           <button className='btn btn-secondary' onClick={ onModalClose }>Leave</button>
//           <button className='btn btn-primary' onClick={ () => this.handleSaveBtnClick(columns, onSave) }>Confirm</button>
//         </div>
//       </div>
//     );
//   }
// }