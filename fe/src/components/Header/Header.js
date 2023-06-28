import React from 'react';
import { Menu } from 'antd';
import { items } from './Header.config.js'
let name ="Sergey Berr"

function Header() {

        return (
            <Menu selectable={false} theme = "dark" mode = "horizontal" items={items(name)}/>
    )
}

export { Header }