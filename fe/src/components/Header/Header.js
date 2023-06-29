import React from 'react';
import {Menu} from 'antd';
import {items} from './Header.config.js'
import {useTranslation} from "react-i18next";

let name ="Sergey Berr"

function Header() {
        const { t } = useTranslation();

        return (
            <Menu selectable={false} theme = "dark" mode = "horizontal" items={items(name, t)}/>
    )
}

export { Header }