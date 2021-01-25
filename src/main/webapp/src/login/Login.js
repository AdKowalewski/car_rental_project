import React from "react";
import axios from "axios";

import "./Login.css";
import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";


class Login extends React.Component {
    constructor() {
        super();
        this.onChange = this.onChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = {
            login: '',
            password: ''
        };
    }

    onChange(e) {
        if (e.target.id === 'login') {
            this.setState({login: e.target.value});
        } else if (e.target.id === 'password') {
            this.setState({password: e.target.value});
        }
    }

    handleSubmit(event) {
        event.preventDefault();

        const user_object = {
            login: this.state.login,
            password: this.state.password
        };

        axios.post('api/login', user_object).then(res => {
            localStorage.setItem("authorization", res.data.token);
            window.location = "/"
        }).catch(function (e) {
            window.alert("wrong credentials")
        });

        this.setState({
            login: '',
            password: ''
        });
    }

    // handleDashboard() {
    //     axios.get("http://localhost:8080/dashboard").then(res => {
    //         if (res.data === "success") {
    //             this.props.history.push("/dashboard");
    //         } else {
    //             alert("Authentication failure");
    //         }
    //     });
    // }


    render() {
        return (
            <div>
                <Header />
                <div className="loginContainer">
                    <form onSubmit={this.handleSubmit}>
                        <label className="loginItem" htmlFor="login">Enter login</label><br/>
                        <input className="loginItem" onChange={this.onChange} id="login" type="text" value={this.state.login} /><br/>
                        <label className="loginItem" htmlFor="password">Enter password</label><br/>
                        <input className="loginItem" onChange={this.onChange} id="password" type="password" value={this.state.password}/><br/>

                        <button>Submit</button>
                    </form>
                    <a id= "register" href={"/register"}>not registered yet? click here</a>

                </div>
                <div className="footerContainer">
                    <Footer/>
                </div>

            </div>
        );
    }
}

export default Login;