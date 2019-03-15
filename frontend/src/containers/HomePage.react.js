import React from "react";
import {connect} from "react-redux";
import {updateMenu} from "../actions/actions";
import {HOME_PAGE_MENU_ITEM} from "../constants/menuItems";

export class HomePage extends React.Component {

    componentDidMount() {
        this.props.updateMenu(HOME_PAGE_MENU_ITEM.text);
    }

    render() {
        return <div >Home Page</div >
    }
}

export default connect(
    state => ({
        state
    }),
    dispatch => ({
        updateMenu:(focused) => {
            dispatch(updateMenu(focused));
        }
    })
)(HomePage);