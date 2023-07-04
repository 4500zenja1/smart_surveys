import React, { createContext, useState } from 'react'
import axios from 'axios'

const AuthContext = createContext('test');

const AuthProvider = ({children})=>{

const [currentUser,setCurrentUser] = useState('');

const login = async(username,password) =>{
    try{
        const response = await axios.post('http://localhost:8080/auth/signin',{username,password});
        const user = response.data;
        setCurrentUser(user); 
        return  true;
    
    }catch(error){
        alert("User with this userName and password is not found");
        return  false;
    }
    
};

const logout = ()=>{
    setCurrentUser(null);
};

return (
    <AuthContext.Provider value={{currentUser,login,logout}}>
        {children}
    </AuthContext.Provider>
);
};



export {AuthContext,AuthProvider};
