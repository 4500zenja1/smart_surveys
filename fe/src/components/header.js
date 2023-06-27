import React, {Component} from 'react';
import { Menu, Avatar, Layout } from 'antd';
import { UserOutlined } from '@ant-design/icons';
import { BrowserRouter as Router, Route, Link, NavLink } from "react-router-dom";

let name = "Segey Berr"

const items = [
    {
        label: (   
            <NavLink to="/home" >Smart Surveys</NavLink>            
        ),
        key: 'smartsurveys',

    },
    {
        label: (
            <NavLink to="/home" >Home</NavLink>
        ),
        key: 'home'
    },
    {
        label: (
            <NavLink to="/user/id:">
                <Avatar size="small" icon={<UserOutlined />}/>
                <span>{name}</span>
            </NavLink>
        ),
        key: 'avatar'
    }
]

function Header() {
        return (
            <Layout>                
                
                    <Menu theme = "dark" mode = "horizontal" items={items}/>
                
            </Layout>

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

export {Header}