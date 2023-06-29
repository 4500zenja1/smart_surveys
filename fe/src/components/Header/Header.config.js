import {Avatar} from 'antd';
import {UserOutlined} from '@ant-design/icons';
import {NavLink} from "react-router-dom";
import {logoStyle, space, verticalCenter} from "./Header.style.js";
import {Trans, useTranslation} from "react-i18next";

function LanguageSelector() {
    const { i18n } = useTranslation();

    const changeLanguage = (event) => {
        i18n.changeLanguage(event.target.value);
    };

    return (
        <select onChange={changeLanguage}>
            <option value="en">EN</option>
            <option value="ru">RU</option>
        </select>
    );
}

const items = (name, t) => [
    {
        label: (   
            <NavLink to="/home" style={logoStyle}>Smart Surveys</NavLink>            
        ),
        key: 'smartsurveys',
        style: verticalCenter

    },
    {
        label: (
            <NavLink to="/home" ><Trans t={t}>home</Trans></NavLink>
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
    },
    {
        label: (
            LanguageSelector()
        ),
        key: 'change_languages',
        style: verticalCenter
    }
]

export { items }