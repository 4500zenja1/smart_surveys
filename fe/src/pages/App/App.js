import React from 'react';
import { Layout } from 'antd';
//import { Header } from '../components/header.js';
import { BrowserRouter as Router, Route, Routes,Link } from "react-router-dom";
import { Login, Survey, SurveyList, UsersManager, PersonalAccount} from '../'
import { Header } from '../../components/header';

function App () {
        return (
            <Layout>
                <Router>
                    <Header></Header>
                     
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