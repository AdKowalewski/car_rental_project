import React from "react";
import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";
import mail from "../assets/appImages/icons8-important-mail-50.png";
import phone from "../assets/appImages/icons8-phone-100.png";
import "./Contact.css";
import i18n from "../i18n/i18n"

const Contact =()=>{
    return(
        <div className={"fontFamily"}>
            <Header/>
            <div className={"backgroundContact"}>
                <div className={"contactTitle"}>{i18n.t("contact")}</div>

            </div>
            <div className={"contactInfo"}>
                <div className={"contactInfoRow"}>

            <img className={"iconContact"} src={mail} alt={"mail"}/> <div className={"mail"}>tankRentals@gmail.com</div>
                </div>
                <div className={"contactInfoRow"}>

                    <img className={"iconContact"} src={phone} alt={"phone"}/> <div className={"mail"}>123 456 789</div>
                </div>
            </div>

            <div className={"footerContainer"}>
                <Footer/>
            </div>

        </div>
    )
}
export default Contact;