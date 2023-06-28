import React, { useState } from 'react';
import { Menu } from 'antd';
import { items } from './Header.config.js'
import { Avatar } from 'antd';
import { UserOutlined } from '@ant-design/icons';
import { NavLink } from "react-router-dom";

let name ="Sergey Berr"

function Header() {

        return (
            <Menu selectable={false} theme = "dark" mode = "horizontal" items={items(name)}/>
    )
}

export { Header }