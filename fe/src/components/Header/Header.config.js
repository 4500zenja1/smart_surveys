import { Avatar } from 'antd';
import { UserOutlined } from '@ant-design/icons';
import { NavLink } from "react-router-dom";
import { space, verticalCenter, logoStyle } from "./Header.style.js";


const items = (name) => [
    {
        label: (   
            <NavLink to="/home" style={logoStyle}>Smart Surveys</NavLink>            
        ),
        key: 'smartsurveys',
        style: verticalCenter

    },
    {
        label: (
            <NavLink to="/home" >Home</NavLink>
        ),
        key: 'home',
        style: verticalCenter
    },
    
    {
        label: (
            <span></span>
        ),
        key: 'space',
        style: space
    },
    {
        label: (
            <NavLink to="/user/:userId">
                <Avatar size="small" icon={<UserOutlined />}/>
                <span> </span>
                <span>{name}</span>               
            </NavLink>
        ),
        key: 'avatar',
        style: verticalCenter
    }
]

export { items }