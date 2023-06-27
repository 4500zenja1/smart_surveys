import React, {Component} from 'react';
import { Menu, Avatar, Layout } from 'antd';
//import { Header } from '../components/header.js';
import { BrowserRouter as Router, Route, Routes, Link, NavLink } from "react-router-dom";
import { Login, Survey, SurveyList, UserManager, PersonalAccount} from './index.js'

function App () {
        return (
            <Layout>
                <Router>
                    {/* <Header></Header> */}

                    <Routes>
                        
                        <Route path="/login" element={<Login/>}/>

                        <Route path="/home" element={<SurveyList/>}/>

                        <Route path="/user/id:" element={<PersonalAccount/>}/>

                        <Route path="/survey/id:" element={<Survey/>}/>

                        <Route path="/users/id:" element={<SurveyList/>}/>
                        
                    </Routes>
                </Router>
            </Layout>
    )
}

export { App }