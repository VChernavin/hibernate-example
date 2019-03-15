import { combineReducers } from "redux";
import { reducer as formReducer } from "redux-form";
import menuReducer from "./menu";
import receivedDataReducer from "./data";


const rootReducer = combineReducers({
  receivedDataReducer: receivedDataReducer,
  menuReducer,
  form: formReducer
  // Add your reducers here
});

export default rootReducer;