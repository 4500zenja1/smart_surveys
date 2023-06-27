import React, {Component} from 'react';
import { Menu, Avatar, Layout } from 'antd';
//import { Header } from '../components/header.js';
import { BrowserRouter as Router, Route, Routes, Link, NavLink } from "react-router-dom";
import { Login, Survey, SurveyList, UsersManager, PersonalAccount} from '../index.js'

const Somecomponent = () =>{
    return (
        <div>hi</div>
    )
}

function App () {
        return (
            <Layout>
                <Router>
                    {/* <Header></Header> */}

                    <Routes>
                        
                        <Route path="/login" element={<Login/>}/>

                        <Route path="/home" element={<SurveyList/>}/>

                        <Route path="/user/:userId" element={<PersonalAccount/>}/>

                        <Route path="/survey/:surveyId" element={<Survey/>}/>

                        <Route path="/users" element={<UsersManager/>}/>
                        
                        <Route path="/survey" element={<SurveyList/>}/>

                    </Routes>
                </Router>
            </Layout>
    )
}

export { App }