import {RECEIVED_LIST, UPDATE_MENU} from "../constants/actionTypes";

export const updateMenu = (focused) => ({
  type: UPDATE_MENU,
  focused: focused,
});


export const receivedList = (response, apiId) => ({
  type: RECEIVED_LIST,
  response,
  apiId,
});