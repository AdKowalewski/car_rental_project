
import './Header.css';

import React from "react";


import { Link } from "react-router-dom";
import polandFlag from "../../assets/appImages/poland_flag.png"
import englandFlag from "../../assets/appImages/england_flag.png"
import tank from "../../assets/appImages/tank.png"
import i18n from "../../i18n/i18n"

const Header = ()=> {

    const changeLanguage = (lng) => {
        i18n.changeLanguage(lng).then(r => {});
    }

    return(
        <div className={"container"}>
            <div className={"header"}>
               <Link className={"headerLogo headerItem"} to="/"><img src={tank} alt={"tank"}/></Link>
                <Link className={"headerItem"} to="/">{i18n.t("branches")}</Link>
                <Link className={"headerItem"} to="/fleet">{i18n.t("fleet")}</Link>
                <Link className={"headerItem"} to="/contact">{i18n.t("contact")}</Link>
                <Link className={"headerItem"} to="/login">Login</Link>
                <img onClick={()=>changeLanguage("en")} className={"flag"} src={englandFlag} alt={"england"}/>
                <img onClick={()=>changeLanguage("pl")} className={"flagPoland"} src={polandFlag} alt={"poland"}/>
            </div>
        </div>
    )
}

export default Header;
