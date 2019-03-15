import {UPDATE_MENU} from "../constants/actionTypes";

const menu = {
  focused: 0,
}          ;

export default function menuReducer(state = menu, action = {}){
  switch (action.type) {
    case UPDATE_MENU:
      return {...state,focused: action.focused};
    default:
      return state;
  }
}

