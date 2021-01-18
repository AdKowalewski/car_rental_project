import React from "react";
import axios from "axios";

import "./Register.css";
import Header from "../header/Header";
import Footer from "../footer/Footer";


class Register extends React.Component {
    constructor() {
        super();
        this.onChange = this.onChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = {
            login: '',
            firstName: '',
            lastName: '',
            email: '',
            password: '',
            confirmPassword: '',
        };
    }

    onChange(e) {
        if (e.target.id === 'login') {
            this.setState({login: e.target.value});
        } else if (e.target.id === 'firstName') {
            this.setState({firstName: e.target.value});
        } else if (e.target.id === 'lastName') {
            this.setState({lastName: e.target.value});
        } else if (e.target.id === 'email') {
            this.setState({email: e.target.value});
        } else if (e.target.id === 'password') {
            this.setState({password: e.target.value});
        } else if (e.target.id === 'confirmPassword') {
            this.setState({confirmPassword: e.target.value});
        }
    }


    clearState() {
        this.setState({
            login: '',
            firstName: '',
            lastName: '',
            email: '',
            password: '',
            confirmPassword: '',
        });
    }

    handleSubmit(event) {
        event.preventDefault();

        let user_object = {
            login: this.state.login,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email,
            password: this.state.password,
        };

        if (this.state.password !== this.state.confirmPassword) {
            alert("password and confirm password doesn't match")
            this.setState({password: '', confirmPassword: ''})
            return;
        }

        if (this.state.password.length < 5) {
            alert("password length lower than 5 characters")
            this.setState({password: '', confirmPassword: ''})
            return;
        }

        const bcrypt = require('bcryptjs');
        const salt = bcrypt.genSaltSync(10);
        user_object.password = bcrypt.hashSync(user_object.password, salt);

        axios.post('/register', user_object).then(res => {
            if(res.data.fail === true){
                alert("OJ OJ OJ")
                this.clearState();
                return;
            }

            window.location = "/"
        }).catch(function (e) {
            window.alert("error: " + e.toString())
        });
        this.clearState();
    }

    render() {
        return (
                <div>
                    <Header/>
                    <div className="registerContainer">
                        <form onSubmit={this.handleSubmit}>

                            <label className="loginItem" htmlFor="login" >Enter login</label><br/>
                            <input className="loginItem" onChange={this.onChange} id="login" type="text"
                                   value={this.state.login} required={true}/><br/>

                            <label className="loginItem" htmlFor="firstName">Enter first name</label><br/>
                            <input className="loginItem" onChange={this.onChange} id="firstName" type="text"
                                   value={this.state.firstName} required={true}/><br/>

                            <label className="loginItem" htmlFor="lastName">Enter last name</label><br/>
                            <input className="loginItem" onChange={this.onChange} id="lastName" type="text"
                                   value={this.state.lastName} required={true}/><br/>

                            <label className="loginItem" htmlFor="email">Enter email</label><br/>
                            <input className="loginItem" onChange={this.onChange} id="email" type="email"
                                   value={this.state.email} required={true}/><br/>

                            <label className="loginItem" htmlFor="password">Enter password</label><br/>
                            <input className="loginItem" onChange={this.onChange} id="password" type="password"
                                   value={this.state.password} required={true}/><br/>

                            <label className="loginItem" htmlFor="confirmPassword">Confirm password</label><br/>
                            <input className="loginItem" onChange={this.onChange} id="confirmPassword" type="password"
                                   value={this.state.confirmPassword} required={true}/><br/>

                            <button>Submit</button>

                        </form>


                    </div>
                    <div className="footerContainer">
                        <Footer/>
                    </div>
                </div>

        );
    }
}

export default Register;