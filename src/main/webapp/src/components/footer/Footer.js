import {Link} from "react-router-dom";
import i18n from "../../i18n/i18n";
import React from "react";
import facebook from "../../assets/appImages/facebook.png";
import instagram from "../../assets/appImages/instagram.png";
import twitter from "../../assets/appImages/twitter.png";

import "./Footer.css"

const Footer  = ()=> {
    return(
        <div className={"width100"}>
        <div className={"iconsContainer"}>
            <img className={"icon"} src={facebook} alt={"branches"}/>
            <img className={"icon"} src={instagram} alt={"branches"}/>
            <img className={"icon"} src={twitter} alt={"branches"}/>

        </div>

    <div className={"footer"}>
        <Link className={"footerItem"} to={"/"}>{i18n.t("about") }</Link>
        <Link className={"footerItem"} to={"contact"}>{i18n.t("contact")}</Link>
        <Link className={"footerItem"} to={"userConditions"}>{i18n.t("userConditions")}</Link>
        <div className={"footerItem"}>© 2020 Fake rental tanks</div>
    </div>
    </div>

    )
}
export default Footer;