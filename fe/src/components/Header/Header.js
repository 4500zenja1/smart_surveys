import React from 'react';
import { Menu, Avatar } from 'antd';
import { UserOutlined } from '@ant-design/icons';
import { NavLink } from "react-router-dom";

let name = "Segey Berr"

const space = {
    flex: "auto"
}

const verticalCenter = {
    marginTop: "auto",
    marginBottom: "auto"
}

const items = [
    {
        label: (   
            <NavLink to="/home" style={{fontWeight: 'bold', fontSize: "x-large", color: "#ffffffdb"}}>Smart Surveys</NavLink>            
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

function Header() {
        return (

                    <Menu style = {{textAlign: "baseline"}} selectable={false} theme = "dark" mode = "horizontal" items={items}/>


                // <header style = {{display: "inline"}}>
                //     <h1 style = {{display: "inline"}}>Smart Surveys</h1>
                //     <h2 style = {{display: "inline"}}>Home</h2>
                //     <div >
                //         <Avatar ></Avatar>
                //         <span>{name}</span>
                //     </div>
                // </header>
    )
}

export { Header }