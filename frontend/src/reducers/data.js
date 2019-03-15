import { RECEIVED_LIST} from "../constants/actionTypes";

const data = {
  addressList: [],
  companyList: [],
  officeList: [],
};
export default function receivedDataReducer(state = data, action = {}) {

  switch (action.type) {
    case RECEIVED_LIST:
      return {...state, [action.apiId + 'List']: action.response.data};
    default:
      return state;
  }
}