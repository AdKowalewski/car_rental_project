import React from "react";
import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";
import rules from "../assets/appImages/norules.jpg";
import "./UserConditions.css";

const UserConditions =()=>{
    return(
        <div>
            <Header/>
            <div className={"rules"}>
                <img src={rules} alt={"rules"}/>
            </div>
            <Footer/>
        </div>
    )
}
export default UserConditions;